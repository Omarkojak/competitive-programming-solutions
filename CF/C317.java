package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C317 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		long x = Long.parseLong(ns.nextToken());
		long y = Long.parseLong(ns.nextToken());
		long m = Long.parseLong(ns.nextToken());

		if (x >= m || y >= m) {
			System.out.println(0);
			return;
		}

		if ((x <= 0 && y <= 0 && m >= 0) || (x >= 0 && y >= 0 && m <= 0)) {
			System.out.println(-1);
			return;
		}

		if (x <= 0 && y <= 0 && m > x && m > y) {
			System.out.println(-1);
			return;
		}
		if (x >= 0 && y >= 0 && m < x && m < y) {
			System.out.println(-1);
			return;
		}
		long cnt = 0;
		if (m > 0) {
			if (x < 0) {
				long modx = x * -1;
				int r = 0;
				if (modx % y != 0)
					r++;
				cnt = modx / y + r;
				if (r == 0)
					x = 0;
				else
					x = x + ((modx / y + 1) * y);
			} else {
				if (y < 0) {
					long mody = y * -1;
					int r = 0;
					if (mody % x != 0)
						r++;
					cnt = mody / x + r;
					if (r == 0)
						y = 0;
					else
						y = y + ((mody / x + 1) * x);
				}
			}
			while (x < m && y < m) {
				if (x < y)
					x += y;
				else
					y += x;
				cnt++;
			}

		} else {
			if (x > 0) {
				int r = 0;
				if (x % y != 0)
					r++;
				cnt = x / y + r;
				if (r == 0)
					x = 0;
				else
					x = x - ((x / y + 1) * y);
			} else {
				if (y > 0) {
					int r = 0;
					if (y % x != 0)
						r++;
					cnt = y / x + r;
					if (r == 0)
						y = 0;
					else
						y = y - ((y / x + 1) * x);
				}
			}
			while (x > m && y > m) {
				if (x > y)
					x += y;
				else
					y += x;
				cnt++;
			}

		}
		System.out.println(cnt);
	}

}
