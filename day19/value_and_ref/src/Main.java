import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		int i = 5;
		System.out.printf("before i = %d\n", i);
		changeIt(i);
		System.out.printf("after i = %d\n", i);

		List<Integer> l = new LinkedList<>();
		l.add(5);
		System.out.printf("LIST before i = %d\n", l.get(0));
		changeIt(l);
		System.out.printf("LIST after i = %d\n", l.get(0));
	}

	public static void changeIt(List<Integer> list) {
		list.set(0, list.get(0) + 10);
		System.out.printf("LIST during value = %d\n", list.get(0));
	}

	public static void changeIt(int value) {
		value += 10;
		System.out.printf("during value = %d\n", value);
	}
}
