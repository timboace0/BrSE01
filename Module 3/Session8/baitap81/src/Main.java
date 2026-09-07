//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Animals[] animals = {
                new Dog("Hug", 5,"Alaska"),
                new Cat("Lucy", 2,"Black"),
                new Dog("Tom", 4,"Poodle")
        };

        for (Animals animal: animals){
            animal.displayInfo();
            animal.makeSound();
            System.out.println();
        }
    }
}