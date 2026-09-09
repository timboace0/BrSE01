package model;

public class Cat extends Pet{
    public Cat() {
    }

    public Cat(String petID, String petName, int age) {
        super(petID, petName, age);
    }

    @Override
    public void speak() {
        System.out.println("Meo Meo");
    }
}
