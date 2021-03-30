package java8_generics;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.baeldung.com/java-liskov-substitution-principle
 * https://stackify.com/solid-design-liskov-substitution-principle/
 * https://dzone.com/articles/the-liskov-substitution-principle-with-examples
 * SOLID design principles help us create more maintainable, understandable, and flexible software.
 * Liskov Substitution Principle, which is the “L” in the acronym.
 * **SOLID**
 * Single Responsibility Principle
 * Open/Closed Principle
 * Liskov Substitution Principle
 * Interface Segregation Principle
 * Dependency Inversion
 * in short It just means that if you have a variable of a given type you can assign it to a value that is a subtype
 * of that type.
 */

class Building {

    @Override
    public String toString() {
        return("building");
    }

}

class Office extends Building {

    @Override
    public String toString() {
        return ("office");
    }

}

public class LisKovSubs {

    static void build(Building building) {
        System.out.println("Constructing a new " + building.toString());
    }

    static void printBuildings(List<Building> buildings) {
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println(i + 1 + ": " + buildings.get(i).toString());
        }
    }

    public static void main(String[] args) {
        Building building = new Building();
        Office office = new Office();
        build(building); //prints "Constructing a new building"
        //substitution principle-because office is a subtype of building
        build(office); //prints Constructing a new office

        List<Building> buildings = new ArrayList();
        buildings.add(new Building());
        //substitution principle-because office is a subtype of building
        buildings.add(new Office());
        printBuildings(buildings);

        List<Office> offices = new ArrayList();
        offices.add(new Office());
        offices.add(new Office());
       // printBuildings(offices); compilation error
       //The substitution principle lets you assign variables of a given type to the subtype but the principle
       // does not apply with types of lists, because list of type office is not a subtype of a list of type building.
       //One solution would be to create a new method for each different subtype of building. But a quicker and simpler
        // solution is to use wildcards
       // This behaviour can be changed with wild cards.
    }
}
