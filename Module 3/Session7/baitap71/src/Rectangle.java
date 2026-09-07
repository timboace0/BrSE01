public class Rectangle {
    double length = 1;
    double width = 1;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(){
        this.length = 1.0;
        this.width = 1.0;
    }


    public double getArea(double length, double width){
          return length*width;
    }

    public double getPerimeter(double length, double width){
        return (length+width)*2;
    }

    public void display(){
        System.out.println("Chiều dài hình chữ nhật: " +length);
        System.out.println("Chiều rộng hình chữ nhật: " +width);
        System.out.println("Diện tích hình chữ nhật: " +length*width);
        System.out.println("Chu vi hình chữ nhật: " +(length+width)*2);
    }
}
