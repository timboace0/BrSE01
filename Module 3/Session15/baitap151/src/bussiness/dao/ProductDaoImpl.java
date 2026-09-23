package bussiness.dao;

import bussiness.model.Product;
import utils.ConnectionDB;
import utils.InputData;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDaoImpl implements IProductDao{
    public static List<Product> products = new ArrayList<>();


    public static boolean isIdExist(int id){
        for (Product product : products){
            if(product.getProductId() == id){
                return true;
            }
        }
        return false;
    }
    @Override
    public void getAllProduct() {
        try (
                Connection conn = ConnectionDB.getConnection();
                ){
            CallableStatement call = conn.prepareCall("{CALL getAllProduct()}");

            ResultSet rs = call.executeQuery();

            products.clear();

            while (rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductTitle(rs.getString("product_title"));
                product.setProductCreated(rs.getDate("product_created"));
                product.setProductCatalog(rs.getString("product_catalog"));
                product.setProductStatus(rs.getBoolean("product_status"));
                products.add(product);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void isCatalogExist(Scanner scanner) {
        String catalog = InputData.getString(scanner, "Mời nhập tên danh mục cần tìm: ");
        try (
                Connection conn = ConnectionDB.getConnection();
                CallableStatement call = conn.prepareCall("{CALL isCatalogExist(?,?)}");
        ){

            call.setString(1, catalog);
            call.registerOutParameter(2, Types.VARCHAR);

            call.execute();

            String result = call.getString(2);

            System.out.println(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addProduct(Product product) {
        try (
                Connection conn = ConnectionDB.getConnection();
                CallableStatement call = conn.prepareCall("{CALL addProduct(?,?,?,?,?)}");
        ){
            call.setString(1, product.getProductName());
            call.setFloat(2, product.getProductPrice());
            call.setString(3, product.getProductTitle());
            call.setString(4, product.getProductCatalog());
            call.setBoolean(5, product.isProductStatus());

            call.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateProduct(Product product) {
        try (
                Connection conn = ConnectionDB.getConnection();
                CallableStatement call = conn.prepareCall("{CALL updateProduct(?,?,?,?,?,?)}");
        ){
            call.setInt(1, product.getProductId());
            call.setString(2, product.getProductName());
            call.setFloat(3, product.getProductPrice());
            call.setString(4, product.getProductTitle());
            call.setString(5, product.getProductCatalog());
            call.setBoolean(6, product.isProductStatus());

            call.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        try (
                Connection conn = ConnectionDB.getConnection();
                CallableStatement call = conn.prepareCall("{CALL deleteProduct(?)}");
        ){
            call.setInt(1, id);

            call.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findProductById(Integer id) {
        try (
                Connection conn = ConnectionDB.getConnection();
                CallableStatement call = conn.prepareCall("{CALL findProductById(?)}");
        ){
            call.setInt(1, id);

            ResultSet rs = call.executeQuery();

            if (rs.next()) {
                Product product = new Product();

                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductTitle(rs.getString("product_title"));
                product.setProductCreated(rs.getDate("product_created"));
                product.setProductCatalog(rs.getString("product_catalog"));
                product.setProductStatus(rs.getBoolean("product_status"));

                System.out.println(product);
            } else {
                System.out.println("Không tìm thấy sản phẩm!");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findProductByName(String name) {
        try (
                Connection conn = ConnectionDB.getConnection();
                CallableStatement call = conn.prepareCall("{CALL findProductByName(?)}");
        ){
            call.setString(1, name);

            ResultSet rs = call.executeQuery();

            if (rs.next()) {
                Product product = new Product();

                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductPrice(rs.getFloat("product_price"));
                product.setProductTitle(rs.getString("product_title"));
                product.setProductCreated(rs.getDate("product_created"));
                product.setProductCatalog(rs.getString("product_catalog"));
                product.setProductStatus(rs.getBoolean("product_status"));

                System.out.println(product);
            } else {
                System.out.println("Không tìm thấy sản phẩm!");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void statisticByCatalog() {
        try (
                Connection conn = ConnectionDB.getConnection();
                CallableStatement call = conn.prepareCall("{CALL statisticProductByCatalog()}");
        ){
           ResultSet rs = call.executeQuery();
           if(!rs.isBeforeFirst()){
               System.out.println("Không có sản phẩm nào");
               return;
           }

           while(rs.next()){
               String catalog = rs.getString("product_catalog");
               int count = rs.getInt("product_count");

               System.out.println("Danh mục: " + catalog + "| Số sản phẩm: " + count);
           }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
