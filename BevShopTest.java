public class BevShopTest {
    public static void main(String[] args) {
        BevShop bevShop = new BevShop();

        // Start a new order
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);

        // Test adding coffee
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);

        // Test adding smoothie
        bevShop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);

        // Test adding alcohol (age > 21)
        bevShop.processAlcoholOrder("Whiskey", Size.SMALL);

        // Test alcoholic drink limit
        bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
        bevShop.processAlcoholOrder("Wine", Size.LARGE);
        try {
            bevShop.processAlcoholOrder("Tequila", Size.SMALL); // Should fail
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        // Validate order total
        System.out.println("Order total: $" + bevShop.getCurrentOrder().calcOrderTotal());

        // Validate total number of orders
        System.out.println("Total orders: " + bevShop.totalNumOfMonthlyOrders());
    }
}
