package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D665 {
	static boolean isPrime[];

	public static void sieve(int max) {
		isPrime = new boolean[max + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i <= max; i++) {
			if (isPrime[i]) {
				if (1l * i * i <= max)
					for (int j = i * i; j < max + 1; j += i)
						isPrime[(int) j] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		sieve(((int) 1e7) + 5);
		int n = in.nextInt();
		int[] a = new int[n];
		int ones = 0;
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			if (a[i] == 1)
				ones++;
		}
		if (ones > 1) {
			int res = ones;
			int x = -1;
			for (int i = 0; i < n; i++) {
				if (a[i] != 1)
					if (isPrime[a[i] + 1]) {
						res++;
						x = a[i];
						break;
					}
			}
			System.out.println(res);
			while (ones-- > 0)
				System.out.print(1 + " ");
			if (x != -1)
				System.out.print(x);
			System.out.println();
			return;
		}
		int res = 1;
		int num1 = -1;
		int num2 = -1;
		boolean flag = true;
		for (int i = 0; i < n && flag; i++) {
			for (int j = i + 1; j < n && flag; j++)
				if (isPrime[a[i] + a[j]]) {
					num1 = a[i];
					num2 = a[j];
					res++;
					flag = false;
				}
		}
		System.out.println(res);
		if (num1 == -1 && num2 == -1)
			System.out.println(a[0]);
		else
			System.out.println(num1 + " " + num2);

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}
	}
}
