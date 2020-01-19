package Triconsumer;

import java.util.function.Consumer;

public class mainClass {

	private void printUsingConsumer(int a, int b, int c, Action1<Integer,Integer,Integer> consumer1) {
		consumer1.action(a,b,c);
	}
	public static void main(String[] args) {
		
		mainClass mainClass = new mainClass();
		
		System.out.println("BY Calling a diffrent function (Addition)");
		mainClass.printUsingConsumer(100,200,300, (a,b,c)->System.out.println((a+b+c)));
		
		System.out.println("Direct call (Multiply)");
		Action1<Integer,Integer,Integer> consumer2 = (a,b,c)-> System.out.println((a*b*c));
		consumer2.action(100, 200, 300);
	}

}
