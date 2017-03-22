package OfficialContests.Tishreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class F {

	public static int check(String s1, String s2, String s3) {
		int l = Math.min(Math.min(s1.length(), s2.length()), s3.length());
		int ans = 0;
		for (int i = 0; i < l; i++) {
			if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i))
				ans++;
			else
				break;
		}
		return ans;
	}

	public static boolean match(String s1, String s2, int suff) {
		if (s2.length() < suff)
			return false;
		for (int i = 0; i < suff; i++)
			if (s1.charAt(i) != s2.charAt(i))
				return false;
		return true;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(bf.readLine());
		int cse = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(bf.readLine());
			Queue<StringBuilder> q = new LinkedList<>();
			String[] arr = new String[n];
			for (int i = 0; i < n; i++)
				arr[i] = new StringBuilder(bf.readLine()).reverse().toString();
			Arrays.sort(arr);
			int longest = 0;
			int idx = 0;
			for (int i = 0; i < n - 2; i++) {
				int suff = check(arr[i], arr[i + 1], arr[i + 2]);
				if (suff > longest) {
					longest = suff;
					idx = i;
				}
			}
			out.printf("Case %d:\n", cse++);
			out.print(longest + " ");
			int ans = 3;
			for (int i = idx + 3; i < n; i++) {
				if (match(arr[idx], arr[i], longest))
					ans++;
			}
			out.println(ans);

		}
		out.flush();
		out.close();
	}

}
