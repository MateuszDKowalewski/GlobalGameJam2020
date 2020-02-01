package pl.dobberstudio.game.locations.ropuch;

import pl.dobberstudio.game.locations.WorkRopuch;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> products = new ArrayList<>();
    private int amount;
    private int speed;

    public Basket(WorkRopuch ropuch) {
        amount = (int)(Math.random() * 15 + 5);
        speed = 250;
        int curentX = 0;
        for(int i = 0;  i < amount; i++) {
            Product p = ropuch.getAssortment().getProduct((int)(Math.random() * ropuch.getAssortment().productsAmount()));
            if(i != 0) {
                curentX -= p.width + (int)(Math.random() * 50 + 20);
            }
            p.x = curentX;
            p.y = 80;
            products.add(p);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getAmount() {
        return amount;
    }

    public void run(double deltaTime) {
        products.forEach(p -> p.move(speed * deltaTime, 0));
    }

    public void remove(Product p) {
        products.remove(p);
        amount--;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "products=" + products +
                ", amount=" + amount +
                '}';
    }
}
