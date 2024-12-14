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
import com.bevshop.enums.Type; // Import Type enum
import com.bevshop.enums.Size; // Import Size enum
import com.bevshop.enums.Day; // Import Day enum

// Abstract Class: Beverage
public abstract class Beverage {
    private String name;
    private Type type;
    private Size size;
    private static final double BASE_PRICE = 2.0;
    private static final double SIZE_PRICE = 0.5;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public double addSizePrice() {
        return BASE_PRICE + (size == Size.MEDIUM ? SIZE_PRICE : size == Size.LARGE ? 2 * SIZE_PRICE : 0);
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return "Beverage: " + name + ", Size: " + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beverage beverage = (Beverage) obj;
        return name.equals(beverage.name) && type == beverage.type && size == beverage.size;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
