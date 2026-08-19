import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        double salary = 0, totalSalary = 0, highestSalary = 0, lowestSalary = Double.MAX_VALUE, avgSalary = 0, totalBonus = 0;
        int totalEmployee = 0;
        while(choice != 4){
            System.out.println("""
                    \n***************MENU NHẬP LƯƠNG***************
                    
                    1.  	Nhập lương nhân viên
                    
                    2.  	Hiển thị thống kê
                    
                    3.  	Tính tổng số tiền thưởng cho nhân viên
                    
                    4.  	Thoát
                    
                    Lựa chọn của bạn:
                    """);
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1: {
                    while(salary != -1){
                        System.out.println("Xin mời nhập lương nhân viên (nhập -1 để kết thúc): ");
                        salary = Double.parseDouble(scanner.nextLine());
                        if(salary < -1 || salary > 500000000){
                            System.err.println("Mức lương không hợp lệ, vui lòng nhập lại!");
                        } else if(salary >= 0 && salary < 5000000){
                            System.out.println("Thu nhập thấp");
                            totalSalary += salary;
                            totalEmployee += 1;
                            if(salary > highestSalary){
                                highestSalary = salary;
                            }
                            if(salary < lowestSalary){
                                lowestSalary = salary;
                            }
                            totalBonus += salary * 0.05;
                        } else if(salary >= 5000000 && salary < 15000000){
                            System.out.println("Thu nhập trung bình");
                            totalSalary += salary;
                            totalEmployee += 1;
                            if(salary > highestSalary){
                                highestSalary = salary;
                            }
                            if(salary < lowestSalary){
                                lowestSalary = salary;
                            }
                            totalBonus += salary * 0.05;
                        } else if(salary >= 15000000 && salary < 50000000){
                            System.out.println("Thu nhập trung khá");
                            totalSalary += salary;
                            totalEmployee += 1;
                            if(salary > highestSalary){
                                highestSalary = salary;
                            }
                            if(salary < lowestSalary){
                                lowestSalary = salary;
                            }
                            totalBonus += salary * 0.05;
                        } else if(salary >= 50000000){
                            System.out.println("Thu nhập cao");
                            totalSalary += salary;
                            totalEmployee += 1;
                            if(salary > highestSalary){
                                highestSalary = salary;
                            }
                            if(salary < lowestSalary){
                                lowestSalary = salary;
                            }
                            totalBonus += salary * 0.05;
                        }
                        System.out.printf("Tổng số nhân viên: %d \n", totalEmployee);
                        System.out.printf("Tổng lương: %.3f VND\n" , totalSalary);
                        System.out.printf("Lương cao nhất: %.3f VND\n" ,highestSalary);
                        System.out.printf("Lương thấp nhất: %.3f VND\n" ,lowestSalary);
                    }
                    if(totalEmployee > 0){
                        avgSalary = totalSalary/ totalEmployee;
                    }
                    break;
                }
                case 2: {
                    if (totalEmployee == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        System.out.println("-------------------THỐNG KÊ--------------------");
                        System.out.println("Tổng số nhân viên đã nhập:  " +totalEmployee);
                        System.out.printf("Lương trung bình: %.3f VND\n" ,avgSalary);
                        System.out.printf("Lương cao nhất: %.3f VND\n" ,highestSalary);
                        System.out.printf("Lương thấp nhất: %.3f VND\n" ,lowestSalary);
                        System.out.printf("Tổng tiền lương: %.3f VND\n" ,totalSalary);
                    }
                    break;
                }
                case 3: {
                    System.out.println("------TÍNH TỔNG SỐ TIỀN THƯỞNG NHÂN VIÊN-------");
                    System.out.printf("Tổng tiền thưởng nhân viên: %.3f", totalBonus);
                    break;
                }
                case 4: {
                    System.out.println("Bạn đã thoát chương trình");
                    System.exit(0);
                    break;
                }
                default:
                    System.err.println("Nhập không hợp lệ, yêu cầu nhập lại!");
            }
        }
    }
}