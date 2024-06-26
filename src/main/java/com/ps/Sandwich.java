package com.ps;

import java.util.ArrayList;
import java.util.List;


public class Sandwich extends Product{

    private int size;
    private String breadType;
    private List<String> meats;
    private List<Boolean> extraMeats;
    private List<String> cheeses;
    private List<Boolean> extraCheeses;
    private List<String> regularToppings;
    private List<String> sauces;
    private List<String> sides;
    private boolean toasted;

    public Sandwich(int size, String breadType) {
        this.size = size;
        this.breadType = breadType;
        this.meats = new ArrayList<>();
        this.extraMeats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.extraCheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
    }

    public void addSide(String side){
        sides.add(side);
    }

    public void addMeat(String meat, boolean extra) {
        meats.add(meat);
        extraMeats.add(extra);
    }

    public void addCheese(String cheese, boolean extra) {
        cheeses.add(cheese);
        extraCheeses.add(extra);
    }

    public void addRegularTopping(String topping) {
        regularToppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    /*
    Here we use size as the case for our switch because when doing our calcPrice() this will make it easy to get the values for each price
    as the size will stay consistent for the topping. We will use the corresponding price for the size of the bread
     */

    private double getBreadPrice() {
        switch (size) {
            case 4:
                return 5.50;
            case 8:
                return 7.00;
            case 12:
                return 8.50;
            default:
                return 0;
        }
    }

    private double getMeatPrice() {
        switch (size) {
            case 4:
                return 1.00;
            case 8:
                return 2.00;
            case 12:
                return 3.00;
            default:
                return 0;
        }
    }

    private double getExtraMeatPrice() {
        switch (size) {
            case 4:
                return 0.50;
            case 8:
                return 1.00;
            case 12:
                return 1.50;
            default:
                return 0;
        }
    }

    private double getCheesePrice() {
        switch (size) {
            case 4:
                return 0.75;
            case 8:
                return 1.50;
            case 12:
                return 2.25;
            default:
                return 0;
        }
    }

    private double getExtraCheesePrice() {
        switch (size) {
            case 4:
                return 0.30;
            case 8:
                return 0.60;
            case 12:
                return 0.90;
            default:
                return 0;
        }
    }

    @Override
    public double calcPrice() {
        // initialize the price with the bread as its the first option always
        price = getBreadPrice();

        // each meat topping based on how many meat toppings there are (meats.size() = length of the list to iterate so we keep adding to price
        for (int i = 0; i < meats.size(); i++) {
            if (extraMeats.get(i)) {
                price += getExtraMeatPrice();
            } else {
                price += getMeatPrice();
            }
        }

        for (int i = 0; i < cheeses.size(); i++) {
            if (extraCheeses.get(i)) {
                price += getExtraCheesePrice();
            } else {
                price += getCheesePrice();
            }
        }

        return price;
    }

    @Override
    public String toString() {

        return "Sandwich: " +
                "  Size: " + size + "\"" +
                ", Bread Type = " + breadType + "" +
                ", Meats: " + meats +
                ", Extra Meats = " + extraMeats + "\n" +
                " \t \t\tCheeses = " + cheeses +
                ", Extra Cheeses = " + extraCheeses + "\n" +
                " \t \t\tRegular Toppings = " + regularToppings +
                ", Sauces = " + sauces +
                ", Sides = " + sides +
                ", Toasted = " + toasted
                ;
    }
}
