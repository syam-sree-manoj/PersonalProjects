package LLD.DesignPatterns.StrategyDesignPattern;

import LLD.DesignPatterns.StrategyDesignPattern.strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{

    SportsVehicle(){
        super( new SportsDriveStrategy());
    }
}
