package org.example.exo2Product;

import org.example.exo2Product.Entity.Product;
import org.example.exo2Product.Entity.Product_Electronic;
import org.example.exo2Product.Entity.Product_Food;
import org.example.exo2Product.Entity.Product_Housing;
import org.example.exo2Product.Repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA");
//        EntityManager em = emf.createEntityManager();
//
//        ProductRepository productRepository = new ProductRepository(em);

//        Product_ElectronicRepository electronicRepository = new Product_ElectronicRepository(em);
//        ProductRepository productRepository = new ProductRepository(em);
//
//
//        Product_Electronic electronic = Product_Electronic.builder()
//                .name("smartphone")
//                .price(10.0)
//                .expiry_date("10/10/10")
//                .build();
//
//        electronicRepository.add(electronic);
//
//        System.out.println(electronic);
//        Product productFound = productRepository.getById(Product.class,58L);
//        System.out.println(productFound);
//
//        System.out.println(electronicRepository.getById(Product_Electronic.class, 58L));


//        ProductRepository productRepository = new ProductRepository(em);
//
//        Product_Electronic electronic2 = Product_Electronic.builder()
//                .name("tv")
//                .price(20.0)
//                .expiry_date("10")
//                .build();
//
//        productRepository.add(electronic2);
//
//        System.out.println(electronic2);
//
//        System.out.println(productRepository.getById(Product.class,66l));
//
//        Product_Food food = Product_Food.builder()
//                .name("orange")
//                .price(15.0)
//                .batterie_duration("5H")
//                .build();
//
//        productRepository.add(food);
//
//        System.out.println(productRepository.getById(Product.class,70L));
//    }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choisissez une option :");
            System.out.println("1. Ajouter un produit électronique");
            System.out.println("2. Ajouter un produit alimentaire");
            System.out.println("3. Ajouter un produit de logement");
            System.out.println("4. Rechercher un produit par ID");
            System.out.println("5. Afficher tous les produits");
            System.out.println("6. Supprimer un produit par ID");
            System.out.println("7. Quitter");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addElectronicProduct(scanner);
                    break;
                case 2:
                    addFoodProduct(scanner);
                    break;
                case 3:
                    addHousingProduct(scanner);
                    break;
                case 4:
                    searchProductById(scanner);
                    break;
                case 5:
                    displayAllProducts();
                    break;
                case 6:
                    removeProduictById(scanner);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }

    private static void addElectronicProduct(Scanner scanner) {
        System.out.println("Entrez le nom du produit électronique :");
        String name = scanner.nextLine();
        System.out.println("Entrez le prix du produit électronique :");
        double price = scanner.nextDouble();
        System.out.println("Entrez la date d'expiration du produit électronique :");
        String expiryDate = scanner.next();
        scanner.nextLine();

        Product_Electronic electronic2 = Product_Electronic.builder()
                .name(name)
                .price(price)
                .expiry_date(expiryDate)
                .build();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA");
        EntityManager em = emf.createEntityManager();
        ProductRepository productRepository = new ProductRepository(em);
        productRepository.add(electronic2);

        System.out.println("Produit électronique ajouté avec succès !");
    }

    private static void addFoodProduct(Scanner scanner) {
        System.out.println("Entrez le nom du produit alimentaire :");
        String name = scanner.nextLine();
        System.out.println("Entrez le prix du produit alimentaire :");
        double price = scanner.nextDouble();
        System.out.println("Entrez la durabiliter de la batterie du produit alimentaire :");
        String batterie = scanner.next();
        scanner.nextLine();

        Product_Food food = Product_Food.builder()
                .name(name)
                .price(price)
                .batterie_duration(batterie)
                .build();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA");
        EntityManager em = emf.createEntityManager();
        ProductRepository productRepository = new ProductRepository(em);
        productRepository.add(food);
    }

    private static void addHousingProduct(Scanner scanner) {
        System.out.println("Entrez le nom du produit maison :");
        String name = scanner.nextLine();
        System.out.println("Entrez le prix du produit maison :");
        double price = scanner.nextDouble();
        System.out.println("Entrez la hauteur de la batterie du produit maison :");
        int hauteur = scanner.nextInt();
        System.out.println("Entrez la largeur de la batterie du produit maison :");
        int largeur = scanner.nextInt();
        scanner.nextLine();

        Product_Housing food = Product_Housing.builder()
                .name(name)
                .price(price)
                .height(hauteur)
                .width(largeur)
                .build();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA");
        EntityManager em = emf.createEntityManager();
        ProductRepository productRepository = new ProductRepository(em);
        productRepository.add(food);
    }

    private static void searchProductById(Scanner scanner) {
        System.out.println("Entrez l'ID du produit à rechercher :");
        long id = scanner.nextLong();
        scanner.nextLine();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA");
        EntityManager em = emf.createEntityManager();
        ProductRepository productRepository = new ProductRepository(em);
        System.out.println(productRepository.getById(Product.class, id));
    }

    private static void displayAllProducts() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA");
        EntityManager em = emf.createEntityManager();
        ProductRepository productRepository = new ProductRepository(em);

        List<Product> products = productRepository.getAll(Product.class);
        if (products.isEmpty()) {
            System.out.println("Aucun produit disponible.");
        } else {
            System.out.println("Tous les produits :");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private static void removeProduictById(Scanner scanner) {
        System.out.println("Entrez l'ID du produit à rechercher :");
        long id = scanner.nextLong();
        scanner.nextLine();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Java_JPA");
        EntityManager em = emf.createEntityManager();
        ProductRepository productRepository = new ProductRepository(em);

        Product product = productRepository.getById(Product.class, id);

        if (product != null) {
            boolean deleted = productRepository.delete(product);
            if (deleted) {
                System.out.println("Produit avec l'ID " + id + " a été supprimé.");
            } else {
                System.out.println("Erreur lors de la suppression du produit.");
            }
        } else {
            System.out.println("Aucun produit trouvé avec l'ID " + id);
        }
    }
}


