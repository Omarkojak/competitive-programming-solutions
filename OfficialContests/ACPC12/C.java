package OfficialContests.ACPC12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] enc = bf.readLine().toCharArray();
		char[] pass = bf.readLine().toCharArray();
		int[] cnt = new int[26]; // for the pass
		for (int i = 0; i < pass.length; i++)
			cnt[pass[i] - 'a']++;

		int diff = 0;
		for (int i = 0; i < 26; i++) {
			if (cnt[i] > 0)
				diff++;
		}

		boolean flag = false;
		boolean[] match = new boolean[26];
		int[] window = new int[26];
		int charmatch = 0;

		for (int l = 0, r = 0; l < enc.length && !flag; l++) {

			while (r < enc.length) {
				int idx = enc[r] - 'a';
				if (cnt[idx] == 0) {
					l = r;
					r++;
					charmatch = 0;
					window = new int[26];
					match = new boolean[26];
					break;
				}
				if (match[idx])
					break;

				window[idx]++;
				if (window[idx] == cnt[idx]) {
					match[idx] = true;
					charmatch++;
				}
				if (charmatch == diff)
					flag = true;

				r++;
			}

			int idx = enc[l] - 'a';
			if (match[idx]) {
				match[idx] = false;
				charmatch--;
			}
			window[idx]--;
		}

		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
