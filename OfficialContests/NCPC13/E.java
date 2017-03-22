package OfficialContests.NCPC13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = bf.readLine().toCharArray();
		char[] s2 = bf.readLine().toCharArray();
		int i = 0, w = 0;
		for (; i < s2.length && w < s1.length; i++, w++) {
			if (s1[w] != s2[i]) {
				break;
			}
		}

		int j = s2.length - 1, k = s1.length - 1;
		for (; j >= 0 && k >= 0; j--, k--) {
			if (s2[j] != s1[k]) {
				break;
			}
		}
		if (j > i && k > w) {
			System.out.println(j - i + 1);
		} else {
			if (s1.length >= s2.length)
				System.out.println(0);
			else
				System.out.println(s2.length - s1.length);
		}

	}

}