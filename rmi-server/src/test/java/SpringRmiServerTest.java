import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.rmi.IHelloWorld;

public class SpringRmiServerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IHelloWorld helloWorld = (IHelloWorld) applicationContext.getBean("helloWorld");
        System.out.println(helloWorld.helloWorld());
        System.out.println(helloWorld.sayHelloToSomeBody("Bob"));
    }
}
