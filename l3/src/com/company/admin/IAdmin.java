package com.company.admin;

import com.company.Car;

import java.util.ArrayList;

public interface IAdmin {
    void CountPrice(ArrayList<Car> cars);
    void SortByGas(ArrayList<Car> cars);
    void SearchCar(ArrayList<Car> cars, int speed1, int speed2);
}