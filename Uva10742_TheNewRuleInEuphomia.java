import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva10742_TheNewRuleInEuphomia {
	static boolean isPrime [];
	static ArrayList<Integer> primes;

	public static void sieve (int max){
		isPrime = new boolean [max + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		primes = new ArrayList<>();
		for(int i = 2;i <= max;i++){
			if(isPrime[i]){
	    		if(1l * i * i <= max)
	    			for(int j = i * i;j < max + 1 ;j += i)
	    			{
	    				isPrime[(int)j] = false;
	    			}
					primes.add(i);
			}
		}
	}
	
	public static int binarysearch(ArrayList<Integer> as, int ans)
	{
		int low = 0;int high = as.size()-1;
		int res = as.size();
		while(low<=high)
		{
			int mid = low + (high - low)/2;
			if(as.get(mid) >= ans)
			{
				res = mid;
				high = mid-1;
			}
			else
				low = mid+1;
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		sieve((int) 1e6 +2);
		int n = in.nextInt();
		int cse = 1;
		while(n!=0)
		{
			long cnt = 0;
			for(int i=0;i<primes.size();i++)
			{
				if(primes.get(i) > n/2)
					break;
				int pos = binarysearch(primes, n-primes.get(i));
				//System.out.println(pos);
				if(pos == primes.size())
					pos--;
				int diff = (primes.get(i) + primes.get(pos) <= n)? 0 : 1; 
				if(pos != i)
					cnt += pos - i - diff;
			}
			
			out.printf("Case %d: %d\n", cse++, cnt);
			n = in.nextInt();
		}
		out.flush();
		out.close();
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
