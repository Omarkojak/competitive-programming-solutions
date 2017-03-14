package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B776 {

	static boolean isPrime[];
	static ArrayList<Long> primes;

	public static void sieve(long max) {
		isPrime[0] = isPrime[1] = false;
		
		for (long i = 2; i <= max; i++) {
			if (isPrime[(int) i]) {

				for (long j = i * i; j < max + 1; j += i) {
					isPrime[(int) j] = false;
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		isPrime = new boolean[n + 6];
		Arrays.fill(isPrime, true);
		sieve(n + 5);
		int cnt = 1;
		for(int i=2;i<=n+1;i++)
			if(isPrime[i]){
				sb.append("1 ");
			}else{
				sb.append("2 ");
				cnt = 2;
			}
	
		System.out.println(cnt);
		System.out.println(sb);
		
		

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
