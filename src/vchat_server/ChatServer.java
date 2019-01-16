package vchat_server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DBHandler;
import email.SendEmail;

public class ChatServer {
    
    public static ArrayList<Socket> connectionArray = new ArrayList<>();
    public static ArrayList<String> currentUsers = new ArrayList<>();
    private static ServerSocket serverSocket;
    private static Socket client;
    private static BufferedReader input;
    private static PrintWriter output;
    private static final int port = 1337;
    private static String result;
    private static String fName = "";
    private static String lName = "";
    private static String email = "";
    private static String userName = "";
    private static String pass = "";
       
    //Database
    private static DBHandler handler;
    private Connection connection;
    private PreparedStatement pst;

    public void start() throws IOException{
        System.out.println("::::::::::::::::Server::::::::::::::::");
        System.out.println("Connection starting on port: " + port);
        try {
            
            //Create connection to client on specified port
            serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client(s)...");
            
            while(true){
                
                client = serverSocket.accept();
                connectionArray.add(client);
                System.out.println("\nClient connected from: " + 
                client.getRemoteSocketAddress().toString().trim());
                
                try {
                    
                    input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String choice = input.readLine();
                
                if (choice.equals("signIn")) {
                    
                    try {
                        
                        loginAuthentication();
                        
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    
                addUserName(client);
                
                ChatServerReturn chat = new ChatServerReturn(client);
                
                Thread thread = new Thread(chat);
                thread.start(); 
                    
                }
                else if(choice.equals("createAccount")){
                    
                    try{
                        
                        createAccount();
                        
                    } catch(Exception e){
                        e.printStackTrace();
                    }
                        
                }
                else if(choice.equals("forgotPW")){
                    
                    try {
                        forgotPW();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    
                }
                    
                }catch (Exception e){
                    e.printStackTrace();
                }
                
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
          
    }
    
    public void loginAuthentication() throws Exception{
        
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        
        String id = "";
        String pass = "";
        
        //Getting login information from client
        id = input.readLine();
        pass = input.readLine();
        
        //Testing info gathered
        System.out.println("User ID received from client: " + id);
        //System.out.println("User password received from client: " + pass);
        
        handler = new DBHandler();
        connection = handler.getConnection();
        
        String q1 = "SELECT * FROM students WHERE ID=? AND password=?";
        
        try{
            
            pst = connection.prepareStatement(q1);
            pst.setString(1, id);
            pst.setString(2, pass);

            ResultSet rs = pst.executeQuery();

            int count = 0;
        
        
            while(rs.next()){
                
                count = count + 1;
                fName = rs.getString(2);
                lName = rs.getString(3);
                email = rs.getString(5); 
                
            }
            
            if(count==1){
                userName = fName + " " + lName;
                //send int 1 to client
                System.out.println(userName + " has connected...");
                result = "1";      
                output.println(result);
                output.println(fName);
                output.println(lName);
                output.println(email);
                output.flush();

            }
            else {

                //send int 0 to client
                System.out.println("Username or Password is incorrect...\n");
                result = "0";
                output.println(result);
                output.flush();

            }
        
        } catch (Exception e){
            e.printStackTrace();
        }
        
        finally {
            try {
                
                connection.close();
                
            } catch (SQLException e1){
                e1.printStackTrace();
            }
            
        }
        
    }
    
    public void createAccount() throws Exception{
        
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        
        String id = "";        
        String fn = "";
        String ln = "";
        String passw = "";
        String em = "";
        
        //Getting login information from client
        id = input.readLine();
        System.out.println(id);
        fn = input.readLine();
        System.out.println(fn);
        ln = input.readLine();
        System.out.println(ln);
        passw = input.readLine();
        System.out.println(passw);
        em = input.readLine();
        System.out.println(em);
        
        handler = new DBHandler();
        connection = handler.getConnection();
        
        String q1 = "SELECT * FROM students WHERE ID=?";
        
        try {
            pst = connection.prepareStatement(q1);
            pst.setString(1, id);

            ResultSet rs = pst.executeQuery();

            int count = 0;
        
        
            while(rs.next()){
                
                count = count + 1;
                fName = rs.getString(2);
                lName = rs.getString(3);
                email = rs.getString(5);
                
            }
            
            if(count==1){
                
                //send int 1 to client
                System.out.println("User already has an account!");
                result = "1";      
                output.println(result);
                output.println(fName);
                output.println(lName);
                output.println(email);
                output.flush();
                userName = fName + " " + lName;
                
            }
            else{
                
                //send int 0 to client
                System.out.println("User not found.\nCreating account...");
                result = "0";
                output.println(result);
                output.flush();
                handler = new DBHandler();
                connection = handler.getConnection();
                String insert = "INSERT INTO students(ID,firstName,lastName,password"
                    + ",email)VALUES(?,?,?,?,?)";
                
                try {
                    
                pst = connection.prepareStatement(insert);
                
                } catch (SQLException e){
                    e.printStackTrace();
                }
                
                try {
                    
                    pst.setString(1, id);
                    pst.setString(2, fn);
                    pst.setString(3, ln);
                    pst.setString(4, passw);
                    pst.setString(5, em);
                    pst.executeUpdate();

                } catch(SQLException e) {
                    e.printStackTrace();
                }
                
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        finally {
            
            try {
                
                connection.close();
                
            } catch (SQLException e){
                e.printStackTrace();
            }
            
        }
  
    }
    
    public void forgotPW() throws Exception{
        
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        String em = "";
        em = input.readLine();
        
        handler = new DBHandler();
        connection = handler.getConnection();
        
        String q1 = "SELECT * FROM students WHERE email=?";
        
        try {
            
            pst = connection.prepareStatement(q1);
            pst.setString(1, em);

            ResultSet rs = pst.executeQuery();

            int count = 0;
        
            while(rs.next()){
                
                count = count + 1;
                fName = rs.getString(2);
                lName = rs.getString(3);
                pass = rs.getString(4);
                email = rs.getString(5);
                
            }
            
            if(count==1){
                
                //send int 1 to client
                System.out.println("Email found!");
                System.out.println("Preparing to send password through email...");
                result = "1";
                output.println(result);
                output.println(fName);
                output.println(lName);
                output.flush();
                userName = fName + " " + lName;
                SendEmail sendEmail = new SendEmail();
                sendEmail.sendPassword(email, pass, userName);
                
            }
            else{
                
                //send int 0 to client
                System.out.println("Email: " + em + " does not exist...");
                result = "0";
                output.println(result);
                output.flush();
                
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        finally {
            try {
                
                connection.close();
                
            } catch (SQLException e1){
                e1.printStackTrace();
            }
            
        }
        
    }
    
    /** 
     * Method which takes in a socket input, then creates and adds a user name
     * based off input.
     * 
     * @param socket the socket of a client
     * @throws IOException 
     */
    public static void addUserName(Socket socket) throws IOException {
        
        currentUsers.add(userName);
        for (int i = 0; i < connectionArray.size(); i++) {
            
            Socket tempSocket = connectionArray.get(i);
            output = new PrintWriter(tempSocket.getOutputStream());
            output.println("#?!" + currentUsers);
            output.flush();
            
        }
        
    }
    
    public static void main(String [] args){
        
        ChatServer server = new ChatServer();
        try {
            
            server.start();
            
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }
    
}
