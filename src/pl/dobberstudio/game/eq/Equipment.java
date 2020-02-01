package pl.dobberstudio.game.eq;

import pl.dobberstudio.engine.gfx.Font;

import java.util.Arrays;

public class Equipment {
    private int food[] = new int[Food.values().length];
    private int flowers[] = new int[Flowers.values().length];

    public Equipment() {
    }

    public int getFoodAmount(Food food) {
        int i = 0;
        for(Food f : Food.values()) {
            if(food == f) {
                return this.food[i];
            }
            i++;
        }
        return -1;
    }

    public int getFlowerAmount(Flowers flowers) {
        int i = 0;
        for(Flowers f : Flowers.values()) {
            if(flowers == f) {
                return this.flowers[i];
            }
            i++;
        }
        return -1;
    }

    public void addFood(Food food, int amount) {
        int i = 0;
        for(Food f : Food.values()) {
            if(food == f) {
                this.food[i] += amount;
            }
            i++;
        }
    }

    public void addFlowers(Flowers flower, int amount) {
        int i = 0;
        for(Flowers f : Flowers.values()) {
            if(flower == f) {
                this.flowers[i] += amount;
            }
            i++;
        }
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "food=" + Arrays.toString(food) +
                ", flowers=" + Arrays.toString(flowers) +
                '}';
    }
}
