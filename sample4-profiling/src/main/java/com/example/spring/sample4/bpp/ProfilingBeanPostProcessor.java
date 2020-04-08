package com.example.spring.sample4.bpp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.spring.sample4.Profiling;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ProfilingBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, BeanInfo> beansToProxy = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        List<Method> methods = Arrays
                .stream(bean.getClass().getMethods())
                .filter(m -> m.isAnnotationPresent(Profiling.class))
                .collect(Collectors.toList());
        if (!methods.isEmpty()) {
            beansToProxy.put(beanName, 
                    new BeanInfo(beanName, 
                            bean.getClass().getInterfaces(), 
                            methods.stream().map(ProfilingBeanPostProcessor::getMethodSignature).collect(Collectors.toList())));
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        final BeanInfo info = beansToProxy.get(beanName);
        if (info != null) {
            return Proxy.newProxyInstance(bean.getClass().getClassLoader(), info.interfaces, new InvocationHandler() {

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (info.methodSignatures.contains(getMethodSignature(method))) {
                        long start = System.nanoTime();
                        Object result = method.invoke(bean, args);
                        long end = System.nanoTime();
                        System.out.println(String.format("Bean: %s. Method: %s. Execution time: %d nanoseconds", info.name, getMethodSignature(method), end - start));
                        return result;
                    } else {
                        return method.invoke(bean, args);
                    }
                }
            });
        }
        return bean;
    }
    
    private static String getMethodSignature(Method method) {
        String params = Arrays.stream(method.getParameterTypes()).map(Class::getCanonicalName).collect(Collectors.joining(","));
        return String.format("%s(%s)", method.getName(), params);
    }

    @AllArgsConstructor
    private static class BeanInfo {

        private final String name;
        private final Class<?>[] interfaces;
        private final List<String> methodSignatures;
    }

}
