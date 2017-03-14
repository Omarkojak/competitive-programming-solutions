package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main3 {
	static final long inf=(int)(1e18);

	static long min(long a,long b,long c, long d){
		long m1=Math.min(a,b);
		long m2=Math.min(c,d);
		return Math.min(m1, m2);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		long c1=in.nextLong();
		long c2=in.nextLong();
		long c3=in.nextLong();
		long c4=in.nextLong();
		
		int n=in.nextInt();int m=in.nextInt();
		int []a=new int [n];
		int []b=new int [m];
		int rides1=0,rides2=0;
		for(int i=0;i<n;i++){
			a[i]=in.nextInt();
			rides1+=a[i];
		}
		for(int i=0;i<m;i++){
			b[i]=in.nextInt();
			rides2+=b[i];
		}
		int s=n+m;
		long res=min(c4,c3*2,c2*s,(rides1+rides2)*c1);
		//System.out.println(res);
		long comb1=c3+c2*m;
		long comb2=c3+c2*n;
		
		long comb3=c3+c1*rides1;
		long comb4=c3+c1*rides2;
		//System.out.println(comb1+ " "+comb2+" "+comb3+" "+comb4);
		long min1=min(comb1,comb2,comb3,comb4);
		long ans1=0;
		for(int i=0;i<n;i++){
			int r=0;
			if(c2%a[i]!=0)
				r++;
			long mm=c2/a[i]+r;
			ans1+=Math.min(a[i]*c1,mm);
		}
		for(int i=0;i<m;i++){
			int r=0;
			if(c2%b[i]!=0)
				r++;
			long mm=c2/b[i]+r;
			ans1+=Math.min(b[i]*c1, mm);
			
		}
		//System.out.println(ans1);
		res=min(min1,ans1,res,inf);
		System.out.println(res);
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
