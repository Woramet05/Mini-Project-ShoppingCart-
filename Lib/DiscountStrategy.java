package Lib;
/**
 * Interface สำหรับการคำนวณราคาสินค้า
 */
public interface DiscountStrategy {
    /**
     * คำนวณราคาสุทธิสำหรับสินค้า 1 รายการ
     * @param item รายการสินค้าในตะกร้า
     * @return ราคาสุทธิหลังใช้โปรโมชัน
     */
    public double calculatePrice(CartItem item);
        
    
}
