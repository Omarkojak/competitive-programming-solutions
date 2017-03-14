package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Maximum_Subarray {
	
	public static void shuffle(int []a){
		int n=a.length;
		for(int i=0;i<n;i++){
			int r=i+(int)(Math.random()*(n-i));
			int temp=a[i];
			a[i]=a[r];
			a[r]=temp;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0){
			int n=in.nextInt();
			int a[]=new int [n];
			int sump=0;
			for(int i=0;i<n;i++){
				a[i]=in.nextInt();
				if(a[i]>0)
					sump+=a[i];
			}
			int sum=0;
			int ans=0;
			for (int i = 0; i < n; i++) {
				sum += a[i];
				ans = Math.max(ans, sum); 
				if (sum < 0)
					sum = 0;
			}
			
			shuffle(a);
			Arrays.sort(a);
			if(ans!=0)
				System.out.print(ans);
			else
				System.out.print(a[n-1]);
			
			if(sump!=0)
				System.out.println(" "+sump);
			else
				System.out.println(" "+a[n-1]);
			
		}

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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}

}
