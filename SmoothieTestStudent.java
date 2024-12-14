/*
 * Class: CMSC203 30371
 * Instructor: Professor Thai
 * Description: Project 6
 * Due: 12/13/2024
 * Platform/compiler: Visual Studio Code
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Johan Mbouwa Fokoua
*/


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmoothieTestStudent {
    Smoothie smoothie1, smoothie2;

    @Before
    public void setUp() throws Exception {
        smoothie1 = new Smoothie("Berry Blast", Size.SMALL, 2, true);
        smoothie2 = new Smoothie("Green Detox", Size.LARGE, 5, false);
    }

    @After
    public void tearDown() throws Exception {
        smoothie1 = smoothie2 = null;
    }

    @Test
    public void testCalculatePrice() {
        assertEquals(5.5, smoothie1.calculatePrice(), 0.01);
        assertEquals(8.0, smoothie2.calculatePrice(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue(smoothie1.toString().contains("Berry Blast"));
        assertTrue(smoothie2.toString().contains("Green Detox"));
        assertTrue(smoothie1.toString().contains("2 Fruits"));
    }
}
