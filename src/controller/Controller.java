package controller;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import view.*;
import vchat_client.*;

/**
 *
 * @author Armando, Carlos, Sebastian
 */
public class Controller {
    
    private static SignIn signIn = new SignIn();
    private static CreateAccount createAccount = new CreateAccount();
    private static Chatroom chatroom = new Chatroom();
    private static VchatClient client = new VchatClient();
    private static Stage stage = new Stage();
    private int ca_count = 0;
    private int cr_count = 0;
    private String id = "";
    private String password = "";
    private String ip = "";
    private String fName = "";
    private String lName = "";
    private static String userName = "";
    private String email = "";
    int result = 2;
    
    public Controller(SignIn signIn, CreateAccount createAccount, Chatroom chatroom, VchatClient client) {
        
        this.signIn = signIn;
        this.createAccount = createAccount;
        this.chatroom = chatroom;
        this.client = client;
        attachHandlers();  
        
    }
    
    public void attachHandlers(){

        signIn.getLoginBtn().setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                
                System.out.println(":::Start controller-signIn-Login Button:::");
              
                //Gets information from GUI
                id = signIn.getIdTF().getText().trim();
                password = signIn.getPasswordTF().getText().trim();
                ip = signIn.getIpTF().getText().trim();
               
                //communicating to client
                System.out.println("testing IP: " + ip);
                client.connect(ip, id, password);
               
                if(client.getResult() == 0){
                   
                   Alert alert = new Alert(AlertType.INFORMATION);
                   alert.setTitle("VChat - Login Unsuccessful!");
                   alert.setHeaderText(null);
                   alert.setContentText("Wrong ID or password.\nPlease try again or create an account.");
                   alert.showAndWait();
                   
               }
               else if (client.getResult() == 1){
                   
                    signIn.getScene().getWindow().hide(); 
                    
                    if (cr_count == 0){
                        
                        fName = client.getfName();
                        lName = client.getlName();
                        email = client.getEmail();
                        userName = fName + " " + lName;
                        System.out.println(userName + " "+ email);
                        Scene scene = new Scene(chatroom, 600,400);
                        stage.setScene(scene);
                        stage.setTitle("VChat - Lobby");
                        chatroom.getUserCRLabel().setText("User: "+ userName);
                        chatroom.getIdCRLabel().setText("    ID: "+id);
                        chatroom.getChatroomNameLabel().setText("Chatroom: Lobby");
                        stage.setResizable(false);
                        stage.show();
                        cr_count++;
                        
                    }
                    else if (cr_count > 0){
                        
                        stage.setScene(chatroom.getScene());
                        stage.setTitle("VChat Lobby");
                        chatroom.getUserCRLabel().setText("User: "+ userName);
                        chatroom.getIdCRLabel().setText("    ID: "+id);
                        chatroom.getChatroomNameLabel().setText("Chatroom: Lobby");
                        stage.setResizable(false);
                        stage.show();
                        
                    }
                    
               }
                
            }
            
        });
        
        signIn.getCreateAccountBtn().setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                
                signIn.getScene().getWindow().hide();      
                if (ca_count == 0){
                    
                    Scene scene = new Scene(createAccount, 400,400);
                    stage.setScene(scene);
                    stage.setTitle("Sign-Up");
                    stage.setResizable(false);
                    stage.show();
                    ca_count++;
                    
                }
                else if(ca_count > 0){
                    
                    stage.setScene(getCreateAccount().getScene());
                    stage.setTitle("Sign-Up");
                    stage.setResizable(false);
                    stage.show();
                    
                }
                
            } 
            
        });
        
        signIn.getForgot_pwHL().setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                
                //Enter Email
                TextInputDialog dialog = new TextInputDialog("");
                dialog.setTitle("VChat - Forgot Password");
                dialog.setHeaderText(null);
                dialog.setContentText("Enter your email: ");
                Optional<String> result = dialog.showAndWait();
                
                if(result.isPresent()){
                    
                    email = result.get().trim();
                    
                }
                
                if(ip.equals("")){
                    
                    //Enter IP Address
                    TextInputDialog dialog2 = new TextInputDialog("");
                    dialog2.setTitle("VChat - IP Address");
                    dialog2.setHeaderText(null);
                    dialog2.setContentText("Enter Server's IP Address: ");
                    Optional<String> result2 = dialog2.showAndWait();
                    
                    if(result2.isPresent()){
                        
                        ip = result2.get().trim();
                        
                    }
                }
                
                System.out.println("testing IP: " + ip);
                client.connectFP(ip, email);
               
               if(client.getResult() == 0){
                   
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("VChat - Email Not Found!");
                    alert.setHeaderText(null);
                    alert.setContentText("Email [" + email + "] not found."
                           + "\nPlease try again.");
                    alert.showAndWait();
                   
               }
               else if (client.getResult() == 1){
                   
                   Alert alert2 = new Alert(AlertType.INFORMATION);
                   alert2.setTitle("VChat - Email Sent");
                   alert2.setHeaderText(null);
                   alert2.setContentText("Password has been sent to email: "
                           + email);
                   alert2.showAndWait();
                   
               }    
                
            }
            
        });
        
        createAccount.getCreateAccountBtn().setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                
                //Input ip Address
                if(ip.equals("")){
                    
                    TextInputDialog dialog = new TextInputDialog("");
                    dialog.setTitle("VChat - IP Address");
                    dialog.setHeaderText(null);
                    dialog.setContentText("Enter Server's IP Address: ");
                    Optional<String> result = dialog.showAndWait();
                    
                    if(result.isPresent()){
                        
                        ip = result.get().trim();
                        
                    }
                }
                
                System.out.println("ip address: " + ip);
                
                //Getting data from createAccount text fields
                String fName = "";
                String lName = "";
                String email = "";
                String id = "";
                String pass = "";
                String userName = "";
                
                fName = createAccount.getfNameTF().getText().trim();
                lName = createAccount.getlNameTF().getText().trim();
                email = createAccount.getEmailTF().getText().trim();
                id = createAccount.getIdTF().getText().trim();
                pass = createAccount.getPasswordTF().getText().trim();
                userName = fName + " " + lName;
                
                //Sending data to client
                client.connectCA(ip, id, fName, lName, email, pass);
                        
                if(client.getResult() == 0){
                    
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("VChat - Welcome " + userName);
                    alert.setHeaderText(null);
                    alert.setContentText("Congratulations " + userName + "!"
                           + "\nYou have successfully created a VChat account.");
                    alert.showAndWait();
                    createAccount.getScene().getWindow().hide();
                    stage.setScene(getSignIn().getScene());
                    stage.setTitle("Sign-In");
                    stage.setResizable(false);
                    stage.show();
                   
               }
               else if (client.getResult() == 1){
                   
                   Alert alert = new Alert(AlertType.INFORMATION);
                   alert.setTitle("VChat - Duplicate Account");
                   alert.setHeaderText(null);
                   alert.setContentText("ID already exists.\nPlease make sure you typed your ID correctly.");
                   alert.showAndWait(); 
                   
               }

            }    
            
        });
        
        createAccount.getBackBtn().setOnAction(new EventHandler<ActionEvent>(){
           
            @Override
            public void handle(ActionEvent event) {
                
                createAccount.getScene().getWindow().hide();
                stage.setScene(getSignIn().getScene());
                stage.setTitle("Sign-In");
                stage.setResizable(false);
                stage.show();
                
            }
            
        });
        
        chatroom.getSendBtn().setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                
                if(!chatroom.getMessageTF().getText().equals("")){
                    
                    client.getChatClient().send(chatroom.getMessageTF().getText());
                    chatroom.getMessageTF().requestFocus();
                    
                }
                
            }
            
        });
        
        chatroom.getsignOutBtn().setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                
                try {
                    client.getChatClient().disconnect();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("VChat - Sign-Out");
                    alert.setHeaderText(null);
                    alert.setContentText("You have succesfully signed-out as " + userName+"."
                    +"\nGood-bye!");
                    alert.showAndWait();
                    System.exit(0);
                    
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
    }

    /**
     * @return the signIn
     */
    public static SignIn getSignIn() {
        return signIn;
    }

    /**
     * @return the createAccount
     */
    public static CreateAccount getCreateAccount() {
        return createAccount;
    }

    /**
     * @return the chatroom
     */
    public static Chatroom getChatroom() {
        return chatroom;
    }

    /**
     * @return the client
     */
    public static VchatClient getClient() {
        return client;
    }
    
}  

