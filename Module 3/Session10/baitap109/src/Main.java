import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        do {
            System.out.println("""
                    *********************** MENU QUẢN LÝ DANH BẠ **************************
                    1. Thêm liên lạc
                    2. Xóa liên lạc
                    3. Tìm kiếm liên lạc
                    4. Hiển thị danh sách liên lạc
                    5. Phân trang danh sách liên lạc
                    6. Thoát
                    """);

            System.out.print("Lựa chọn của bạn: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                continue;
            }

            switch (choice) {

                case 1: {
                    String name;

                    do {
                        System.out.print("Nhập tên liên lạc: ");
                        name = scanner.nextLine();

                        if (name.trim().isEmpty()) {
                            System.out.println("Tên không được để trống!");
                        }

                    } while (name.trim().isEmpty());

                    String phoneNumber;

                    do {
                        System.out.print("Nhập số điện thoại: ");
                        phoneNumber = scanner.nextLine();

                        if (phoneNumber.trim().isEmpty()) {
                            System.out.println("Số điện thoại không được để trống!");
                        } else if (contactManager.containsPhoneNumber(phoneNumber)) {
                            System.out.println("Số điện thoại đã tồn tại!");
                        } else {
                            break;
                        }

                    } while (true);

                    Contact contact = new Contact(name, phoneNumber);

                    if (contactManager.add(contact)) {
                        System.out.println("Thêm liên lạc thành công!");
                    } else {
                        System.out.println("Số điện thoại đã tồn tại!");
                    }

                    break;
                }

                case 2: {
                    if (contactManager.size() == 0) {
                        System.out.println("Danh bạ đang trống!");
                        break;
                    }

                    contactManager.display();

                    System.out.print("Nhập số điện thoại cần xóa: ");
                    String phoneNumber = scanner.nextLine();

                    if (contactManager.removeByPhoneNumber(phoneNumber)) {
                        System.out.println("Xóa liên lạc thành công!");
                    } else {
                        System.out.println("Không tìm thấy số điện thoại!");
                    }

                    break;
                }

                case 3: {
                    if (contactManager.size() == 0) {
                        System.out.println("Danh bạ đang trống!");
                        break;
                    }

                    System.out.print("Nhập số điện thoại cần tìm: ");
                    String phoneNumber = scanner.nextLine();

                    Contact contact = contactManager.findByPhoneNumber(phoneNumber);

                    if (contact != null) {
                        System.out.println(contact);
                    } else {
                        System.out.println("Không tìm thấy liên lạc!");
                    }

                    break;
                }

                case 4: {
                    contactManager.display();
                    break;
                }

                case 5: {
                    if (contactManager.size() == 0) {
                        System.out.println("Danh bạ đang trống!");
                        break;
                    }

                    List<Contact> contactList = contactManager.getContactList();

                    int pageSize = 3;
                    int totalPage = (int) Math.ceil((double) contactList.size() / pageSize);

                    int page;

                    while (true) {
                        try {
                            System.out.print("Nhập trang muốn xem (1-" + totalPage + "): ");
                            page = Integer.parseInt(scanner.nextLine());

                            if (page < 1 || page > totalPage) {
                                System.out.println("Trang không hợp lệ!");
                            } else {
                                break;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số!");
                        }
                    }

                    int start = (page - 1) * pageSize;
                    int end = Math.min(start + pageSize, contactList.size());

                    System.out.println("**************** TRANG " + page + "/" + totalPage + " ****************");

                    for (int i = start; i < end; i++) {
                        System.out.println(contactList.get(i));
                    }

                    break;
                }

                case 6: {
                    System.out.println("Bạn đã thoát chương trình!");
                    return;
                }

                default: {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
            }

        } while (true);
    }
}