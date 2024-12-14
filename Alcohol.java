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


public class Alcohol extends Beverage {
    private boolean isWeekend;
    private static final double WEEKEND_COST = 0.6;

    public Alcohol(String name, Size size, boolean isWeekend) {
        super(name, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (isWeekend) price += WEEKEND_COST;
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Weekend: " + isWeekend + ", Price: $" + calcPrice();
    }
}
