package spring.rmi;

public class HelloWorld implements IHelloWorld {
    public String helloWorld() {
        return "Hello World!";
    }

    public String sayHelloToSomeBody(String someBodyName) {
        return "Hello World!" + someBodyName;
    }

}