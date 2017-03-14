import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1
5
3 3 2 3 3
2 0 3 1 1
 */
public class Uva434_MattysBlocks {

	public static void main(String[] args) throws IOException {
		Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		while(t-->0){
			int n=in.nextInt();
			int []front=new int [n];
			int []side=new int [n];
			
			for(int i=0;i<n;i++)
				front[i]=in.nextInt();
			
			for(int i=0;i<n;i++)
				side[i]=in.nextInt();
			
			int []cf=new int [9];
			int []cs=new int [9];
			for(int i=0;i<n;i++){
				cf[front[i]]++;
				cs[side[i]]++;
			}
			//System.out.println(Arrays.toString(cs));
			//System.out.println(Arrays.toString(cf));

			int r=0;
			for(int i=1;i<9;i++){
				if(cf[i]==0&&cs[i]==0)
					continue;
				if(cf[i]!=0&&cs[i]!=0)
					r+=i*Math.max(cs[i], cf[i]);
				else		
					r+=i*Math.max(cf[i], cs[i]);
			}
			int total=0;
			for(int i=0;i<n;i++){
				if(front[i]==0)
					continue;
				for(int j=0;j<n;j++){
					if(side[j]==0)
						continue;
					total+=Math.min(side[j], front[i]);
			}
			}
			System.out.printf("Matty needs at least %d blocks, and can add at most %d extra blocks.\n",r,total-r);
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
