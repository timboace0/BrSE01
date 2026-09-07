public class Dog extends Animals{
    private String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
    @Override
    public void makeSound(){
        System.out.println("Woof Woof");
    }
    @Override
    public void displayInfo(){
        System.out.printf("Tên: %s%n Tuổi: %s%n Giống chó: %s%n", getName(), getAge(), this.breed);
    }
}
