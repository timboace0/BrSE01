public class Main {
    public static void main(String[] args) {
        String str = "Hello";

        long startString = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            str += " World";
        }

        long endString = System.currentTimeMillis();

        StringBuilder stringBuilder = new StringBuilder("Hello");

        long startBuilder = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            stringBuilder.append(" World");
        }

        long endBuilder = System.currentTimeMillis();

        StringBuffer stringBuffer = new StringBuffer("Hello");

        long startBuffer = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            stringBuffer.append(" World");
        }

        long endBuffer = System.currentTimeMillis();

        System.out.println("Thời gian thực thi:");
        System.out.println("String:        " + (endString - startString) + " ms");
        System.out.println("StringBuilder: " + (endBuilder - startBuilder) + " ms");
        System.out.println("StringBuffer:  " + (endBuffer - startBuffer) + " ms");

        System.out.println("\nNhận xét:");
        System.out.println("- String chậm nhất vì mỗi lần nối tạo ra một đối tượng String mới.");
        System.out.println("- StringBuilder nhanh và phù hợp khi nối chuỗi nhiều lần trong chương trình đơn luồng.");
        System.out.println("- StringBuffer tương tự StringBuilder nhưng có hỗ trợ đồng bộ hóa, phù hợp khi làm việc với nhiều luồng.");
    }
}