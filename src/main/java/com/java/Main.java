package com.java;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/13/2016
 * Time: 6:12 PM
 */
public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(1, "a");
        map.put(3, "b");
        map.put(6, "c");
        map.put(4, "d");
        map.put(2, "e");
        map.put(5, "f");

        TreeMap<Car, String> map2 = new TreeMap<>();
        map2.put(new Car("Toyota Sienna", 2015), "Sienna");
        map2.put(new Car("Nissan Altima", 2004), "Altima");
        map2.put(new Car("Honda Accord", 2013), "Accord");
        System.out.println(map2);

        final Comparator<Car> comparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.model- o2.model;
            }
        };
        TreeMap<Car, String> map3 = new TreeMap<>(comparator);
        map3.put(new Car("Toyota Sienna", 2015), "Sienna");
        map3.put(new Car("Nissan Altima", 2004), "Altima");
        map3.put(new Car("Honda Accord", 2013), "Accord");
        System.out.println(map3);
    }

    private static class Car implements Comparable<Car>{
        private String name;
        private int model;

        public Car(String name, int model) {
            this.name = name;
            this.model = model;
        }

        @Override
        public boolean equals(Object o) {
            System.out.println("I'm in equals");
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Car car = (Car) o;

            if (model != car.model) return false;
            return !(name != null ? !name.equals(car.name) : car.name != null);

        }

        @Override
        public int hashCode() {
            System.out.println("I'm in hashCode");
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + model;
            return result;
        }

        @Override
        public int compareTo(Car o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Car{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
