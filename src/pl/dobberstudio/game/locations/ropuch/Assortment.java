package pl.dobberstudio.game.locations.ropuch;

import pl.dobberstudio.game.GameManager;

public class Assortment {
    private Product[] products = new Product[22];

    public Assortment() {
        products[0] = new Product("res/barbe.png", "Sos Barbecue", 6.99F);
        products[1] = new Product("res/crunchips.png", "crunchips solone", 6.99F);
        products[2] = new Product("res/desperados.png", "Piwo desperados", 6.99F);
        products[3] = new Product("res/dip.png", "Sos Dip", 6.99F);
        products[4] = new Product("res/harnas.png", "Piwo Harnaś", 6.99F);
        products[5] = new Product("res/hoop.png", "Hoop Cola", 6.99F);
        products[6] = new Product("res/kasztelan.png", "Piwo Kasztelan", 6.99F);
        products[7] = new Product("res/kawa.png", "Kawa Jacobs", 6.99F);
        products[8] = new Product("res/ketchup.png", "Smaczny Ketchup", 6.99F);
        products[9] = new Product("res/kielbasa.png", "Tłusta Kiełbasa", 6.99F);
        products[10] = new Product("res/mozzarella.png", "Ser Mozzarella", 6.99F);
        products[11] = new Product("res/musztarda.png", "Musztarda Sarebska", 6.99F);
        products[12] = new Product("res/nachos.png", "Nachos", 6.99F);
        products[13] = new Product("res/okocim.png", "Piwo Okocim", 6.99F);
        products[14] = new Product("res/olej.png", "Olej Kujawski", 6.99F);
        products[15] = new Product("res/pomidory.png", "Suszone Pomidory", 6.99F);
        products[16] = new Product("res/pringles.png", "Chipsy Pringles", 6.99F);
        products[17] = new Product("res/ptasiemleczko.png", "Ptasie Mleczko", 6.99F);
        products[18] = new Product("res/ser.png", "Serek Topiony", 6.99F);
        products[19] = new Product("res/talarki.png", "Smaczne Talarki", 6.99F);
        products[20] = new Product("res/tyskie.png", "Piwo Tyskie", 6.99F);
        products[21] = new Product("res/zubr.png", "Piwo Żubr", 6.99F);
    }

    public int productsAmount() {
        return products.length;
    }

    public Product getProduct(int id) {
        if(id >= products.length) {
            return null;
        }
        return products[id].copy();
    }
}
