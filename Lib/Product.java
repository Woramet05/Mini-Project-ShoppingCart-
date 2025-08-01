package Lib;
/**
 * ADT ที่ไม่เปลี่ยนรูป (Immutable) สำหรับเก็บข้อมูลสินค้า
 * คลาสนี้เป็น final เพื่อป้องกกันการสืบทอดและรับประกัน Immutability
 */
public final class Product {
    private final String productID;
    private final String productName;
    private final double productPrice;

    // Rep 
    // Invariant (RI) :
    // - productID and productName are not null or blank.
    // - productPrice => 0.
    //
    // Abstraction Funtion (AF) :
    // - AF(productID, productName, productPrice) = A product with the given ID, Name, Price.

    //ตรวจสอบ Rep Invarian เป็นจริงหรือไม่
    private void CheckRep(){
        if (productID == null || productID.isBlank()) {
            throw new RuntimeException("");
        }
        if (productName == null || productID.isBlank()) {
            throw new RuntimeException("");
        }
        if (productPrice < 0) {
            throw new RuntimeException("");
        }
    }
    /**
     * สร้าง อ็อบเจกต์ Product
     * @param productID รหัสสินค้า ห้ามเป็นค่าว่าง
     * @param productName ชื่อสินค้า ห้ามเป็นค่าว่าง
     * @param productPrice ราคาสินค้า ต้แงไม่ติดลบ
     */

    public Product(String productID, String productName, double productPrice){
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        CheckRep(); //ตรวจสอบความถูกต้องทุกครั้งที่สร้าง
    }
    public String getProductID(){
        return productID;
    }
    public String getProductName(){
        return productName;
    }
    public Double getProductPrice(){
        return productPrice;
    }

    /**
     * เปรียบเทียบ Product สองชิ้นโดยใช้ productID
     * @param obj อ็อบเจกต์ที่ต้องการเปรียบเทียบ
     * @return true หาก productID เหมือนกัน
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productID.equals(product.productID);
    }
}
