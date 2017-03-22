package CF;

import java.util.Scanner;

public class A501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		double sc1 = Math.max(3 * a / 10, a - (a / 250) * c);
		double sc2 = Math.max(3 * b / 10, b - (b / 250) * d);
		System.out.println(sc1 == sc2 ? "Tie" : sc1 > sc2 ? "Misha" : "Vasya");
	}

}
