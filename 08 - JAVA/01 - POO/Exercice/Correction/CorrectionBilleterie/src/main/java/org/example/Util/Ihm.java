package org.example.Util;

import org.example.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    private Scanner scanner;
    private List<Event> events;
    private List<Customer> customers;

    public Ihm() {
        scanner = new Scanner(System.in);
    }

    public void start (){
        init();
        String entry;
        while (true){
            afficheMenu();
            entry = scanner.nextLine();
            switch (entry){
                case "1":
                    addBillet();
                    break;
                case "2":
                    showBilletCustomer();
                    break;
                case "3":
                    showBilletEvent();
                    break;
                default:
                    return;
            }
        }


    }

    private void init (){
        events = new ArrayList<>();
        customers = new ArrayList<>();

        Address address = new Address("200 rue des lillas","lille");
        Place place = new Place("rue de l'evenement","lille",800);

        Customer customer = new Customer("toto","tata",address,30,"01234567899");
        Customer customer2 = new Customer("titi","tutu",address,30,"01234567899");

        Event event = new Event("Event1",place, LocalDateTime.now(),400);

        customers.add(customer);
        customers.add(customer2);
        events.add(event);
    }

    private void afficheMenu (){
        System.out.println(events);
        System.out.println(customers);
        System.out.println("""
                --- Menu des billets ---
                1/cree
                2/aficher les billets d'un client
                3/ afficher les billets d'un event
                """);
    }

    private void addBillet (){
        System.out.println("--- ajout d'un billet ---");

        System.out.println("index du client :");
        int indexClient = scanner.nextInt();
        scanner.nextLine();

        System.out.println("index de l'evenement :");
        int indexEvent = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Type de la place Standard/ gold / vip");
        String typePlace = scanner.nextLine();
        PlaceTYpe placeTYpe = PlaceTYpe.valueOf(typePlace.toUpperCase());

        Customer customer = customers.get(indexClient);
        Event event = events.get(indexEvent);
        int numerosPlace = event.getBillets().size() + 1;

        Billet billet = new Billet(numerosPlace,customer,event,placeTYpe);
        event.addBillet(billet);
        customer.addBillet(billet);
    }

    private void showBilletCustomer(){
        System.out.println("--- affiher les billets d'un client ---");
        System.out.println("index du client :");
        int index = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customers.get(index);
        for (Billet billet : customer.getBillets()){
            System.out.println(billet);
        }

    }
    private void showBilletEvent(){
        System.out.println("--- affiher les billets d'un Evenement ---");
        System.out.println("index de l'evenement :");
        int index = scanner.nextInt();
        scanner.nextLine();
        Event event = events.get(index);
        for (Billet billet : event.getBillets()){
            System.out.println(billet);
        }
    }




}
