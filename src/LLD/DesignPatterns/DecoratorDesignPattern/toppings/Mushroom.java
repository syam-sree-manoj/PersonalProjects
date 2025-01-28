package LLD.DesignPatterns.DecoratorDesignPattern.toppings;

import LLD.DesignPatterns.DecoratorDesignPattern.basePizzas.Pizza;

public class Mushroom extends ToppingDecorator{
    Pizza basePizza;
    public Mushroom(Pizza pizza){
        this.basePizza = pizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 100;
    }
}
