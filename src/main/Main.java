package main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vchat_client.VchatClient;
import view.Chatroom;
import view.CreateAccount;
import view.SignIn;
import controller.Controller;

/**
 *
 * @author Armando, Carlos, Sebastian
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage){
        
        try {
            
            SignIn signIn = new SignIn();
            CreateAccount createAccount = new CreateAccount();
            Chatroom chatroom = new Chatroom();
            VchatClient client = new VchatClient();            
            Controller c = new Controller(signIn, createAccount, chatroom, client);

            Pane root = (Pane) signIn;
            Scene scene = new Scene(root, 432, 460);
            primaryStage.setTitle("Sign-In");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);

        }catch (Exception e) {
            
            e.printStackTrace();
            
        } 
        
    }
    
    public static void main(String[] args){
        
        launch(args);
        
    }
    
}
