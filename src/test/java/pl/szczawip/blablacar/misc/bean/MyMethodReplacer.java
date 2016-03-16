package pl.szczawip.blablacar.misc.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;


public class MyMethodReplacer implements MethodReplacer {

    public Object reimplement(Object o, Method m, Object[] args) throws Throwable {
        return "method-replaced";
    }
}