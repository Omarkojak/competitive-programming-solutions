package OfficialContests.NCPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char[] s = bf.readLine().toCharArray();
		int res = 0;
		for (int i = 0; i < s.length; i++) {
			if (i % 3 == 0 && s[i] != 'P')
				res++;
			if (i % 3 == 1 && s[i] != 'E')
				res++;
			if (i % 3 == 2 && s[i] != 'R')
				res++;

		}
		System.out.println(res);
	}

}
