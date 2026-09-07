import java.util.Scanner;

public class CategoryManagement implements ICRUD {
    Scanner scanner = new Scanner(System.in);
    Category[] categories = new Category[100];

    @Override
    public Category[] findAll() {
        int count = 0;

        for (Category category : categories) {
            if(category != null){
                count++;
            }
        }

        Category[] result = new Category[count];

        int index = 0;

        for (Category category : categories){
            if(category != null) {
                result[index] = category;
                index++;
            }
        }
        return result;
    }

    @Override
    public void addCategory(Category category) {
        for (int i = 0; i < categories.length; i++) {
            if(categories[i] == null){
                categories[i] = category;
                System.out.println("Danh mục đã được thêm.");
                return;
            }
        }
    }

    @Override
    public void updateCategory(Category category) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i] != null && categories[i].getId() == category.getId()) {

                categories[i].setName(category.getName());
                categories[i].setDescription(category.getDescription());

                System.out.println("Cập nhật danh mục thành công.");
                return;
            }
        }

        System.out.println("Không tìm thấy ID danh mục cần cập nhật.");
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < categories.length; i++) {
            if (categories[i] != null && categories[i].getId() == id) {

                categories[i] = null;

                System.out.println("Xóa danh mục thành công.");
                return;
            }
        }
        System.out.println("Danh mục không tồn tại");
    }
}
