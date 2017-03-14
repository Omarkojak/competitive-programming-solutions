package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class A558 {

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		TreeMap<Integer, Integer> mp =new TreeMap<>();
		PriorityQueue<Integer> px1 =new PriorityQueue<>();
		PriorityQueue<Integer> nx1 =new PriorityQueue<>();

		PriorityQueue<Integer> px2 =new PriorityQueue<>();
		PriorityQueue<Integer> nx2 =new PriorityQueue<>();
		
		for(int i=0;i<n;i++){
			int x =in.nextInt();
			int y=in.nextInt();
			if(x<0){
				nx1.add(-1*x);
				nx2.add(-1*x);
				mp.put(x, y);
			}
			if(x>0){
				px1.add(x);
				px2.add(x);
				mp.put(x, y);
			}
		}
		
		int res1=0;	//start with positive x
		boolean f=false;
		while(true){
			if(!f){
				if(px1.isEmpty())
					break;
				int now=px1.poll();
				res1+=mp.get(now);
			}else{
				if(nx1.isEmpty())
					break;
				int now=nx1.poll();
				res1+=mp.get(-1*now);
			}
			f=!f;
		}
		
		int res2=0;	//start with negative x
		boolean f2=false;
		while(true){
			if(f2){
				if(px2.isEmpty())
					break;
				int now=px2.poll();
				res2+=mp.get(now);
			}else{
				if(nx2.isEmpty())
					break;
				int now=nx2.poll();
				res2+=mp.get(-1*now);
			}
			f2=!f2;
		}
		System.out.println(Math.max(res1, res2));
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
