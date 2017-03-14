package CF;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D702 {
	static int k,a,b,t;
	static long d;
	
	public static long f(long i)
	{
		return i*k*a + t*(i-1) + ((d-i*k > 0)?(d-i*k)*b:0);
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		 d = in.nextLong();
		 k = in.nextInt();	//dist for car to break
		 a = in.nextInt();	//t for 1km car
		 b = in.nextInt();	//t for 1km walk
		 t = in.nextInt();	// t for repair the car
		if(d<=k)
		{
			System.out.println(d*a);
			return;
		}
		long low = 1;
		long high = d/k;
		long ans = high;
		while(low <= high) {
		    long mid = (low + high) >> 1;
		    if(f(mid) < f(mid+1)) {
		        high = mid-1;
		        ans = mid;
		    }
		    else {
		        low = mid+1;
		    }
		}
	//	System.out.println(ans);
		System.out.println(f(ans));
		//System.out.println(f(1));
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
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}


	}
}