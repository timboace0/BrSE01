package model;

public class Dog extends Pet{
    public Dog() {
    }

    public Dog(String petID, String petName, int age) {
        super(petID, petName, age);
    }

    @Override
    public void speak() {
        System.out.println("Gâu Gâu");
    }
}
