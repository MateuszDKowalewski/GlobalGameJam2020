package pl.dobberstudio.game.eq;

import pl.dobberstudio.engine.gfx.Font;
import pl.dobberstudio.game.locations.ToadProduct;

import java.util.Arrays;

public class Equipment {
    private int food[] = new int[Food.values().length];
    private int flowers[] = new int[Flowers.values().length];

    private ToadProduct head;
    private ToadProduct body;
    private ToadProduct legs;
    private ToadProduct foots;

    private ToadProduct ring;

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

    public void eatFood(Food food) {
        int i = 0;
        for(Food f : Food.values()) {
            if(food == f) {
                this.food[i]--;
            }
            i++;
        }
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

    public int getBestFlowersValue() {
        int best = 0;
        for(int i = 0; i < flowers.length; i++) {
            if(flowers[i] > 0) {
                switch(i) {
                    case 0: if(5 > best) best = 5; break;
                    case 1: if(4 > best) best = 4; break;
                    case 2: if(3 > best) best = 3; break;
                    case 3: if(2 > best) best = 2; break;
                    case 4: if(1 > best) best = 1; break;
                }
            }
        }
        return best;
    }

    public void setHead(ToadProduct head) {
        this.head = head;
    }

    public void setBody(ToadProduct body) {
        this.body = body;
    }

    public void setLegs(ToadProduct legs) {
        this.legs = legs;
    }

    public void setFoots(ToadProduct foots) {
        this.foots = foots;
    }

    public ToadProduct getHead() {
        return head;
    }

    public ToadProduct getBody() {
        return body;
    }

    public ToadProduct getLegs() {
        return legs;
    }

    public ToadProduct getFoots() {
        return foots;
    }

    public int getHeadValue() {
        if(head == null) {
            return 0;
        }
        return head.getValue();
    }

    public int getBodyValue() {
        if(body == null) {
            return 0;
        }
        return body.getValue();
    }

    public int getLegsValue() {
        if(legs == null) {
            return 0;
        }
        return legs.getValue();
    }

    public int getFootsValue() {
        if(foots == null) {
            return 0;
        }
        return foots.getValue();
    }

    public ToadProduct getRing() {
        return ring;
    }
    public int getRingValue() {
        if(ring == null) {
            return 0;
        }
        return  ring.getValue();
    }


    public void setRing(ToadProduct ring) {
        this.ring = ring;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "food=" + Arrays.toString(food) +
                ", flowers=" + Arrays.toString(flowers) +
                '}';
    }
}
