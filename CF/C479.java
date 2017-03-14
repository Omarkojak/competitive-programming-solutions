package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class C479 {

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
		int n=in.nextInt();
		int []a=new int [n];
		TreeMap<Integer, PriorityQueue<Integer>> mp = new TreeMap<>();
		for(int i=0;i<n;i++){
			a[i] = in.nextInt();
			PriorityQueue<Integer> pq =new PriorityQueue<>();
			if(mp.containsKey(a[i]))
				pq = mp.get(a[i]);
			pq.add(in.nextInt());
			mp.put(a[i], pq);
		}
		shuffle(a);
		Arrays.sort(a);
		int maxd = -1;
		for(int i=0;i<n;i++){
			PriorityQueue<Integer> pq =mp.get(a[i]);
			int f=pq.poll(); 
			mp.put(a[i], pq);
			if(maxd==-1){
				maxd=Math.min(f, a[i]);
				continue;
			}
			if(f<maxd){
				maxd=a[i];
			}else{
				maxd=f;
			}
				
		}
		System.out.println(maxd);
			
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
