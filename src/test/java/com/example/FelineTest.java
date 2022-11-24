package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class FelineTest {

    @Test
    public void felineEatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> actualFoodList = feline.eatMeat();
        List<String> expectedList = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedList, actualFoodList);
    }

    @Test
    public void felineGetFamilyTest() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void felineKittensTest() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        assertEquals(1, actualKittens);
    }
}