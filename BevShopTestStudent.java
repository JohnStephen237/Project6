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

public class BevShopTestStudent {
    BevShop bevShop;

    @Before
    public void setUp() throws Exception {
        bevShop = new BevShop();
    }

    @After
    public void tearDown() throws Exception {
        bevShop = null;
    }

    @Test
    public void testStartNewOrder() {
        bevShop.startNewOrder(10, Day.SATURDAY, "Alice", 22);
        assertEquals(1, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testAddNewBeverage() {
        bevShop.startNewOrder(10, Day.MONDAY, "Bob", 30);
        bevShop.addNewBeverage("Latte", Size.MEDIUM, false, false);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testTotalMonthlySale() {
        bevShop.startNewOrder(10, Day.FRIDAY, "Charlie", 18);
        bevShop.addNewBeverage("Berry Blast", Size.LARGE, 4, true);
        assertEquals(8.0, bevShop.totalMonthlySale(), 0.01);
    }
}
