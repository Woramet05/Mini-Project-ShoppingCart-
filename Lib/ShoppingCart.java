package Lib;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<CartItem> items = new ArrayList<>();
    private final PricingService pricingService;
    private final ProductCatalog productCatalog;

    // Rep
    // Invariant (RI) :
    // -ArrayList<CartItem> is not null

    public void CheckRep(){
        if (items == null) {
            throw new RuntimeException("RI violated : Items can not to be null");
        }
        for(int i = 0 ; i < items.size() ; i++){
            for(int j = i + 1 ; j < items.size() ; j++){
                if (items.get(i).getProduct().equals(items.get(j).getProduct())) {
                    throw new RuntimeException("RI violated : Products duplicate in cart");
                }
            }
        }
    }
    public ShoppingCart(PricingService pricingService, ProductCatalog productCatalog){
        this.pricingService = pricingService;
        this.productCatalog = productCatalog;
        CheckRep();
    }

    public void addItem(String productID, int quantity){
        Product product = productCatalog.finByID(productID);
        if (product == null) {
            return;
        }
        if (quantity <= 0) {
        return;
    }
        for(CartItem item : items){
            if (item.getProduct().equals(product)) {
                item.increaseQuantity(quantity);
                CheckRep();
                return;
            }
        }
        items.add(new CartItem(product, quantity));
        CheckRep();
    }
    public void removeItem(String productID){
        for(int i = 0 ; i < items.size() ; i++){
            if (items.get(i).getProduct().getProductID().equals(productID)) {
                items.remove(i);
                CheckRep();
                break;
            }
        }
    }
    public double getTotalPrice(){
        double total = 0;
        for(CartItem item : items){
            total += pricingService.calculateItemPrice(item);
        }
        return total;
    }
    public int getItemCount(){
        return items.size();
    }
    public void clearCart(){
        items.clear();
        CheckRep();
    }


}
