package cp2_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Uva11235_FrequentValues {

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		StringBuilder sb =new StringBuilder();
		int n=in.nextInt();
		while(n!=0)
		{
			int q=in.nextInt();
			int []a =new int [n];
			TreeMap<Integer, Integer> mp =new TreeMap<>();
			int [][] Interval = new int [n][2];		//0: beg 1:end 
			int lastidx =0;int lastelement = a[0];
			for(int i=0;i<n;i++)
			{
				a[i] = in.nextInt();
				int v=0;
				if(mp.containsKey(a[i]))
					v = mp.get(a[i]);
				mp.put(a[i], v+1);
				
				if(a[i] != lastelement)
				{
					Interval[lastidx][0] = lastidx;
					Interval[lastidx][1] = i-1;
					lastidx = i;
					lastelement = a[i];
				}
			}
			Interval[lastidx][0] = lastidx;
			Interval[lastidx][1] = n-1;
			for(int i=1;i<n;i++)
			{
				if(a[i] == a[i-1])
				{
					Interval[i][0] = Interval[i-1][0];
					Interval[i][1] = Interval[i-1][1];
				}
			}	
			//System.out.println(mp.toString());
			
			/*for(int i=0;i<n;i++)
				System.out.println(Interval[i][0]+" "+Interval[i][1]);*/
			
			for(int i=0;i<n;i++)
				a[i] = mp.get(a[i]);
			
			SparseTable st =new SparseTable(a);
			while(q-->0)
			{
				int idx1=in.nextInt()-1;
				int idx2=in.nextInt()-1;
				if(Interval[idx1][0] == Interval[idx2][0])	// in the same interval
				{
					sb.append(idx2-idx1+1).append("\n");
					continue;
				}
				
				int idx = st.query(Interval[idx1][1]+1, Interval[idx2][0]-1);	
				int val = 0;
				if(idx!=-1)
					val=a[idx];
				
				int maxinbetween = val;	//max of the interval in between idx 1 and idx 2 
				int max = Math.max(Interval[idx1][1] - idx1 +1, idx2 - Interval[idx2][0] +1);	// max of the intervals on the left and right side
				//System.out.println(maxinbetween+" "+max);
				sb.append(Math.max(max, maxinbetween)).append("\n");
			}
			n=in.nextInt();
		}
		System.out.print(sb);
		
	}
	
	static class SparseTable {
		int A[], SpT[][];
		
		SparseTable(int[] A) 
		{
			int n = A.length;	this.A = A;
			int k = (int)Math.floor(Math.log(n) / Math.log(2)) + 1;
			SpT = new int[n][k];
			
			for (int i = 0; i < n; i++) 
				SpT[i][0] = i; 					
		
			for (int j = 1; (1<<j) <= n; j++) 				
				for (int i = 0; i + (1<<j) - 1 < n; i++)   
					if (A[SpT[i][j-1]] > A[SpT[i+(1<<(j-1))][j-1]])
						SpT[i][j] = SpT[i][j-1];    		
					else                  					
						SpT[i][j] = SpT[i+(1<<(j-1))][j-1];
		 }

		  int query(int i, int j) 
		  {
			 if(i>j)
				 return -1;
		    int k = (int)Math.floor(Math.log(j-i+1) / Math.log(2)); 
		    
		    if (A[SpT[i][k]] >= A[SpT[j-(1<<k)+1][k]]) 
		    	return SpT[i][k];
		    else
		    	return SpT[j-(1<<k)+1][k];
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
