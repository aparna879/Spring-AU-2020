package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD,ElementType.TYPE}) 
public @interface MyAnnotation {
	String trainer() default "kumar";
	String date();
}

@MyAnnotation(trainer="dishu",date="15-01-2020")
class Test{  
@MyAnnotation(trainer="rahul",date="13-01-2020")  
public void fun1(){System.out.println("Function 1");}  

@MyAnnotation(date="17-01-2020")
public void fun2(){System.out.println("Function 2");}  
}


