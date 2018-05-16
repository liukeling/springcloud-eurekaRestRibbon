package com.lkl.test;

import com.lkl.test.dto.User;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyTest {
    public static void main(String[] args)throws Exception{
        Class clazz = User.class;
        Field[] fields = clazz.getDeclaredFields();
        User u = new User();
        u.setUserName("myNameIsLKL");
        u.setAge(21);
        for(Field f : fields){
            String fieldName = f.getName();
            System.out.println(fieldName);
            Method method = clazz.getMethod("get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1));
            if(method != null){
                Object resul = method.invoke(u);
                System.out.println(resul);
            }
        }
    }
}
