package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B146 {

	public static int mask(int x) {
		int mul = 1;
		int res = 0;
		String s = x + "";
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == '7' || c == '4') {
				res += (c - '0') * mul;
				mul *= 10;
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(ns.nextToken());
		int b = Integer.parseInt(ns.nextToken());
		int res = a + 1;
		while (mask(res) != b)
			res++;
		System.out.println(res);
	}

}
