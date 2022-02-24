package com.company.cars;
import com.company.Car;

public class Taxi extends Car {
    Type type;
    public Taxi(int price, double gas, int speed, Type type) throws Exception
    {
        super(price, gas, speed);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + " type=" + type;
    }
}