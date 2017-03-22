package OfficialContests.Amman16;

import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = in.nextInt();
		while (t-- > 0) {
			int num = in.nextInt();
			int res = num / 5 + ((num % 5 == 0) ? 0 : 1);
			sb.append(res).append("\n");
		}
		System.out.print(sb);
	}

}
