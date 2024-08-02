package org.example.DemoException;

public class Main {
    public static void main(String[] args) {
//        try{
//            System.out.println(calcul(10,0));
//        }catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println("suite de l'application");

//        try{
//            System.out.println(retrait(30000));
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        try{

            System.out.println(retrait(30000));
        }
        catch (SoldeInsufisantException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Mon exception");
        }

     

    }

    private static int calcul (int a,int b){
        return a/b;
    }

    private static int retrait (int montant)throws SoldeInsufisantException{
        int sold =5000;
        
        if(sold < montant){
            throw new SoldeInsufisantException("sold insufisant");
        }else{
            return sold - montant;
        }
    }


    //controler
    // service
    // repository
}
