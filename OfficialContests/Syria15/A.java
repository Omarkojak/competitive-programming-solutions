package OfficialContests.Syria15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			int N = Integer.parseInt(bf.readLine());
			long[] arr = new long[N];
			long sumpaid = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer ns = new StringTokenizer(bf.readLine());
				arr[i] = Long.parseLong(ns.nextToken());
				if (ns.nextToken().charAt(0) == '-')
					arr[i] *= -1;
				else
					arr[i] *= 1;
				if (arr[i] > 0)
					sumpaid += arr[i] + 25;
			}
			long low = sumpaid;
			long high = (long) 1e18;
			long ans = sumpaid;
			while (low <= high) {
				long mid = (low + high) >> 1;
				boolean flag = true;
				long sum = mid;
				for (int i = 0; i < N; i++) {
					if (arr[i] > 0)
						sum -= (arr[i] + 25);
					else if (sum > Math.abs(arr[i]) + 25)
						flag = false;
				}
				if (flag) {
					low = mid + 1;
					ans = mid;
				}else
					high = mid - 1;
			}
			System.out.println(ans - sumpaid);

		}

	}
}
