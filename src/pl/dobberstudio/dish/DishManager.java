package pl.dobberstudio.dish;

import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.eq.Dish;
import pl.dobberstudio.game.eq.Equipment;
import pl.dobberstudio.game.eq.Food;
import pl.dobberstudio.game.locations.ToadProduct;


public class DishManager {

    public static ToadProduct makeSandwich(Equipment equipment, GameManager gm) {
        if((equipment.getFoodAmount(Food.BREAD) > 0) && (equipment.getFoodAmount(Food.CHEESE) > 0) && ((equipment.getFoodAmount(Food.HAM) > 0) || (equipment.getFoodAmount(Food.SAUSAGE) > 0))) {
            ToadProduct dish = new ToadProduct(gm, "res/dishes/sandwich.png", 320, 300, 0);
            equipment.eatFood(Food.BREAD);
            equipment.eatFood(Food.CHEESE);
            if(equipment.getFoodAmount(Food.HAM) > 0) {
                equipment.eatFood(Food.HAM);
            } else {
                equipment.eatFood(Food.SAUSAGE);
            }
            dish.setValue(1);
            dish.setDish(Dish.SANDWICH);
            return dish;
        }

        return null;
    }

    public static ToadProduct makeToast(Equipment equipment, GameManager gm) {
        if((equipment.getFoodAmount(Food.BREAD) > 0) && (equipment.getFoodAmount(Food.CHEESE) > 0) && (equipment.getFoodAmount(Food.EGGS) > 0)) {
            ToadProduct dish = new ToadProduct(gm, "res/dishes/toast.png", 320, 300, 0);
            equipment.eatFood(Food.BREAD);
            equipment.eatFood(Food.CHEESE);
            equipment.eatFood(Food.EGGS);
            dish.setValue(2);
            dish.setDish(Dish.TOAST);
            return dish;
        }

        return null;
    }

    public static ToadProduct makeDrink(Equipment equipment, GameManager gm) {
        if((equipment.getFoodAmount(Food.WINE) > 0) && ((equipment.getFoodAmount(Food.TEA) > 0) || (equipment.getFoodAmount(Food.MILK) > 0)) && ((equipment.getFoodAmount(Food.BEER) > 0) || (equipment.getFoodAmount(Food.BEERS) > 0))) {
            ToadProduct dish = new ToadProduct(gm, "res/dishes/drink.png", 320, 300, 0);
            equipment.eatFood(Food.WINE);
            if(equipment.getFoodAmount(Food.TEA) > 0) {
                equipment.eatFood(Food.TEA);
            } else {
                equipment.eatFood(Food.MILK);
            }
            if(equipment.getFoodAmount(Food.BEER) > 0) {
                equipment.eatFood(Food.BEER);
            } else {
                equipment.eatFood(Food.BEERS);
            }
            dish.setValue(3);
            dish.setDish(Dish.DRINK);
            return dish;
        }

        return null;
    }

    public static ToadProduct makeWine(Equipment equipment, GameManager gm) {
        if((equipment.getFoodAmount(Food.WINE) > 0)  && ((equipment.getFoodAmount(Food.CHEESE) > 0) || (equipment.getFoodAmount(Food.LAYS) > 0))) {
            ToadProduct dish = new ToadProduct(gm, "res/dishes/wine.png", 320, 300, 0);
            equipment.eatFood(Food.WINE);
            if(equipment.getFoodAmount(Food.CHEESE) > 0) {
                equipment.eatFood(Food.CHEESE);
            } else {
                equipment.eatFood(Food.LAYS);
            }
            dish.setValue(4);
            dish.setDish(Dish.WINE);
            return dish;
        }

        return null;
    }

    public static ToadProduct makeCake(Equipment equipment, GameManager gm) {
        if((equipment.getFoodAmount(Food.MILK) > 0) && (equipment.getFoodAmount(Food.EGGS) > 0) && (equipment.getFoodAmount(Food.CHOCKED) > 0)) {
            ToadProduct dish = new ToadProduct(gm, "res/dishes/cake.png", 320, 300, 0);
            equipment.eatFood(Food.MILK);
            equipment.eatFood(Food.EGGS);
            equipment.eatFood(Food.CHOCKED);
            dish.setValue(5);
            dish.setDish(Dish.CAKE);
            return dish;
        }

        return null;
    }

    public static ToadProduct makePasta(Equipment equipment, GameManager gm) {
        if((equipment.getFoodAmount(Food.CHEESE) > 0) && (equipment.getFoodAmount(Food.TOMATOES) > 0) && (equipment.getFoodAmount(Food.PASTA) > 0) && (equipment.getFoodAmount(Food.EGGS) > 0) && ((equipment.getFoodAmount(Food.HAM) > 0) || (equipment.getFoodAmount(Food.SAUSAGE) > 0))) {
            ToadProduct dish = new ToadProduct(gm, "res/dishes/pasta.png", 320, 300, 0);
            equipment.eatFood(Food.PASTA);
            equipment.eatFood(Food.CHEESE);
            equipment.eatFood(Food.TOMATOES);
            equipment.eatFood(Food.EGGS);
            if(equipment.getFoodAmount(Food.HAM) > 0) {
                equipment.eatFood(Food.HAM);
            } else {
                equipment.eatFood(Food.SAUSAGE);
            }
            dish.setValue(6);
            dish.setDish(Dish.PASTA);
            return dish;
        }

        return null;
    }
}
