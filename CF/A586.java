package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A586 {

	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		int n=in.nextInt();
		int a[] = new int [n];
		boolean begg = false;
		int beg=0;int end=n-1;
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
			if(a[i]==1&&!begg){
				beg=i;
				begg=true;
			}
		}
		if(!begg){
			System.out.println(0);
			return;
		}
		for(int i=n-1;i>=0;i--){
			if(a[i]==1){
				end=i;
				break;
			}
		}
		boolean z=false;
		boolean mult=false;
		//System.out.println(beg+" "+end);
		ArrayList<Integer> as= new ArrayList<>();
		for(int i=beg;i<=end;i++){
			if(a[i]==1){
				if(z){
					if(!mult)
						as.add(1);
					z=false;
					mult=false;
				}
				as.add(1);
			}
			if(a[i]==0){
				if(z){
					mult=true;
				}else{
					z=true;
				}
			}
		}
		System.out.println(as.size());
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
