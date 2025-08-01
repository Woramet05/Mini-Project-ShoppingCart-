package Lib.Discount;

import Lib.CartItem;
import Lib.DiscountStrategy;
/**
 * การคิดราคาแบบปกติ (ไม่มีส่วนลด)
 */
public class DefaultPricingStrategy implements DiscountStrategy {

    @Override
    public double calculatePrice(CartItem item) {
        return item.getProduct().getProductPrice() * item.getQuantity();
    }
    
}
