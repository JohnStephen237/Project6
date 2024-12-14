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


public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private static final double EXTRA_COST = 0.5;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) price += EXTRA_COST;
        if (extraSyrup) price += EXTRA_COST;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup + ", Price: $" + calcPrice();
    }
}