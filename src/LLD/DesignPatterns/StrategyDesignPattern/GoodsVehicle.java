package LLD.DesignPatterns.StrategyDesignPattern;

import LLD.DesignPatterns.StrategyDesignPattern.strategy.DriveStrategy;
import LLD.DesignPatterns.StrategyDesignPattern.strategy.NormalDriveStrategy;
import LLD.DesignPatterns.StrategyDesignPattern.strategy.SportsDriveStrategy;

public class GoodsVehicle extends Vehicle{

    GoodsVehicle(){
        super( new NormalDriveStrategy());
    }
}
