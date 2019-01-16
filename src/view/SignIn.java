package view;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class SignIn extends Pane {

    private final TextField idTF;
    private final PasswordField passwordTF;
    private TextField ipTF;
    private final Button loginBtn;
    protected final DropShadow dropShadow;
    private final Button createAccountBtn;
    private final Hyperlink forgot_pwHL;
    protected final Label idLabel;
    protected final Label label;
    protected final ImageView signinLogo;
    protected final Label label0;

    public SignIn() {

        idTF = new TextField();
        passwordTF = new PasswordField();
        ipTF = new TextField();
        loginBtn = new Button();
        dropShadow = new DropShadow();
        createAccountBtn = new Button();
        forgot_pwHL = new Hyperlink();
        idLabel = new Label();
        label = new Label();
        signinLogo = new ImageView();
        label0 = new Label();

        //setId("loginPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(460.0);
        setPrefWidth(432.0);

        idTF.setLayoutX(124.0);
        idTF.setLayoutY(160.0);
        idTF.setPrefHeight(46.0);
        idTF.setPrefWidth(182.0);
        idTF.setPromptText("enter Student ID");

        passwordTF.setLayoutX(126.0);
        passwordTF.setLayoutY(218.0);
//        passwordTF.setOnKeyPressed(this::loginOnEnter);
        passwordTF.setPrefHeight(46.0);
        passwordTF.setPrefWidth(182.0);
        passwordTF.setPromptText("enter Password");

        ipTF.setLayoutX(127.0);
        ipTF.setLayoutY(273.0);
        ipTF.setPrefHeight(46.0);
        ipTF.setPrefWidth(182.0);
        ipTF.setPromptText("enter IP Address");

        loginBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        loginBtn.setDefaultButton(true);
        loginBtn.setLayoutX(144.0);
        loginBtn.setLayoutY(333.0);
        loginBtn.setMnemonicParsing(false);
//        loginBtn.setOnAction(this::signIn);
        loginBtn.setPrefHeight(46.0);
        loginBtn.setPrefWidth(147.0);
        loginBtn.setText("Login");
        loginBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        loginBtn.setWrapText(true);
        loginBtn.setFont(new Font("System Bold", 14.0));
        loginBtn.setOpaqueInsets(new Insets(0.0));
        loginBtn.setCursor(Cursor.HAND);

        loginBtn.setEffect(dropShadow);

        createAccountBtn.setLayoutX(144.0);
        createAccountBtn.setLayoutY(391.0);
        createAccountBtn.setMnemonicParsing(false);
//        createAccountBtn.setOnAction(this::createAccount);
        createAccountBtn.setPrefHeight(32.0);
        createAccountBtn.setPrefWidth(147.0);
        createAccountBtn.setText("Create Account");
        createAccountBtn.setCursor(Cursor.HAND);

        forgot_pwHL.setLayoutX(189.0);
        forgot_pwHL.setLayoutY(423.0);
        forgot_pwHL.setText("Forgot Password?");
        forgot_pwHL.setUnderline(true);

        idLabel.setLayoutX(56.0);
        idLabel.setLayoutY(175.0);
        idLabel.setText("Student ID:");

        label.setId("passwordLabel");
        label.setLayoutX(62.0);
        label.setLayoutY(232.0);
        label.setText("Password:");

        signinLogo.setFitHeight(100.0);
        signinLogo.setFitWidth(225.0);
        signinLogo.setLayoutX(115.0);
        signinLogo.setLayoutY(46.0);
        signinLogo.setPickOnBounds(true);
        signinLogo.setPreserveRatio(true);
        signinLogo.setImage(new Image(getClass().getResource("VChat_splash.png").toExternalForm()));

        label0.setId("passwordLabel");
        label0.setLayoutX(56.0);
        label0.setLayoutY(287.0);
        label0.setText("IP Address:");

        getChildren().add(idTF);
        getChildren().add(passwordTF);
        getChildren().add(ipTF);
        getChildren().add(loginBtn);
        getChildren().add(createAccountBtn);
        getChildren().add(forgot_pwHL);
        getChildren().add(idLabel);
        getChildren().add(label);
        getChildren().add(signinLogo);
        getChildren().add(label0);

    }

    
    /*
    protected abstract void loginOnEnter(javafx.scene.input.KeyEvent keyEvent);

    protected abstract void signIn(javafx.event.ActionEvent actionEvent);

    protected abstract void createAccount(javafx.event.ActionEvent actionEvent);
*/

    /**
     * @return the idTF
     */
    public TextField getIdTF() {
        return idTF;
    }

    /**
     * @return the passwordTF
     */
    public PasswordField getPasswordTF() {
        return passwordTF;
    }

    /**
     * @return the ipTF
     */
    public TextField getIpTF() {
        return ipTF;
    }

    /**
     * @return the loginBtn
     */
    public Button getLoginBtn() {
        return loginBtn;
    }

    /**
     * @return the forgot_pwHL
     */
    public Hyperlink getForgot_pwHL() {
        return forgot_pwHL;
    }

    /**
     * @return the createAccountBtn
     */
    public Button getCreateAccountBtn() {
        return createAccountBtn;
    }
}
