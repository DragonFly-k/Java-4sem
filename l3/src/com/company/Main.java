package com.company;
import com.company.admin.SortByGas;
import com.company.cars.Taxi;
import com.company.cars.Type;
import com.company.admin.Admin;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Taxi(800, 20.9, 370, Type.BUSINESS));
        cars.add(new Taxi(200, 30.4, 200, Type.STANDART));
        cars.add(new Taxi(500, 24.7, 260, Type.COMFORT));
        System.out.println("-----------------------------------------------------");
        for (Car car:cars) {
            System.out.println(car);
        }
        System.out.println("-----------------------------------------------------");
        Collections.sort(cars, new SortByGas());
        for (Car car:cars)
        {
            System.out.println(car);
        }
        System.out.println("-----------------------------------------------------");
        Admin admin =new Admin();
        admin.CountPrice(cars);
        admin.SearchCar(cars, 300, 400);
    }
}