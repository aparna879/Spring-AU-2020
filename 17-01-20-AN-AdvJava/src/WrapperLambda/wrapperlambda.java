package WrapperLambda;

import java.util.Scanner;
import java.util.function.BiConsumer;

public class wrapperlambda {

	public static void main(String[] args) {
		int[] a = {20,30,40,50};
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter key value");
		int key = sc.nextInt();
		
		process(a,key,wrapperLambda((p,q)-> System.out.println(p/q)));

	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (v,k)->{
			try {
				consumer.accept(v,k);
			}
			catch(ArithmeticException e){
				System.out.print("Invalid key value.. exception Occured\n");
			}
		};
	}

	private static void process(int[] a, int key, BiConsumer<Integer,Integer> consumer) {
		for(int i: a) {
			consumer.accept(i, key);
		}
	}

}
