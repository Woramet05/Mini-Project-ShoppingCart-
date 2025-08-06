package Lib;

import java.util.ArrayList;

public class ProductCatalog {
    private ArrayList<Product> products = new ArrayList<>();

    // Rep
    // Invariant (RI) :
    // - products list is not null, contains no null,
    // - and no duplicate products.
    // Abstraction Funtion (AF) :
    // - AF(products) = A catalog of all available products.

    private void CheckRep(){
        if (products == null) {
            throw new RuntimeException("RI violated : Products can not to be null");
        }
        //Check for duplicate products
        for (int i = 0 ; i < products.size() ; i++){
            for (int j = i + 1 ; j < products.size() ; j++){
                if(products.get(i).equals(products.get(j))){
                    throw new RuntimeException("RI violated : ");
                }
            }
        }
    }
    public ProductCatalog(){
        CheckRep();
    }

    /**
     * เพิ่มสินค้า
     * @param product สินค้าที่ต้องการสร้าง
     */

    public void addProduct(Product product){
        if (product != null && !products.contains(product)) {
            products.add(product);
        }
        CheckRep();
    }

    /**
     * ค้นหาสินค้าจากรหัสสินค้า
     * @param productID รหัสสินค้าที่ต้องการค้นหา
     * @return อ็อบเจกต์ Product หากพบ, หรือ null หากไม่พบ
     */
    
    public Product finByID(String productID){
        for(Product p : products){
            if (p.getProductID().equals(productID)) {
                return p;
            }
        }
        return null;
    }
}
