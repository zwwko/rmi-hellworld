import com.hesc.urp.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.rmi.IHelloWorld;

public class SpringRmiClientTest {
    public static void main(String[] args) {
        UrpService urpService = RmiClient.getRemoteService(UrpService.class);
//        urpService = RmiClient.getRemoteService("192.168.79.185 ",1199,UrpService.class);
        RoleService roleService = RmiClient.getRemoteService(RoleService.class);
        ResourceService resourceService = RmiClient.getRemoteService(ResourceService.class);
        OrganizationService organizationService = RmiClient.getRemoteService(OrganizationService.class);
        UsergroupService usergroupService = RmiClient.getRemoteService(UsergroupService.class);
        RolegroupService rolegroupService = RmiClient.getRemoteService(RolegroupService.class);
        ResourcegroupService resourcegroupService = RmiClient.getRemoteService(ResourcegroupService.class);
        PermissiontreeService permissiontreeService = RmiClient.getRemoteService(PermissiontreeService.class);


        System.out.println(urpService.getUserById("1"));
        System.out.println(roleService.getRolesByUser("1"));
        System.out.println(resourceService.selectList());
        System.out.println(organizationService.getOrgsZtreeJson());
        System.out.println(usergroupService.selectList());
        System.out.println(rolegroupService.selectCount());
        System.out.println(resourcegroupService.selectCount());
        System.out.println(permissiontreeService.selectCount());
    }

    public static void urpTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UrpService urpService = applicationContext.getBean("urpService", com.hesc.urp.service.UrpService.class);
        RoleService roleService = applicationContext.getBean("roleService", com.hesc.urp.service.RoleService.class);
        System.out.println(urpService.getUserById("1"));
        System.out.println(roleService.getRolesByUser("1"));

    }

    public static void helloWorld() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IHelloWorld helloWorld = applicationContext.getBean("helloWorld", IHelloWorld.class);
        System.out.println(helloWorld.sayHelloToSomeBody("abc"));

    }

 
}
