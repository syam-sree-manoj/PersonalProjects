package LLD.DesignPatterns.StrategyDesignPattern;

import LLD.DesignPatterns.StrategyDesignPattern.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    OffRoadVehicle(){
        super(new SportsDriveStrategy());
    }
}
