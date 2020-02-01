package pl.dobberstudio.game.locations;

import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.eq.Food;
import pl.dobberstudio.game.gui.Button;

public class ToadProduct extends Button
{
    private Food foodKind;

    private int price;
    public ToadProduct(GameManager gm, String path, double x, double y, int price)
    {
        super(gm, path, x, y);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public Food getFoodKind() {
        return foodKind;
    }

    public void setFoodKind(Food foodKind) {
        this.foodKind = foodKind;
    }
}
