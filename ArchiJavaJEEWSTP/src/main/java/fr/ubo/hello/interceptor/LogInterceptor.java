package fr.ubo.hello.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LogInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // Avant l'exécution de la méthode
        System.out.println("Before method execution");

        // Exécution de la méthode cible
        Object result = invocation.proceed();

        // Après l'exécution de la méthode
        System.out.println("After method execution");

        return result;
    }
}
