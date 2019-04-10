import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * RMI服务获取客户端口
 */
public class RmiClient {
    /**
     * 服务缓存
     */
    private final static Map cacheMap = new HashMap();
    /**
     * 默认服务地址
     */
    private final static String DEFAULT_IP = "127.0.0.1";
    /**
     * 默认端口
     */
    private final static int DEFAULT_PORT = 1199;

    /**
     * 类单例
     *
     * @return
     */
    public static RmiClient getInstance() {
        return InstanceHolder.instance;
    }


    /**
     * 获取RMI服务
     *
     * @param clazz 接口类
     * @param <T>
     * @return
     */
    public static <T> T getRemoteService(Class<T> clazz) {
        return getRemoteService(DEFAULT_IP, DEFAULT_PORT, clazz);
    }

    /**
     * 获取RMI服务
     *
     * @param ip
     * @param port
     * @param clazz 接口类
     * @param <T>
     * @return
     */
    public static <T> T getRemoteService(String ip, int port, Class<T> clazz) {
        return getRemoteService(ip, port, clazz.getSimpleName(), clazz);
    }

    /**
     * 获取RMI服务
     *
     * @param ip          地址
     * @param port        端口
     * @param serviceName 服务名
     * @param clazz       接口类
     * @param <T>
     * @return
     */
    public static <T> T getRemoteService(String ip, int port, String serviceName, Class<T> clazz) {
        String serviceUrl = "rmi://" + ip + ":" + port + "/" + serviceName;
        return getRemoteService(serviceUrl, clazz);
    }


    private synchronized static <T> T getRemoteService(String serviceUrl, Class<T> clazz) {
        T result = (T) cacheMap.get(clazz.getName());
        if (null == result) {
            RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
            rmiProxyFactoryBean.setServiceInterface(clazz);
            rmiProxyFactoryBean.setServiceUrl(serviceUrl);
            rmiProxyFactoryBean.setLookupStubOnStartup(false);
            rmiProxyFactoryBean.setRefreshStubOnConnectFailure(true);
            rmiProxyFactoryBean.afterPropertiesSet();
            result = (T) rmiProxyFactoryBean.getObject();
            cacheMap.put(clazz.getName(), result);
            return result;
        }
        return result;
    }

    private RmiClient() {
    }

    private static class InstanceHolder {
        private final static RmiClient instance = new RmiClient();
    }
}
