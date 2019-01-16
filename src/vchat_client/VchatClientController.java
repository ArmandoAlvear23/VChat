package vchat_client;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import controller.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Armando, Carlos, Sebastian
 */
public class VchatClientController implements Runnable{
    
    //Globals
    Socket socket;
    Scanner input;
    Scanner send = new Scanner(System.in);
    PrintWriter output;
    private ObservableList<String> onlineUsers = FXCollections.observableArrayList();


    /**
     * Simple constructor which takes a client socket and assigns it to a local
     * variable socket.
     * 
     * @param s Socket taken from the client.
     */
    public VchatClientController(Socket s) {
        this.socket = s;
    }

    /**
     * Infinite loop which runs as long as the socket is not closed.
     */
    public void run() {
        try {
            try {
                
                input = new Scanner(socket.getInputStream());
                output = new PrintWriter(socket.getOutputStream());
                output.flush();
                checkStream();
                
            }
            finally {
                
                socket.close();
                
            }
            
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * A method which calls the receive method as long as the client is
     * connected.
     */
    public void checkStream() {
        while (true) {
            receive();
        }                
    }
    
    /**
     * A method which waits for client messages and appends them to the
     * conversation.
     */
    public void receive() {
        if (input.hasNext()) {
            String message = input.nextLine();

            if(message.contains("#?!")){
                
                String temp = message.substring(3);
                temp = temp.replace("[", "");
                temp = temp.replace("]", "");                    
                String[] currentUsers = temp.split(", ");                
                Controller.getChatroom().getOnlineList().getItems().clear();
                
                for (int i = 0; i < currentUsers.length;i++){
                    
                    onlineUsers.add(currentUsers[i]);  
                    
                }
                
                Controller.getChatroom().getOnlineList().setItems(onlineUsers);
                
            }
            else {
                
                Controller.getChatroom().getChatTA().appendText(message + "\n");
                
            }
            
        }
        
    }
    
    /**
     * A method which sends the user's message to the chat.
     * @param s 
     */
    public void send(String s) {
        
        output.println(VchatClient.getUserName() + ": " + s);
        output.flush();
        Controller.getChatroom().getMessageTF().setText("");
        
    }

    /**
     * A method which disconnects the user from the chat room.
     * @throws IOException 
     */
    public void disconnect() throws IOException {
        
        output.println(VchatClient.getUserName() + " has disconnected...");                 
        output.flush();
        socket.close();
        System.exit(0);

    }
    
}
    
