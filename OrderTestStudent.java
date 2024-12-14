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

public class OrderTestStudent {
    Order order1;

    @Before
    public void setUp() throws Exception {
        order1 = new Order(8, Day.MONDAY, new Customer("John", 25));
    }

    @After
    public void tearDown() throws Exception {
        order1 = null;
    }

    @Test
    public void testAddNewBeverage() {
        assertEquals(0, order1.getTotalItems());
        order1.addNewBeverage("Espresso", Size.SMALL, false, false);
        assertEquals(1, order1.getTotalItems());
        order1.addNewBeverage("Mojito", Size.LARGE);
        assertEquals(2, order1.getTotalItems());
    }

    @Test
    public void testCalcOrderTotal() {
        order1.addNewBeverage("Espresso", Size.SMALL, false, false);
        order1.addNewBeverage("Berry Blast", Size.MEDIUM, 3, true);
        assertEquals(8.5, order1.calcOrderTotal(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue(order1.toString().contains("John"));
        assertTrue(order1.toString().contains("MONDAY"));
    }
}
