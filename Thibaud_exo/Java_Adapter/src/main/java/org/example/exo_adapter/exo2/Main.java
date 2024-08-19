package org.example.exo_adapter.exo2;

public class Main {
    public static void main(String[] args) {

        SmsService smsService = new NotificationAdapter("Sujet ecris sur tel");

        smsService.sendSms("06060606", "Body message");

            }
        }

