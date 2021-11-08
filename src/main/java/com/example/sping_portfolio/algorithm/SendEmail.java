/*package com.example.sping_portfolio.algorithm;



import java.util.Properties;




public class SendEmail {
    private String emailAddress;
    private String taskName;

    public SendEmail(String email, String task){
        emailAddress = email;
        taskName = task;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void sendEmail(String emailAddress, String taskName){
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


        // creates a new session, no Authenticator (will connect() later
        final String username = "the.end.of.the.world.is.life@gmail.com";
        final String password = "the end of the world";

        props.put("mail.smtp.user", username);


        Session session = Session.getDefaultInstance(props);
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailAddress));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
            message.setSubject("You have a task to do!: " + taskName);
            message.setText("Make sure to incorporate " + taskName + " into your schedule today!");
            Transport t = session.getTransport("smtp");
            t.connect(username, password);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            System.out.println("Message Sent Successfully....");
        } catch (MessagingException mex){
            mex.printStackTrace();
        }

    }
} */
