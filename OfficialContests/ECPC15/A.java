package OfficialContests.ECPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
	static double fac[];

	public static boolean nextPermutation(int[] a) {
		int n = a.length;
		int i = n - 1;
		while (i > 0 && a[i - 1] >= a[i])
			i--;
		if (i <= 0)
			return false;

		int j = n - 1;
		while (a[j] <= a[i - 1])
			j--;

		int temp = a[j];
		a[j] = a[i - 1];
		a[i - 1] = temp;
		j = n - 1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return true;
	}

	static void fac() {
		fac = new double[11];
		fac[0] = 1.0;
		for (int i = 1; i < 11; i++)
			fac[i] = fac[i - 1] * i;
	}

	static double calc(int rank, int size) {
		if(rank == 0)
			return 0.0;
		
		double res = 1.0;
		for(int i=0;i<rank - 1;i++)
			res *= ((fac[size] + 1) / fac[size]);
		return res/fac[size];
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		fac();
		int t = in.nextInt();
		while (t-- > 0) {
			int N = in.nextInt();
			String num = N + "";
			int size = num.length();
			int arr[] = new int[size];
			for (int i = 0; i < size; i++)
				arr[i] = num.charAt(i) - '0';
			Arrays.sort(arr);
			int j = (int)fac[size] - 1;
			do {
				int number = 0;
				for (int i = size - 1, mul = 1; i >= 0; i--, mul *= 10)
					number += arr[i] * mul;
				if (number == N)
					break;
				j--;

			} while (nextPermutation(arr));
			out.printf("%.9f\n",calc(j, size));
		}
		out.flush();
		out.close();
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