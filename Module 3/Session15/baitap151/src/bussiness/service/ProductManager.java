package bussiness.service;

import bussiness.dao.IProductDao;
import bussiness.dao.ProductDaoImpl;
import bussiness.model.Product;
import utils.InputData;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductManager {
    static Scanner scanner = new Scanner(System.in);
    public static void displayAllProduct() {
        IProductDao productDao = new ProductDaoImpl();
        productDao.getAllProduct();
        if(ProductDaoImpl.products.isEmpty()){
            System.out.println("Danh sách hiện đang trống!");
            return;
        }
        System.out.println("================ DANH SÁCH SẢN PHẨM ===============");
        ProductDaoImpl.products.forEach(System.out::println);
    }

    public static void displaySortedProduct() {
        IProductDao productDao = new ProductDaoImpl();
        productDao.getAllProduct();
        if(ProductDaoImpl.products.isEmpty()){
            System.out.println("Danh sách hiện đang trống!");
            return;
        }
        System.out.println("================ DANH SÁCH SẢN PHẨM THEO GIÁ TĂNG DẦN ===============");
        ProductDaoImpl.products.stream()
                .sorted(Comparator.comparing(Product::getProductPrice))
                .forEach(System.out::println);
    }

    public static void checkCatalogExist(){
        IProductDao productDao = new ProductDaoImpl();
        productDao.isCatalogExist(scanner);
    }

    public static void addProduct(Scanner scanner){
        IProductDao productDao = new ProductDaoImpl();
        Product product = new Product();
        product.inputProduct(scanner);
        productDao.addProduct(product);
        System.out.println("Thêm mới sản phẩm thành công!");
    }


    public static void updateProduct(Scanner scanner){
        displayAllProduct();
        IProductDao productDao = new ProductDaoImpl();
        int id = InputData.getInt(scanner, "Mời nhập ID để cập nhật: ");
        if(!ProductDaoImpl.isIdExist(id)){
            System.out.println("ID không tồn tại!");
        } else {
            Product product = new Product();

            product.setProductId(id);

            product.inputProduct(scanner);
            productDao.updateProduct(
                    product
            );
            System.out.println("Cập nhật sản phẩm thành công!");
        }
    }

    public static void deleteProduct(Scanner scanner){
        displayAllProduct();
        IProductDao productDao = new ProductDaoImpl();
        int id = InputData.getInt(scanner, "Mời nhập ID để xóa: ");
        if(!ProductDaoImpl.isIdExist(id)){
            System.out.println("ID không tồn tại!");
        } else {
            String confirm = InputData.getString(scanner, "Bạn có chắc muốn xóa sản phẩm này? (Yes/No)");
            if(confirm.equalsIgnoreCase("yes")){
                productDao.deleteProduct(id);
                System.out.println("Xóa sản phẩm thành công!");
            } else if(confirm.equalsIgnoreCase("no")){
                System.out.println("Bạn đã hủy thao tác!");
            } else {
                System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public static void findProductById(Scanner scanner){
        IProductDao productDao = new ProductDaoImpl();
        int id = InputData.getInt(scanner, "Mời nhập ID để tìm kiếm: ");
        productDao.findProductById(id);
    }

    public static void findProductByName(Scanner scanner){
        IProductDao productDao = new ProductDaoImpl();
        String name = InputData.getString(scanner, "Mời nhập tên sản phẩm để tìm kiếm: ");
        productDao.findProductByName(name);
    }

    public static void statisticCatalog(){
        IProductDao productDao = new ProductDaoImpl();
        System.out.println("================== THỐNG KÊ SỐ LƯỢNG SẢN PHẨM THEO DANH MỤC ===================");
        productDao.statisticByCatalog();
    }

}
