package OfficialContests.Amman16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(ns.nextToken());
			int k = Integer.parseInt(ns.nextToken()) + 1;
			boolean f = false;
			char[] s = bf.readLine().toCharArray();
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (s[i] == '0')
					cnt++;
				else
					cnt = 0;
				if (cnt >= k)
					f = true;
			}
			sb.append(f ? "yes\n" : "no\n");
		}
		System.out.print(sb);
	}

}
