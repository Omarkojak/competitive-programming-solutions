package OfficialContests.Amman16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			char[] s = bf.readLine().toCharArray();
			boolean[] in = new boolean[26];
			for (int i = 0; i < s.length; i++)
				in[s[i] - 'a'] = true;
			boolean f = false;
			char first = ' ', second = ' ';
			for (int i = 0; i < s.length; i++) {
				in[s[i] - 'a'] = false;
				if (!f) {
					char j = 'a';
					while (j < s[i] && !in[j - 'a'])
						j++;
					if (j < s[i]) {
						f = true;
						first = j;
						second = s[i];
					}
				}
			}

			for (char c : s) {
				if (c == first)
					sb.append(second);
				else {
					if(c == second)
						sb.append(first);
					else
						sb.append(c);
				}
			}

			sb.append("\n");
		}
		System.out.print(sb);
	}

}
