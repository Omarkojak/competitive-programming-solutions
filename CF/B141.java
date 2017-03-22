package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B141 {

	static double borders(int a) {
		return (1.0 * a) / 2.0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(ns.nextToken());
		int x = Integer.parseInt(ns.nextToken());
		int y = Integer.parseInt(ns.nextToken());
		if (y % a == 0) {
			System.out.println(-1);
			return;
		}
		if (y < a) {
			if (1.0 * x < borders(a) && 1.0 * x > -borders(a))
				System.out.println(1);
			else
				System.out.println(-1);
			return;
		}
		int cnt = 1;
		int floor = 0;
		y -= a;
		while (y > a) {
			if (floor % 2 == 0)
				cnt++;
			else
				cnt += 2;
			y -= a;
			floor ^= 1;
		}
		if (floor % 2 == 0) {
			if (1.0 * x < borders(a) && 1.0 * x > -borders(a))
				System.out.println(cnt + 1);
			else
				System.out.println(-1);
		} else {
			if (x < a && x > -a && x != 0) {
				if (x < a && x > 0)
					System.out.println(cnt + 2);
				else
					System.out.println(cnt + 1);
			} else
				System.out.println(-1);
		}

	}

}
