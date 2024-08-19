package org.example.exo2_adapter;

public class NotificationAdapter implements SmsService{
    private EmailService emailService;

    public NotificationAdapter() {
        emailService = new EmailService();
    }

    private String getEmailByPhone (String phone){return phone+"@email.com";}

    @Override
    public void sendSms(String phoneNumber, String message) {
        emailService.sendEmail(getEmailByPhone(phoneNumber),null,message);
    }
}
