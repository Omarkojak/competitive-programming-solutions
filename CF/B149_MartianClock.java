package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B149_MartianClock {
	static final long inf = (long)1e7;
	
	public static long conv(int base, String s)
	{
		int mul = 1;
		long ans = 0;
		for(int i=s.length()-1;i>=0;i--,mul*=base)
		{
			char c =s.charAt(i);
			int num = (c-'A') +10;
			if(c-'0' <=9 && c-'0' >=0)
				num = c -'0';
			if(num>=base)
				return inf;
			ans += mul * num;
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringTokenizer ns = new StringTokenizer(in.nextLine(), ":");
		String hours = ns.nextToken();
		String mins = ns.nextToken();
		int base = 1;
		ArrayList<Integer> as = new ArrayList<>();
		while(base<=60)
		{
			long h = conv(base,hours);
			long m = conv(base,mins);
			if(h>=0 && h<=23 && m>=0 && m<=59)
			{
				as.add(base);
			}
			base++;
		}
		boolean flag = false;
		long h = conv(100,hours);
		long m = conv(100,mins);
		if(h>=0 && h<=23 && m>=0 && m<=59)
		{
			flag = true;
		}
		if(as.size() == 0)
			System.out.println(0);
		else
		{
		if(flag)
			System.out.println(-1);
		else
			for(int i:as)
				System.out.print(i+" ");
		
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
	}
}
