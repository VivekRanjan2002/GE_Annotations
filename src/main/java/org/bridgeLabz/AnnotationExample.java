package org.bridgeLabz;
import jdk.dynalink.linker.MethodHandleTransformer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfo(author="Narayan", comments = "Main method", date="Nov 17 2012", revision=1)
    public String toString(){
        return "Overridden toString method";
    }
    @Deprecated
    @MethodInfo(comments = "deprecated method", date="Nov 17 2012")
    public static void oldMethod() {
        System.out.println("Old Method , don't use it ");
    }
    public static void main(String[] args) throws  Exception {
    for(Method method: AnnotationExample.class.getMethods()){
        // checks if MethodInfo annotation is present for the method
        if(method.isAnnotationPresent(MethodInfo.class)){
            //iterates all the annotations available in the method
            for(Annotation anno : method.getDeclaredAnnotations()){
                System.out.println("Annotation in method "+method+ " : "+ anno);
            }
            MethodInfo methodAnno= method.getAnnotation(MethodInfo.class);
            if(methodAnno.revision()==1){
                System.out.println("Method with revision no 1 = "+ method);
            }
        }
    }
    }
}