//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello, Java World!");
        System.out.printf("chuỗi ban đầu: %s", str);
        str.delete(5,10);
        System.out.printf("\n Chuỗi sau khi xóa: %s", str);
        str.replace(7,12,"Universe");
        System.out.printf("\n Chuỗi sau khi thay thế: %s", str);

    }
}