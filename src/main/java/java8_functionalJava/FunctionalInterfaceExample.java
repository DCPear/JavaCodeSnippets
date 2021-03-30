package java8_functionalJava;

/**
 * https://www.baeldung.com/java-8-functional-interfaces
 */

@FunctionalInterface
 interface GreetingMessage {
    public abstract void greet(String name);
}

@FunctionalInterface
interface MessagePrinter {
    public abstract void printMessage();
}

@FunctionalInterface
 interface Shapes {
    public abstract int getArea(Square side);
}

class Square {
    int sideLength;
    public Square(int sideLength) {
        this.sideLength = sideLength;
    }
    public int calculateArea() {
        return sideLength*sideLength;
    }
}

public class functionalInterfaceExample {

    //Using Lambda - before
    public static void main(String[] args) {
        GreetingMessage gm = new GreetingMessage() {
            @Override
            public void greet(String name) {
                System.out.println("Hello there, I am in " + name);
            }
        };
        gm.greet("Wellington");

         //after
        GreetingMessage gm2 =(name)->{
            System.out.println("Hello there, I am in " + name);
        };
        gm2.greet("New Zealand");

        MessagePrinter mp =()->{
            System.out.println("Printing a Message");
        };
        mp.printMessage();

        //using a method reference before
        Square sq= new Square(16);
        Shapes shapes = (Square square)->{
            return square.calculateArea();
        };
        System.out.println("Area 1: " + shapes.getArea(sq) );

        //after
        Shapes shapes2 = Square::calculateArea;
        System.out.println("Area 2: " + shapes.getArea(sq) );
    }

    /**
     * Streams replaces external iterator for each
     * issues with external iteration
     * Hard to write parallel iterations, requires boiler plate code, difficult to read meaning, Hard to abstract
     * away from behavious
     * solution - Streams. Streams use internal iteration
     * Streams have two different types of methods, lazy methods and eager methods.
     */
    //Streams to iterate before and after

}
