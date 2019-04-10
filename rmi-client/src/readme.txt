服务端spring配置发布
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="org.springframework.remoting.rmi.RmiServiceExporter">
        <!--接口实现类-->
        <property name="service" ref="urpService"/>
        <!--对外服务名称-->
        <property name="serviceName" value="UrpService"/>
        <property name="serviceInterface" value="com.hesc.urp.service.UrpService"/>
        <property name="registryPort" value="${rmi.port:1199}"/>
    </bean>
    <bean class="org.springframework.remoting.rmi.RmiServiceExporter">
        <!--接口实现类-->
        <property name="service" ref="roleService"/>
        <!--对外服务名称-->
        <property name="serviceName" value="RoleService"/>
        <property name="serviceInterface" value="com.hesc.urp.service.RoleService"/>
        <property name="registryPort" value="${rmi.port:1199}"/>
    </bean>
</beans>