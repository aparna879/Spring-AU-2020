package Triconsumer;

@FunctionalInterface
public interface Action1<T,U, R> {
	public void action(T a, U b, R c);
}
