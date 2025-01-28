package LLD.DesignPatterns.StrategyDesignPattern;

import LLD.DesignPatterns.StrategyDesignPattern.strategy.DriveStrategy;

/*

Vehicle has drive strategy

 */
public class Vehicle {
    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    void drive(){
        driveStrategy.drive();
    }
}
