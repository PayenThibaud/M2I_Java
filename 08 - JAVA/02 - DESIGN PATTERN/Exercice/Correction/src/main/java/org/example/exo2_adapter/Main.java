package org.example.exo2_adapter;

public class Main {
    public static void main(String[] args) {
        SmsService notificationAdapter = new NotificationAdapter();
        notificationAdapter.sendSms("123456789","hello world");

        EmailService emailService = new EmailService();
        emailService.sendEmail("email@email.com","subject","body of my email");
    }
}
