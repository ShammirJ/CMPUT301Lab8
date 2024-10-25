package com.example.lab8;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    public void testDeleteCity() {
        City city = new City("Estevan", "SK");
        list.addCity(city);
        Assertions.assertTrue(list.hasCity(city)); // Ensure the city was added

        // Delete the city and check that it's removed
        list.deleteCity(city);
        assertFalse(list.hasCity(city)); // Ensure the city was removed

        // Attempt to delete a city that doesn't exist and expect an exception
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city);
        });
    }
    @Test
    public void hasCityTest() {
        City city = new City("Estevan", "SK");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        Assertions.assertTrue(list.hasCity(city));
    }
    @Test
    public void testCountCities() {
        // Initially, the list should be empty
        assertEquals(0, list.countCities());

        // Add a city and check the count
        City city1 = new City("Edmonton", "AB");
        list.addCity(city1);
        assertEquals(1, list.countCities());

        // Add another city and check the count again
        City city2 = new City("Regina", "SK");
        list.addCity(city2);
        assertEquals(2, list.countCities());

        // Remove a city and check the count
        list.deleteCity(city1);
        assertEquals(1, list.countCities());

        // Remove the last city and check if the list is empty
        list.deleteCity(city2);
        assertEquals(0, list.countCities());
    }
}
