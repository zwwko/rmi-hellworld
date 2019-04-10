package raw.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello {

    private static final long serialVersionUID = 1961558474342609777L;

    public HelloImpl() throws RemoteException {
        super();
    }

    public String sayHello(String name) {
        return "Hello, " + name;
    }

    public int sum(int a, int b) {
        return a + b;
    }
}