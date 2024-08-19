package org.example.exo2_adapter;

public class EmailService {
    public void sendEmail(String email,String subject,String body){
        System.out.println("sending email to "+email+
                ((subject==null)? "":"\nsubject: "+subject)+
                "\nBody : "+body);
    }
}
