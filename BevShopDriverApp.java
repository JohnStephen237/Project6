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

import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21.\n");

        while (true) {
            System.out.println("Would you like to start a new order? (yes/no)");
            String startOrder = scanner.nextLine();

            if (!startOrder.equalsIgnoreCase("yes")) {
                break;
            }

            System.out.println("Would you please enter your name:");
            String name = scanner.nextLine();

            System.out.println("Would you please enter your age:");
            int age = Integer.parseInt(scanner.nextLine());

            bevShop.startNewOrder(10, Day.MONDAY, name, age);
            Order currentOrder = bevShop.getCurrentOrder();

            if (bevShop.isEligibleForAlcohol()) {
                System.out.println("Your age is above 20, and you are eligible to order alcohol.");
            } else {
                System.out.println("Your age is below 21. You are not eligible to order alcohol.");
            }

            while (true) {
                System.out.println("Would you like to add a drink to your order? (yes/no)");
                String addDrink = scanner.nextLine();
                if (!addDrink.equalsIgnoreCase("yes")) {
                    break;
                }

                System.out.println("What type of drink would you like to add? (ALCOHOL/COFFEE/SMOOTHIE)");
                String drinkType = scanner.nextLine().toUpperCase();

                switch (drinkType) {
                    case "ALCOHOL":
                        if (!bevShop.isEligibleForAlcohol()) {
                            System.out.println("Your age is not appropriate for ordering alcohol drinks!");
                        } else if (!bevShop.isMaxAlcohol()) {
                            System.out.println("Enter the name of the alcoholic beverage:");
                            String alcoholName = scanner.nextLine();
                            System.out.println("Enter the size (SMALL, MEDIUM, LARGE):");
                            String alcoholSize = scanner.nextLine().toUpperCase();

                            currentOrder.addNewBeverage(alcoholName, 
                                                         Type.ALCOHOL, 
                                                         Size.valueOf(alcoholSize));

                            System.out.println("The current order of drinks is " + currentOrder.getBeverageList().size());
                            System.out.println("The total price on the order is: " + currentOrder.calcOrderTotal());
                        } else {
                            System.out.println("You have reached the maximum alcohol drinks for this order.");
                        }
                        break;

                    case "COFFEE":
                        System.out.println("Enter the name of the coffee:");
                        String coffeeName = scanner.nextLine();
                        System.out.println("Enter the size (SMALL, MEDIUM, LARGE):");
                        String coffeeSize = scanner.nextLine().toUpperCase();
                        System.out.println("Would you like extra shot? (yes/no)");
                        boolean extraShot = scanner.nextLine().equalsIgnoreCase("yes");
                        System.out.println("Would you like extra syrup? (yes/no)");
                        boolean extraSyrup = scanner.nextLine().equalsIgnoreCase("yes");

                        currentOrder.addNewBeverage(coffeeName, 
                                                     Type.COFFEE, 
                                                     Size.valueOf(coffeeSize), 
                                                     extraShot, 
                                                     extraSyrup);

                        System.out.println("The current order of drinks is " + currentOrder.getBeverageList().size());
                        System.out.println("The total price on the order is: " + currentOrder.calcOrderTotal());
                        break;

                    case "SMOOTHIE":
                        System.out.println("Enter the name of the smoothie:");
                        String smoothieName = scanner.nextLine();
                        System.out.println("Enter the size (SMALL, MEDIUM, LARGE):");
                        String smoothieSize = scanner.nextLine().toUpperCase();
                        System.out.println("Enter the number of fruits:");
                        int numFruits = Integer.parseInt(scanner.nextLine());
                        System.out.println("Would you like protein powder? (yes/no)");
                        boolean proteinPowder = scanner.nextLine().equalsIgnoreCase("yes");

                        if (numFruits > BevShopInterface.MAX_FRUIT) {
                            System.out.println("You have reached the maximum number of fruits for a smoothie.");
                        } else {
                            currentOrder.addNewBeverage(smoothieName, 
                                                         Type.SMOOTHIE, 
                                                         Size.valueOf(smoothieSize), 
                                                         numFruits, 
                                                         proteinPowder);

                            System.out.println("The current order of drinks is " + currentOrder.getBeverageList().size());
                            System.out.println("The total price on the order is: " + currentOrder.calcOrderTotal());
                        }
                        break;

                    default:
                        System.out.println("Invalid drink type. Please choose ALCOHOL, COFFEE, or SMOOTHIE.");
                }
            }

            System.out.println("Order complete!\n");
        }

        System.out.println("Summary of all orders:");
        System.out.println(bevShop);

        scanner.close();
    }
}
