package pl.dobberstudio.game.locations.ropuch;

import pl.dobberstudio.game.GameManager;

public class Assortment {
    private Product[] products = new Product[22];

    public Assortment() {
        products[0] = new Product("res/barbe.png", "Sos Barbecue", 6.99F);
        products[1] = new Product("res/crunchips.png", "crunchips solone", 8.99F);
        products[2] = new Product("res/desperados.png", "Piwo desperados", 3.99F);
        products[3] = new Product("res/dip.png", "Sos Dip", 5.99F);
        products[4] = new Product("res/harnas.png", "Piwo Harnas", 1.99F);
        products[5] = new Product("res/hoop.png", "Hoop Cola", 2.99F);
        products[6] = new Product("res/kasztelan.png", "Piwo Kasztelan", 2.99F);
        products[7] = new Product("res/kawa.png", "Kawa Jacobs", 3.99F);
        products[8] = new Product("res/ketchup.png", "Smaczny Ketchup", 6.99F);
        products[9] = new Product("res/kielbasa.png", "Tlusta Kielbasa", 5.99F);
        products[10] = new Product("res/mozzarella.png", "Ser Mozzarella", 3.99F);
        products[11] = new Product("res/musztarda.png", "Musztarda Sarebska", 4.99F);
        products[12] = new Product("res/nachos.png", "Nachos", 10.99F);
        products[13] = new Product("res/okocim.png", "Piwo Okocim", 2.99F);
        products[14] = new Product("res/olej.png", "Olej Kujawski", 13.99F);
        products[15] = new Product("res/pomidory.png", "Suszone Pomidory", 8.99F);
        products[16] = new Product("res/pringles.png", "Chipsy Pringles", 8.99F);
        products[17] = new Product("res/ptasiemleczko.png", "Ptasie Mleczko", 12.99F);
        products[18] = new Product("res/ser.png", "Serek Topiony", 3.99F);
        products[19] = new Product("res/talarki.png", "Smaczne Talarki", 6.99F);
        products[20] = new Product("res/tyskie.png", "Piwo Tyskie", 2.99F);
        products[21] = new Product("res/zubr.png", "Piwo Zubr", 3.99F);
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
