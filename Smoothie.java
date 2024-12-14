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


public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    private static final double FRUIT_COST = 0.5;
    private static final double PROTEIN_COST = 1.5;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        price += numOfFruits * FRUIT_COST;
        if (addProtein) price += PROTEIN_COST;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fruits: " + numOfFruits + ", Protein: " + addProtein + ", Price: $" + calcPrice();
    }
}