package bussiness.model;

import utils.InputData;

import java.util.Date;
import java.util.Scanner;

public class Product {
    private int productId;
    private String productName;
    private float productPrice;
    private String productTitle;
    private Date productCreated;
    private String productCatalog;
    private boolean productStatus;

    public Product(int productId, String productName, float productPrice, String productTitle, Date productCreated, String productCatalog, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productTitle = productTitle;
        this.productCreated = productCreated;
        this.productCatalog = productCatalog;
        this.productStatus = productStatus;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Date getProductCreated() {
        return productCreated;
    }

    public void setProductCreated(Date productCreated) {
        this.productCreated = productCreated;
    }

    public String getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(String productCatalog) {
        this.productCatalog = productCatalog;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputProduct(Scanner scanner){
        productName = InputData.getString(scanner, "Mời nhập tên sản phẩm: ");
        productPrice = InputData.getFloat(scanner, "Mời nhập giá sản phẩm: ");
        productTitle = InputData.getString(scanner, "Mời nhập tiêu đề sản phẩm: ");
        productCatalog = InputData.getString(scanner, "Mời nhập danh mục sản phẩm: ");
        productStatus = InputData.getBoolean(scanner, "Mời nhập trạng thái sản phẩm (true - đang bán | false - ngừng bán):");
    }

    @Override
    public String toString() {
        return String.format(
                "Product ID: %d | Name: %s | Price: %.2f | Title: %s | Created: %s | Catalog: %s | Status: %s",
                productId,
                productName,
                productPrice,
                productTitle,
                productCreated,
                productCatalog,
                productStatus ? "Đang bán" : "Ngừng bán"
        );
    }
}
