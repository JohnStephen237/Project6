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

public class AlcoholTestStudent {
    Alcohol alcohol1, alcohol2;

    @Before
    public void setUp() throws Exception {
        alcohol1 = new Alcohol("Mojito", Size.SMALL, false);
        alcohol2 = new Alcohol("Whiskey", Size.LARGE, true);
    }

    @After
    public void tearDown() throws Exception {
        alcohol1 = alcohol2 = null;
    }

    @Test
    public void testCalculatePrice() {
        assertEquals(2.0, alcohol1.calculatePrice(), 0.01);
        assertEquals(4.6, alcohol2.calculatePrice(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue(alcohol1.toString().contains("Mojito"));
        assertTrue(alcohol2.toString().contains("Whiskey"));
        assertTrue(alcohol2.toString().contains("LARGE"));
    }
}
