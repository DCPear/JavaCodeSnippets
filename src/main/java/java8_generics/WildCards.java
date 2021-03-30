package java8_generics;

import java8_generics.Building;

import java.util.ArrayList;
import java.util.List;

class Building2 {

    public int numberOfRooms = 7;

    @Override
    public String toString() {
        return ("building");
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

}

class House extends Building {

   public int numberOfRooms = 10;

   @Override
   public String toString() {
       return ("house");
   }

   public int getNumberOfRooms() {
       return numberOfRooms;
   }

   public void setNumberOfRooms(int numberOfRooms) {
       this.numberOfRooms = numberOfRooms;
   }

}

class Office2 extends Building {

    @Override
    public String toString() {
        return ("office");
    }


}

public class WildCards {

    // instead of static void printBuildings(List<Building> buildings)
    //This means that lists of any type that extends the building class can be passed.
    static void printBuildings(List<? extends Building> buildings) {
        for(int i = 0; i < buildings.size(); i++) {
            System.out.println(buildings.get(i).toString() + " " + (i + 1));
        }
        System.out.println();
    }

    //Wildcards can also be used to specify that super types can be used when a subtype is specified
    static void addHouseToList(List<? super House> buildings) {
        buildings.add(new House());
        System.out.println(buildings);
    }

    public static void main(String[] args) {

        // List of buildings
        List<Building> buildings = new ArrayList();
        buildings.add(new Building());
        buildings.add(new Building());
        printBuildings(buildings);

        List<Building> mix= new ArrayList();
        mix.add(new Building());
        mix.add(new Office());
        printBuildings(mix);

        // List of offices
        List<Office> offices = new ArrayList();
        offices.add(new Office());
        offices.add(new Office());
        printBuildings(offices);

        // List of houses
        List<House> houses = new ArrayList();
        houses.add(new House());
        houses.add(new House());
        printBuildings(houses);

        addHouseToList(houses);
        addHouseToList(buildings);
        /**
         * If you are unsure about when to use extends and when to use super with wildcards, you can think about
         * invariables and outvariables. In the printBuildings method, I am passing in a list which provides data
         * which I use inside the method, so this in an invariable. With invariables, it makes sense to use extends.
         * In the addHouseToList method, I am using the method to give additional data by adding to the list.
         * So this is an outvariable. And in this case it makes sense to use super. Also note that it is generally
         * a bad idea to use wildcards as return types for a method. If I did this, anyone else who used these methods
         * would have to spend time working out the hierarchies in my code. When used in the right places, wildcards
         * can make your code more flexible and helps to get rid of duplicate methods.
         */
    }
}
