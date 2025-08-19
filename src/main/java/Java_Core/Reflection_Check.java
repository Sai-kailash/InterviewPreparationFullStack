package Java_Core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection_Check {

    private String name;
    public void displayValue(int a){
        System.out.println(a);
    }
    private void displayStringValue(String a){
        System.out.println(a);
    }

    public static void main(String args[]) throws Exception{
        Class<?> clazz = Reflection_Check.class;
        Method[] methods = clazz.getMethods();

        System.out.println("Methods in Reflection classes are");

        for (Method method : methods) {
            System.out.println(method.toString());
        }

        Reflection_Check check = new Reflection_Check();
        Field name = Reflection_Check.class.getDeclaredField("name");

        System.out.println("Data type of field name is " +name);
        Method printmethod = Reflection_Check.class.getDeclaredMethod("displayStringValue", String.class);
        printmethod.setAccessible(true);
        printmethod.invoke(check, "This is from main");
    }
}
