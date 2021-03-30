package LambdaExamples;

/**
 * Anonymous classes are inner classes with no name. Since they have no name, we can't use them in order
 * to create instances of anonymous classes. As a result, we have to declare and instantiate anonymous
 * classes in a single expression at the point of use.
 */
interface Greet
{
    void sayHello();
}

class Implementor implements Greet {

    public void sayHello() {
        System.out.println("Greetings earthlings!");
    }
}

public class AnonynousAndInterface{

    public static void main(String[] args){
        Greet object1 = new Implementor();
        object1.sayHello();

    // create an anonymous
    Greet object2 = new Greet()
    {
        public void sayHello()
        {
            System.out.println("We come in peace!");
        }
    };
    object2.sayHello();
   }
}

