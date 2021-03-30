package java8_lambda;
/**
 * Anonymous classes enable you to make your code more concise. They enable you to declare and instantiate a
 * class at the same time. They are like local classes except that they do not have a name. Use them if you
 * need to use a local class only once.
 * https://www.baeldung.com/java-anonymous-classes
 * It should be used if you have to override method of class or interface. Java Anonymous inner class can be created
 * by two ways:
 *
 * Class (may be abstract or concrete).
 * Interface
 */
class Hello {
    public void sayHello(){
        System.out.println("Hello there!");
    }
}

class Welcome extends Hello{
    public void sayHello(){
        System.out.println("Hello and Welcome!");
    }
}

public class Anonymous {

    //calling sayHello
    public static void main(String[] args){
         Hello object1 = new Hello();
         object1.sayHello();

        //method has to be overridden in order to change the existing behaviour
        Hello object2 = new Welcome();
        object2.sayHello();

        //replace the overridden behaviour with an anonymous class for one time use. cannot be re-used.
        // The welcome class can be deleted.
        Hello object3 = new Hello(){
            public void sayHello(){
                System.out.println("you can leave now!!");
            }
        };
        object3.sayHello();
    }

}
