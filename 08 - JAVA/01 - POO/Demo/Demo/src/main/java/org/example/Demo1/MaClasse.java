package org.example.Demo1;

public class MaClasse {

    private int classNumber;
    public String className;

//    public MaClasse (){
//
//    }

    public MaClasse (int number, String className){
        this.className = className;
        classNumber = number;
    }

    public String getClassName (){
        return this.className;
    }

    public int getClassNumber (){
        return classNumber;
    }
}
