import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.rmi.IHelloWorld;

public class SpringRmiClientTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IHelloWorld helloWorld =  applicationContext.getBean("helloWorld", IHelloWorld.class);
        System.out.println(helloWorld.sayHelloToSomeBody("abc"));
    }

}
