package LLD.DesignPatterns.DecoratorDesignPattern.toppings;

import LLD.DesignPatterns.DecoratorDesignPattern.basePizzas.Pizza;

public class ExtraCheese extends ToppingDecorator{

    Pizza basePizza;
    public ExtraCheese(Pizza pizza){
        this.basePizza = pizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 50;
    }
}
