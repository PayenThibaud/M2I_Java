package org.example.DemoCollection;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //list
        List<String> stringList = new ArrayList<>();

        stringList.add("tomate");
        stringList.add("Fromage");
        stringList.add("Farine");

        System.out.println(stringList.get(0));
        System.out.println(stringList.get(2));
        System.out.println(stringList.size());

//        stringList.remove(1);
        stringList.remove("Fromage");

        System.out.println("--- for each ---");
        for (String string : stringList){
            System.out.println(string);
        }

        System.out.println("--- for ---");
        for (int i = 0;i < stringList.size();i++){
            System.out.println(stringList.get(i));
        }


        // set
        System.out.println(" --- Set ---");
        Set<Integer> integerSet = new HashSet<>();

        integerSet.add(1);
        integerSet.add(5);
        integerSet.add(2);
//        integerSet.add(2);

        for(Integer integer : integerSet){
            System.out.println(integer);
        }

        //Map
        System.out.println("--- Map ---");

        Map<String,Integer> map = new HashMap<>();

        map.put("Pomme",4);
        map.put("Poire",5);
        map.put("Peche",6);

        map.replace("Pomme",10);

        map.remove("Poire");

        for (Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
