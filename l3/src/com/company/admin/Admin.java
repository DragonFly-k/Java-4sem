package com.company.admin;
import com.company.Car;
import java.util.ArrayList;
import java.util.Collections;

public class Admin implements IAdmin
{
    @Override
    public void CountPrice(ArrayList<Car> cars) {
        int sum = 0;
        for (Car car: cars) {
            sum+=car.getPrice();
        }
        System.out.println(sum);
    }

    @Override
    public void SortByGas(ArrayList<Car> cars) {
        Collections.sort(cars, new SortByGas());
    }

    @Override
    public void SearchCar(ArrayList<Car> cars, int speed1, int speed2) {
        for (Car car:cars)
        {
            if (car.getSpeed() > speed1 && car.getSpeed() < speed2)
            {
                    System.out.println(car);
            }
        }
    }
}