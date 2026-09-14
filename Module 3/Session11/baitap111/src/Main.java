import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int sum;
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Các số chẵn trong danh sách: ");
        list.forEach(number -> {
            if (number % 2 == 0){
                System.out.println(number);
            }
        });

        sum = list.stream().mapToInt(n -> n).sum();
        System.out.print("Tổng của tất cả các số trong danh sách: " +sum);

        
    }
}