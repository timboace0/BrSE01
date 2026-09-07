public class Cat extends Animals{
    private String furColor;

    public Cat(String name, int age, String furColor){
        super(name,age);
        this.furColor = furColor;
    }

    public Cat(String furColor) {
        this.furColor = furColor;
    }

    @Override
    public void makeSound(){
        System.out.println("Meow Meow");
    }
    @Override
    public void displayInfo(){
        System.out.printf("Tên: %s%n Tuổi: %s%n Màu lông: %s%n", getName(), getAge(), this.furColor);
    }
}
