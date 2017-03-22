package CF;

import java.io.IOException;
import java.util.Scanner;

public class C353 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = in.nextInt();
		String m = in.next();
		long max = 0, out = 0;
		for (int i = 0; i < n; max += a[i], i++)
			if (m.charAt(i) == '1') {
				out += a[i];
				out = Math.max(max, out);
			}
		System.out.println(out);
	}

}
