package LLD.DesignPatterns.DecoratorDesignPattern.basePizzas;

import LLD.DesignPatterns.DecoratorDesignPattern.basePizzas.Pizza;

public class VegDelight extends Pizza {
    @Override
    public int cost() {
        return 200;
    }
}
