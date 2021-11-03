package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<String> selecttopping = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> topping = new ArrayList<>();

    public static void main(String[] args) {
        toppingsavailable();
        boolean validsize = false;
        double total = 0;
        String pizzasize = " ";
        while (validsize == false) {
            System.out.println("what size pizza? small, medium or large");
            pizzasize = input.next();
            if (pizzasize.equals("small")) {
                total = 7.99;
                validsize = true;
            } else if (pizzasize.equals("medium")) {
                total = 10.99;
                validsize = true;
            } else if (pizzasize.equals("large")) {
                total = 13.99;
                validsize = true;
            }
        }
        System.out.println(topping);
        try {
                toppingschoice();
        } catch (InputMismatchException e) {
            System.out.println("number too long" + e);
            input.next();
        }
        total = total + ((selecttopping.size() - 2) * 1.25);
        System.out.print("a " + pizzasize + " pizza with the toppings ");
        for (int i = 0; i < (selecttopping.size()); i++) {
            System.out.print(selecttopping.get(i) + " ,");
        }
        System.out.println();
        System.out.println("the total is " + total);
    }

    public static ArrayList<String> toppingschoice() {
        toppingsavailable();
        for (int i = 0; i < 2; i++) {

            System.out.println("what toppings? ");

            String choiceone = input.next();
            if (topping.contains(choiceone)) {
                selecttopping.add(choiceone);
            }

            if (i == 1) {
                System.out.println("would you like another topping? yes or no");
                String choice = input.next();
                if (choice.equals("yes")) {
                    i--;
                }
            }
        }
        return selecttopping;
    }

    public static ArrayList<String> toppingsavailable(){
        topping.add("pepperoni");
        topping.add("mushroom");
        topping.add("extra cheese");
        topping.add("sausage");
        topping.add("onion");
        topping.add("black olive");
        topping.add("fresh garlic");
        topping.add("tomato");
        topping.add("fresh basil");
        return topping;

    }
}
