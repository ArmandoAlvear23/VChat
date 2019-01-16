package vchat_client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Armando, Carlos, Sebastian
 */
public class VchatClient {
    
    private VchatClientController chatClient;
    private String host = "localhost";
    private Socket socket;
    private PrintWriter output;
    private BufferedReader read;
    private int result = 2;
    final int port = 1337;
    private String fName = "";
    private String lName = "";
    private String email = "";
    private static String userName = "";

    public void connect(String ip, String id, String pass) {
        
        System.out.println(":::Start vchat_client-VchatClient-connect:::");
        System.out.println("Attempting to connect to server with ip address: " + ip);
            
        try {
            
            //Declare a new Socket
            socket = new Socket(ip, port);
       
            //Connected to server
            System.out.println("You are connected to server with IP Address: " + ip);
            
            //Sending login data to server
            output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            output.println("signIn");
            output.println(id);
            output.println(pass);
            output.flush();
            
            //Receiving login authentication from server
            read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String loginAuth = read.readLine();
            result = Integer.parseInt(loginAuth); 

            if(getResult() == 1){
                
                System.out.println("Login Successful!");
                fName = read.readLine();
                lName = read.readLine();
                email = read.readLine();
                userName = fName + " " + lName;
                
                try {
                    
                    chatClient = new VchatClientController(socket);
                    Thread t = new Thread((Runnable) getChatClient());
                    t.start();
                    
                }catch (Exception e){
                    e.printStackTrace();
                }
                
            }
            else if (getResult() == 0){
                
                System.out.println("Login Unsuccessful! Wrong ID or password.");
                
            }
           
        } catch(Exception e) {
            
            System.out.println(e);
            System.out.println("Server not responding...");
            System.exit(0);
            
        }
        
    }
    
    public void connectCA(String ip, String id, String fn, String ln, 
            String em, String passw){
        
        try {
            
            //Connect to the server
            socket = new Socket(ip, port);
            
            //Sending createAccount data to server
            output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            output.println("createAccount");
            output.println(id);
            output.println(fn);
            output.println(ln);
            output.println(passw);
            output.println(em);
            output.flush();
            
            //Receiving create account data from server
            read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String createAc = read.readLine();
            result = Integer.parseInt(createAc); 
            System.out.println("Result: " + result);

            if(getResult() == 1){
                
                System.out.println("User already has an account!");
                fName = read.readLine();
                lName = read.readLine();
                email = read.readLine();
                userName = fName + " " + lName;
                  
            }
            else if (getResult() == 0){
                
                System.out.println("Creating Account...");
                
            }

        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void connectFP(String ip, String em){
        
        try {
            
            //Connect to Server
            socket = new Socket(ip, port);
            
            //Sending createAccount data to server
            output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            output.println("forgotPW");
            output.println(em);
            output.flush();
            
            //Receiving create account data from server
            read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String forgotPass = read.readLine();
            result = Integer.parseInt(forgotPass); 
            System.out.println("Result: " + result);

            if(getResult() == 1){
                
                fName = read.readLine();
                lName = read.readLine();
                userName = fName + " " + lName;
                System.out.println("Password has been sent to: " + em);
                
            }
            else if (getResult() == 0){
                
                System.out.println("Email doesn't exist.");
                
            }

        } catch(Exception e){
            e.printStackTrace();
        }
   
    }
    
    /**
     * @return the chatClient
     */
    public VchatClientController getChatClient() {
        return chatClient;
    }

    /**
     * @param aChatClient the chatClient to set
     */
    public void setChatClient(VchatClientController aChatClient) {
        chatClient = aChatClient;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the userName
     */
    public static String getUserName() {
        return userName;
    }
    
}
