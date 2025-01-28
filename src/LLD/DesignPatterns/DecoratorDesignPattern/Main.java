package LLD.DesignPatterns.DecoratorDesignPattern;

import LLD.DesignPatterns.DecoratorDesignPattern.basePizzas.Pizza;
import LLD.DesignPatterns.DecoratorDesignPattern.basePizzas.VegDelight;
import LLD.DesignPatterns.DecoratorDesignPattern.toppings.ExtraCheese;
import LLD.DesignPatterns.DecoratorDesignPattern.toppings.Mushroom;

public class Main  {
    public static void main(String[] args) {
        // deep inside class should be base pizza or minimum product
        // on minimum product we add toppings or features
        Pizza pizza = new Mushroom (new ExtraCheese (new VegDelight()));

        System.out.println(pizza.cost());


        Pizza pizza1 = new Mushroom (new VegDelight());
        System.out.println(pizza1.cost());
    }
}
