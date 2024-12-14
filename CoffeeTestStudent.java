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

public class CoffeeTestStudent {
    Coffee coffee1, coffee2;

    @Before
    public void setUp() throws Exception {
        coffee1 = new Coffee("Regular Coffee", Size.SMALL, false, false);
        coffee2 = new Coffee("Espresso", Size.LARGE, true, true);
    }

    @After
    public void tearDown() throws Exception {
        coffee1 = coffee2 = null;
    }

    @Test
    public void testCalculatePrice() {
        assertEquals(2.0, coffee1.calculatePrice(), 0.01);
        assertEquals(4.0, coffee2.calculatePrice(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue(coffee1.toString().contains("Regular Coffee"));
        assertTrue(coffee2.toString().contains("Espresso"));
        assertTrue(coffee2.toString().contains("LARGE"));
    }
}
