package Lib;
/**
* คลาสนี้สำหรับจัดการโปรโมชันและคำนวณราคา
*/

import java.util.ArrayList;

import Lib.Discount.DefaultPricingStrategy;

public class PricingService {
    private record StrategyRule(String sku, DiscountStrategy strategy) {}
    private final ArrayList<StrategyRule> strategies = new ArrayList<>();
    private final DiscountStrategy defaultStrategy = new DefaultPricingStrategy();

    /**
     * ลงทะเบียนส่วนลดสำหรับสินค้า sku ที่กำหนด
     * หากมีโปรโมชันสำหรับ sku นี้อยู่แล้วจะถูกแทนที่ด้วยอันใหม่
     * @param sku รหัสสินค้าที่ต้องการผูกกับโปรโมชัน
     * @param strategy ส่วนลดที่ใช้
     */
    public void addStrategy(String sku, DiscountStrategy strategy){
        StrategyRule ruleToRemove = null;
        for(StrategyRule rule : strategies){
            if (rule.sku().equals(sku)) {
                ruleToRemove = rule;
                break;
            }
        }
        if (ruleToRemove != null) {
            strategies.remove(ruleToRemove);
        }
        strategies.add(new StrategyRule(sku, strategy));
    }
    /**
     * คำนวณราคาสุทธิของสินค้า 1 รายการโดยใช้วิธีที่เหมาะสม
     * @param item รายการสินค้าที่ต้องการคำนวณ
     * @return ราคาสุทธืหลังหักส่วนลด
     */

    public double calculateItemPrice(CartItem item){
        String sku = item.getProduct().getProductID();
        for(StrategyRule rule : strategies){
            if (rule.sku().equals(sku)) {
                return rule.strategy().calculatePrice(item);
            }
        }
        return defaultStrategy.calculatePrice(item);
    }

}
