package annotation;

import java.lang.reflect.Method;

public class AnnotationMethod {
	  
	public static void main(String args[])throws Exception{  
	  
	System.out.println("METHOD ANNOTATION");
	Test t=new Test();  
	Method m=t.getClass().getMethod("fun1");  	  
	MyAnnotation manno1=m.getAnnotation(MyAnnotation.class);  
	System.out.println("Trainer name:"+manno1.trainer()+"\n"+ "Session date is:"+manno1.date()+"\n");  
	
	Method m2=t.getClass().getMethod("fun2");  
	MyAnnotation manno2=m2.getAnnotation(MyAnnotation.class);  
	System.out.println("Trainer name:"+manno2.trainer()+"\n"+ "Session date is:"+manno2.date()+"\n");  
	
	System.out.println("CLASS ANNOTATION");
	Class<Test> c = Test.class;
	MyAnnotation manno3=c.getAnnotation(MyAnnotation.class);  
	System.out.println("Trainer name:"+manno3.trainer()+"\n"+ "Session date is:"+manno3.date()+"\n");  
	
	}
	
}
