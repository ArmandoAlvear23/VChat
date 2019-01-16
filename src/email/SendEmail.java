package email;

/**
 *
 * @author Armando, Carlos, Sebastian
 */
public class SendEmail {
    
    // SMTP info
    private String host = "smtp.gmail.com";
    private String port = "465";
    private String mailFrom = "vchat.cs@gmail.com";
    private String password = "swe2018!";

    // message info
    private String mailTo = "";
    private String subject = "";
    private String message = "";
    
    public void sendPassword(String email, String pass, String user){
        
        mailTo = email;
        subject = "VChat Support";
        message = user + ",\r\nyour password for VChat is: " + pass;
        
        try{
            
            EmailAttachmentSender.sendEmail(host, port, mailFrom, password, mailTo, subject, message);
            System.out.println("Email sent!");
            
        }catch (Exception e){
            
            e.printStackTrace();
            System.out.println("Error sending email.");
            
        }
        
    }
    
}
