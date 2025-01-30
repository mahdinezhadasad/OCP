package Threads.src.threads;

import java.util.function.LongSupplier;
import java.util.function.ObjDoubleConsumer;

public class Product {
    
    String name;
    double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    void applyDiscount(double discount){
        
        this.price -= this.price*discount/100;
    }
    
    @Override
    public String toString() {
        
        return name + "-Price: §" +price;
    }
    
    
    public static void main(String[] args) {
        
        ObjDoubleConsumer<Product> discountApplier = (product, discount) -> product.applyDiscount(discount);
        Product laptop = new Product("Laptop", 1000);
        System.out.println("Before Discount: " + laptop);
        
        discountApplier.accept(laptop, 10.0);  // Applying 10% discount
        
        System.out.println("After Discount: " + laptop);
        
        LongSupplier timeSupplier = System::currentTimeMillis;
        
        System.out.println("Current Time (ms): " + timeSupplier.getAsLong());
    }
}