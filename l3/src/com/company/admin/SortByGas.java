package com.company.admin;
import com.company.Car;
import java.util.Comparator;

public class SortByGas implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getGas() > o2.getGas()) {
            return 1;
        }
        if (o1.getGas() == o2.getGas()) {
            return 0;
        }
        return -1;
    }
}