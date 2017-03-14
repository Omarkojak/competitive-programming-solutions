import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Uva11610_ReversePrime {
	static boolean isPrime [];
	static ArrayList<Integer> primes;
	static ArrayList<Integer> reverseprimes;
	static int numdiffpf[];
	static TreeMap<Integer, Integer> fromprimetoidx;
	static TreeMap<Integer, Integer> fromidxtoprime;
	static int revprimepfsum[];
	

	public static void diffpf()
	{
		int maxn = (int) 1e8;
		numdiffpf = new int [maxn];
		revprimepfsum = new int [reverseprimes.size()];
		for(int i=2; i<maxn ;i++)
		{
			if(numdiffpf[i] ==0)
				for(int j=i;j<maxn;j+=i)
					numdiffpf[j]++;
		}
		for(int i=0;i<reverseprimes.size();i++)
		{
			int idx1 = fromprimetoidx.get(reverseprimes.get(i));
			revprimepfsum[idx1] = numdiffpf[reverseprimes.get(i)] + ((idx1 ==0)? 0:revprimepfsum[idx1-1]);
		}
	}
			

	public static void sieve(int max){
		isPrime = new boolean [max];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		primes = new ArrayList<>();
		
		for(int i = 2;i < max;i++){
			if(isPrime[i]){
	    		if(1l * i * i < max)
	    			for(int j = i * i;j < max ;j += i)
	    			{
	    				isPrime[(int)j] = false;
	    			}
					primes.add(i);
			}
		}
		
		fromidxtoprime = new TreeMap<>();
		fromprimetoidx = new TreeMap<>();
		reverseprimes = new ArrayList<>();
		int idx=0;
		for(int i=0;i<primes.size();i++)
		{
			int x = rev(primes.get(i));
			reverseprimes.add(x);
			fromprimetoidx.put(x, idx);
			fromidxtoprime.put(idx, x);
			idx++;
		}
	}
	
	public static int rev(int x)
	{
		String s = x+ "";
		
		StringBuilder res = new StringBuilder();
		
		for(int i=s.length()-1;i>=0;i--)
			res.append(s.charAt(i));
			
		while(res.length() <7)
			res.append(0);
		return Integer.parseInt(res.toString());
	}

	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sieve(((int)1e6));
		Collections.sort(reverseprimes);
		diffpf();
		FenwickTree ft = new FenwickTree((int) 1e8);
		String s = in.nextLine();
		System.out.println(Arrays.toString(revprimepfsum));
		while(s!=null && s.length()!=0)
		{
			StringTokenizer ns = new StringTokenizer(s);
			if(ns.nextToken().charAt(0) == 'q')
			{
				int idx = Integer.parseInt(ns.nextToken());
				int prime = fromidxtoprime.get(idx);
				sb.append(revprimepfsum[idx] - ft.rsq(prime)).append("\n");
				
			}else
			{
				int prime = Integer.parseInt(ns.nextToken());
				ft.point_update(prime, revprimepfsum[fromprimetoidx.get(prime)]);
			}
			s = in.nextLine();
		}
			System.out.println(sb);
		}
	
	static class FenwickTree {
		int n;
		int[] ft;
		
		FenwickTree(int size) { n = size; ft = new int[n+1]; }
		
		int rsq(int b) //O(log n)
		{
			int sum = 0;
			while(b > 0) { sum += ft[b]; b -= b & -b;}		//min?
			return sum;
		}
		
		int rsq(int a, int b) { return rsq(b) - rsq(a-1); }	
		
		void point_update(int k, int val)	//O(log n), update = increment
		{
			while(k <= n) { ft[k] += val; k += k & -k; }		//min?
		}

		int point_query(int idx)	// c * O(log n), c < 1
		{
			int sum = ft[idx];
			if(idx > 0)
			{
				int z = idx ^ (idx & -idx);
				--idx;
				while(idx != z)
				{
					sum -= ft[idx];
					idx ^= idx & -idx;
				}
			}
			return sum;
		}
		
		void scale(int c) {	for(int i = 1; i <= n; ++i)	ft[i] *= c;	}
		
		int findIndex(int cumFreq)
		{
			int msk = n;
			while((msk & (msk - 1)) != 0)
					msk ^= msk & -msk;			//msk will contain the MSB of n
			
			int idx = 0;
			while(msk != 0)
			{
				int tIdx = idx + msk;
				if(tIdx <= n && cumFreq >= ft[tIdx])
				{
					idx = tIdx;
					cumFreq -= ft[tIdx];
				}
				msk >>= 1;
			}
			if(cumFreq != 0)
				return -1;
			return idx;
		}
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
