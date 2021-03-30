package java8_lambda;

//functional interface - can have only ONE METHOD

@FunctionalInterface
public interface Calculate {
    int calc(int x, int y);

}
