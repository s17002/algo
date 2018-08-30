// int型集合クラスIntSetの利用例

public class IntSetTester {

	public static void main(String[] args) {
		En7_1 s1 = new En7_1(20);

		s1.add(10);			// s1 = {10}
		s1.add(15);			// s1 = {10, 15}
		s1.add(20);			// s1 = {10, 15, 20}
		s1.add(25);			// s1 = {10, 15, 20, 25}

		System.out.println("集合体s1の要素は" + s1);

		System.out.println("集合s1は" +
			(s1.isEmpty() ? "空である" : "空ではない"));
		System.out.println("集合s1は" +
		    (s1.isFull() ? "満杯です" : "まだ入ります"));

		s1.clear();
		System.out.println("集合体s1の要素" + s1);

		System.out.println("集合s1は" +
		    (s1.isEmpty() ? "空である" : "空ではない"));
	}
}
