package cp3_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/*
1
6 12 3 10 7 16 5
2
5 7 3 11 9 10
9 1 2 3 4 10 16 10 4 16
0
*/
public class Uva812_TradeOnVerweggistan {
	static int n;
	static int pile[][];
	static int prev[][];
	static int [][]workyards;
	static int []mx;
	static int []p;
	static int [][]num;
	static final int min=-100000000;
	static final int max=10001;
	
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int cse=1;
		while(true){
			n=in.nextInt();
			if(n==0)
				break;
			else
				if(cse!=1)
					System.out.println();
			mx=new int [50];
			p=new int [50];
			pile=new int [50][21];
			prev=new int [50][21];
			num=new int [50][max];
			for(int i=0;i<n;i++) {
	            p[i]=in.nextInt();
	            mx[i] = min;
	            for(int j=0;j<p[i];j++) {
	            	pile[i][j]=in.nextInt();
	                if(j>0)
	                	prev[i][j] = prev[i][j-1] + 10 - pile[i][j];
	                else
	                	prev[i][j] = 10 - pile[i][j];

	                mx[i]=Math.max(mx[i], prev[i][j]);
	            }
	        }
			num[0][0]=1;
			int ans=0;
			for(int i=0;i<n;i++){
				 if(mx[i] >= 0) {
		                ans += mx[i];
		                for(int j=0;j<p[i];j++)
		                    if(mx[i] == prev[i][j])
		                        for(int k=0;k<max;k++)
		                            if(num[i][k]>0)
		                                num[i+1][k+j+1]=1;

		                if(mx[i]==0)
		                    for(int k=0;k<max;k++)
		                        if(num[i][k]>0)
		                            num[i+1][k] = 1;
		            } else
		                for(int k=0;k<max;k++)
		                    num[i+1][k] = num[i][k];
				}
				
			 	System.out.printf("Workyards %d\n", cse++);
		        System.out.printf("Maximum profit is %d.\n", ans);
		        System.out.print("Number of pruls to buy:");
		        int ic = 0;
		        if(ans == 0)    
		        	System.out.print(" 0");
		        for(int i=1;i<max && ic < 10;i++)
		            if(num[n][i]>0) {
		            	System.out.printf(" %d", i);
		                ic++;
		            }
		        System.out.println();
			
			
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
