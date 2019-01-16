package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class CreateAccount extends Pane {
    
    protected final Label fNameLabel;
    protected final Label lNameLable;
    protected final Label emailLabel;
    protected final Label idLabel;
    protected final Label passwordLabel;
    private final TextField fNameTF;
    private final TextField lNameTF;
    private final TextField emailTF;
    private final TextField idTF;
    private final PasswordField passwordTF;
    private final Button createAccountBtn;
    protected final DropShadow dropShadow;
    private final Button backBtn;
    protected final Label fNameLabel1;

    public CreateAccount() {

        fNameLabel = new Label();
        lNameLable = new Label();
        emailLabel = new Label();
        idLabel = new Label();
        passwordLabel = new Label();
        fNameTF = new TextField();
        lNameTF = new TextField();
        emailTF = new TextField();
        idTF = new TextField();
        passwordTF = new PasswordField();
        createAccountBtn = new Button();
        dropShadow = new DropShadow();
        backBtn = new Button();
        fNameLabel1 = new Label();

        setFocusTraversable(true);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(400.0);

        fNameLabel.setLayoutX(30.0);
        fNameLabel.setLayoutY(100.0);
        fNameLabel.setText("First Name:");
        fNameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        fNameLabel.setFont(new Font(18.0));

        lNameLable.setLayoutX(32.0);
        lNameLable.setLayoutY(140.0);
        lNameLable.setText("Last Name:");
        lNameLable.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lNameLable.setFont(new Font(18.0));

        emailLabel.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        emailLabel.setLayoutX(74.0);
        emailLabel.setLayoutY(180.0);
        emailLabel.setText("Email:");
        emailLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        emailLabel.setFont(new Font(18.0));

        idLabel.setLayoutX(100.0);
        idLabel.setLayoutY(220.0);
        idLabel.setPrefHeight(27.0);
        idLabel.setPrefWidth(26.0);
        idLabel.setText("ID:");
        idLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        idLabel.setFont(new Font(18.0));

        passwordLabel.setLayoutX(43.0);
        passwordLabel.setLayoutY(260.0);
        passwordLabel.setText("Password:");
        passwordLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        passwordLabel.setFont(new Font(18.0));

        fNameTF.setLayoutX(125.0);
        fNameTF.setLayoutY(100.0);
        fNameTF.setPrefHeight(27.0);
        fNameTF.setPrefWidth(200.0);
        fNameTF.setPromptText("enter First Name");

        lNameTF.setLayoutX(125.0);
        lNameTF.setLayoutY(138.0);
        lNameTF.setPrefHeight(27.0);
        lNameTF.setPrefWidth(200.0);
        lNameTF.setPromptText("enter Last Name");

        emailTF.setLayoutX(125.0);
        emailTF.setLayoutY(180.0);
        emailTF.setPrefHeight(27.0);
        emailTF.setPrefWidth(200.0);
        emailTF.setPromptText("enter Student Email");

        idTF.setLayoutX(125.0);
        idTF.setLayoutY(220.0);
        idTF.setPrefHeight(27.0);
        idTF.setPrefWidth(200.0);
        idTF.setPromptText("enter Student ID");

        passwordTF.setLayoutX(125.0);
        passwordTF.setLayoutY(260.0);
        passwordTF.setPrefHeight(27.0);
        passwordTF.setPrefWidth(200.0);
        passwordTF.setPromptText("enter Password");

        createAccountBtn.setDefaultButton(true);
        createAccountBtn.setLayoutX(148.0);
        createAccountBtn.setLayoutY(308.0);
        createAccountBtn.setMnemonicParsing(false);
//        createAccountBtn.setOnAction(this::createAccountAction);
        createAccountBtn.setText("Create Account");
        createAccountBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        createAccountBtn.setFont(new Font(18.0));

        createAccountBtn.setEffect(dropShadow);

        backBtn.setCancelButton(true);
        backBtn.setLayoutX(197.0);
        backBtn.setLayoutY(356.0);
        backBtn.setMnemonicParsing(false);
//        backBtn.setOnAction(this::goBackAction);
        backBtn.setText("Back");
        backBtn.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        backBtn.setFont(new Font(14.0));

        fNameLabel1.setLayoutX(137.0);
        fNameLabel1.setLayoutY(31.0);
        fNameLabel1.setText("Sign Up");
        fNameLabel1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        fNameLabel1.setTextFill(javafx.scene.paint.Color.valueOf("#d78614"));
        fNameLabel1.setFont(new Font("System Bold", 36.0));

        getChildren().add(fNameLabel);
        getChildren().add(lNameLable);
        getChildren().add(emailLabel);
        getChildren().add(idLabel);
        getChildren().add(passwordLabel);
        getChildren().add(fNameTF);
        getChildren().add(lNameTF);
        getChildren().add(emailTF);
        getChildren().add(idTF);
        getChildren().add(passwordTF);
        getChildren().add(createAccountBtn);
        getChildren().add(backBtn);
        getChildren().add(fNameLabel1);

    }
    
        /**
     * @return the fNameTF
     */
    public TextField getfNameTF() {
        return fNameTF;
    }

    /**
     * @return the lNameTF
     */
    public TextField getlNameTF() {
        return lNameTF;
    }

    /**
     * @return the emailTF
     */
    public TextField getEmailTF() {
        return emailTF;
    }

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
     * @return the createAccountBtn
     */
    public Button getCreateAccountBtn() {
        return createAccountBtn;
    }

    /**
     * @return the backBtn
     */
    public Button getBackBtn() {
        return backBtn;
    }

    /*
    protected abstract void createAccountAction(javafx.event.ActionEvent actionEvent);

    protected abstract void goBackAction(javafx.event.ActionEvent actionEvent);
    */
}
