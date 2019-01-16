package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Chatroom extends BorderPane {

    protected final ToolBar chatroomTB;
    protected final ImageView imageView;
    protected final Separator separator;
    private final Button joinBtn;
    protected final Separator separator0;
    private final Button createBtn;
    protected final Separator separator1;
    private final Button signOutBtn;
    private TextArea chatTA;
    protected final HBox hBox;
    protected final Label messageLabel;
    private final TextField messageTF;
    private final Button attachBtn;
    private final Button sendBtn;
    protected final VBox vBox;
    private Label userCRLabel;
    private Label idCRLabel;
    protected final Separator separator2;
    private Label chatroomNameLabel;
    protected final Separator separator3;
    private Label usersConnectedLabel;
    private ListView<String> onlineList;

    public Chatroom() {

        chatroomTB = new ToolBar();
        imageView = new ImageView();
        separator = new Separator();
        joinBtn = new Button();
        separator0 = new Separator();
        createBtn = new Button();
        separator1 = new Separator();
        signOutBtn = new Button();
        chatTA = new TextArea();
        hBox = new HBox();
        messageLabel = new Label();
        messageTF = new TextField();
        attachBtn = new Button();
        sendBtn = new Button();
        vBox = new VBox();
        userCRLabel = new Label();
        idCRLabel = new Label();
        separator2 = new Separator();
        chatroomNameLabel = new Label();
        separator3 = new Separator();
        usersConnectedLabel = new Label();
        onlineList = new ListView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(chatroomTB, javafx.geometry.Pos.CENTER);
        chatroomTB.setPrefHeight(28.0);
        chatroomTB.setPrefWidth(600.0);

        imageView.setFitHeight(28.0);
        imageView.setFitWidth(36.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("VChatIcon.png").toExternalForm()));

        separator.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator.setPrefHeight(35.0);
        separator.setPrefWidth(1.0);
        separator.setVisible(false);

        joinBtn.setMnemonicParsing(false);
//        joinBtn.setOnAction(this::joinChatroom);
        joinBtn.setPrefHeight(25.0);
        joinBtn.setPrefWidth(65.0);
        joinBtn.setText("Join");
        joinBtn.setOpaqueInsets(new Insets(0.0));

        separator0.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator0.setPrefHeight(35.0);
        separator0.setPrefWidth(0.0);
        separator0.setVisible(false);

        createBtn.setMnemonicParsing(false);
//        createBtn.setOnAction(this::createChatroom);
        createBtn.setPrefHeight(25.0);
        createBtn.setPrefWidth(65.0);
        createBtn.setText("Create");

        separator1.setPrefHeight(35.0);
        separator1.setPrefWidth(292.0);
        separator1.setVisible(false);

        signOutBtn.setMnemonicParsing(false);
//        helpBtn.setOnAction(this::helpInfo);
        signOutBtn.setPrefHeight(25.0);
        signOutBtn.setPrefWidth(65.0);
        signOutBtn.setText("Sign-Out");
        setTop(chatroomTB);

        BorderPane.setAlignment(chatTA, javafx.geometry.Pos.CENTER);
        chatTA.setPrefHeight(322.0);
        chatTA.setPrefWidth(600.0);
        setCenter(chatTA);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(29.0);
        hBox.setPrefWidth(600.0);

        messageLabel.setPrefHeight(25.0);
        messageLabel.setPrefWidth(19.0);
        messageLabel.setText("  >");

//        messageTF.setOnKeyPressed(this::sendMessageOnEnter);
        messageTF.setPrefHeight(29.0);
        messageTF.setPrefWidth(455.0);
        messageTF.setPromptText("type messsage...");

        attachBtn.setMnemonicParsing(false);
//        attachBtn.setOnAction(this::attachFile);
        attachBtn.setPrefHeight(25.0);
        attachBtn.setPrefWidth(70.0);
        attachBtn.setText("Attach");

        sendBtn.setDefaultButton(true);
        sendBtn.setMnemonicParsing(false);
        //sendBtn.setOnAction(this::sendMessage);
        sendBtn.setPrefHeight(25.0);
        sendBtn.setPrefWidth(67.0);
        sendBtn.setText("Send");
        setBottom(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setFocusTraversable(true);
        vBox.setPrefHeight(326.0);
        vBox.setPrefWidth(137.0);

        userCRLabel.setText("<username>");

        idCRLabel.setText("<ID>");

        separator2.setPrefHeight(10.0);
        separator2.setPrefWidth(137.0);

        chatroomNameLabel.setText("<Chatroom Name>");

        separator3.setPrefHeight(12.0);
        separator3.setPrefWidth(137.0);

        usersConnectedLabel.setText("Users Connected:");

        onlineList.setPrefHeight(355.0);
        onlineList.setPrefWidth(137.0);
        setRight(vBox);

        chatroomTB.getItems().add(imageView);
        chatroomTB.getItems().add(separator);
        chatroomTB.getItems().add(joinBtn);
        chatroomTB.getItems().add(separator0);
        chatroomTB.getItems().add(createBtn);
        chatroomTB.getItems().add(separator1);
        chatroomTB.getItems().add(signOutBtn);
        hBox.getChildren().add(messageLabel);
        hBox.getChildren().add(messageTF);
        hBox.getChildren().add(attachBtn);
        hBox.getChildren().add(sendBtn);
        vBox.getChildren().add(userCRLabel);
        vBox.getChildren().add(idCRLabel);
        vBox.getChildren().add(separator2);
        vBox.getChildren().add(chatroomNameLabel);
        vBox.getChildren().add(separator3);
        vBox.getChildren().add(usersConnectedLabel);
        vBox.getChildren().add(onlineList);

    }
/*
    protected abstract void joinChatroom(javafx.event.ActionEvent actionEvent);

    protected abstract void createChatroom(javafx.event.ActionEvent actionEvent);

    protected abstract void helpInfo(javafx.event.ActionEvent actionEvent);

    protected abstract void sendMessageOnEnter(javafx.scene.input.KeyEvent keyEvent);

    protected abstract void attachFile(javafx.event.ActionEvent actionEvent);

    protected abstract void sendMessage(javafx.event.ActionEvent actionEvent);
    */

    
    /**
     * @return the joinBtn
     */
    public Button getJoinBtn() {
        return joinBtn;
    }

    /**
     * @return the createBtn
     */
    public Button getCreateBtn() {
        return createBtn;
    }

    /**
     * @return the helpBtn
     */
    public Button getsignOutBtn() {
        return signOutBtn;
    }

    /**
     * @return the chatTA
     */
    public TextArea getChatTA() {
        return chatTA;
    }

    /**
     * @param chatTA the chatTA to set
     */
    public void setChatTA(TextArea chatTA) {
        this.chatTA = chatTA;
    }

    /**
     * @return the messageTF
     */
    public TextField getMessageTF() {
        return messageTF;
    }

    /**
     * @return the attachBtn
     */
    public Button getAttachBtn() {
        return attachBtn;
    }

    /**
     * @return the sendBtn
     */
    public Button getSendBtn() {
        return sendBtn;
    }

    /**
     * @return the userCRLabel
     */
    public Label getUserCRLabel() {
        return userCRLabel;
    }

    /**
     * @param userCRLabel the userCRLabel to set
     */
    public void setUserCRLabel(Label userCRLabel) {
        this.userCRLabel = userCRLabel;
    }

    /**
     * @return the idCRLabel
     */
    public Label getIdCRLabel() {
        return idCRLabel;
    }

    /**
     * @param idCRLabel the idCRLabel to set
     */
    public void setIdCRLabel(Label idCRLabel) {
        this.idCRLabel = idCRLabel;
    }

    /**
     * @return the chatroomNameLabel
     */
    public Label getChatroomNameLabel() {
        return chatroomNameLabel;
    }

    /**
     * @param chatroomNameLabel the chatroomNameLabel to set
     */
    public void setChatroomNameLabel(Label chatroomNameLabel) {
        this.chatroomNameLabel = chatroomNameLabel;
    }

    /**
     * @return the usersConnectedLabel
     */
    public Label getUsersConnectedLabel() {
        return usersConnectedLabel;
    }

    /**
     * @param usersConnectedLabel the usersConnectedLabel to set
     */
    public void setUsersConnectedLabel(Label usersConnectedLabel) {
        this.usersConnectedLabel = usersConnectedLabel;
    }

    /**
     * @return the onlineList
     */
    public ListView getOnlineList() {
        return onlineList;
    }

    /**
     * @param onlineList the onlineList to set
     */
    public void setOnlineList(ListView onlineList) {
        this.onlineList = onlineList;
    }

  
}
