package org.example.ExerciceException.Exo4;

public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        if(age<0){
            throw new InvalidAgeException("l'age doit etre une valeur positive");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0){
            throw new InvalidAgeException("L'age doit etre une valeur positive");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
