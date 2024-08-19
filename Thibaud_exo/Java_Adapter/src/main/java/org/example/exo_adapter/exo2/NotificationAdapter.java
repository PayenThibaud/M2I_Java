package org.example.exo_adapter.exo2;

public class NotificationAdapter implements SmsService {

    private EmailService emailService;
    private String subject;

    public NotificationAdapter(String subject) {
        this.emailService = new EmailService();
        this.subject = subject;
    }

    @Override
    public void sendSms(String number, String message) {
        String email = number + "@gmail.com";
        emailService.sendEmail(email, subject, message);
    }
}