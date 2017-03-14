package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class C717 {
	static final int mod = 10007;
	
	public static void shuffle(long []a){
		int n=a.length;
		for(int i=0;i<n;i++){
			int r=i+(int)(Math.random()*(n-i));
			long temp=a[i];
			a[i]=a[r];	
			a[r]=temp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long []arr=new long[n];
		for(int i=0;i<n;i++)
			arr[i] =in.nextLong();
		shuffle(arr);
		Arrays.sort(arr);
		long ans = 0;
		
		for(int i=n-1, j=0;i>=0;i--,j++)
			ans = (ans + ((arr[j] * arr[i]) % mod))%mod;
		System.out.println(ans % mod);
		
		
	}
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
	}

}
