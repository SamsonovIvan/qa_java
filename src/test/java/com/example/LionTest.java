package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test()
    public void lionSexHaveException() throws Exception {
        try {
            Lion lion = new Lion(" ", feline);
            lion.doesHaveMane();
        } catch (Exception thrown) {
            assertNotEquals(" ", thrown.getMessage());
        }
    }

    @Test()
    public void incorrectSexReturnExceptionText() throws Exception {
        String sex = "qwe";
        try {
            Lion lion = new Lion(sex, feline);
            Assert.fail("Exception thrown");
        } catch (Exception thrown) {
            assertNotEquals(sex, thrown.getMessage());
        }
    }

    @Test
    public void isLionHaveManeTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualHasMane);
    }

    @Test
    public void getKittensReturnFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void lionEatMeat() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedEatMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualEatMeat = lion.getFood();
        assertEquals(expectedEatMeat, actualEatMeat);
    }
    @Test
    public void lionEatAnotherMeat() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Рыба", "Птицы"));
        List<String> expectedEatMeat = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualEatMeat = lion.getFood();
        assertTrue(expectedEatMeat.size() == actualEatMeat.size() && expectedEatMeat.containsAll(actualEatMeat) && actualEatMeat.containsAll(expectedEatMeat));
    }
}
