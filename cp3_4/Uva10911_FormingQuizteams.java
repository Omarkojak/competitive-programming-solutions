package cp3_4;
//package 3_5 also
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Uva10911_FormingQuizteams {
	static int n;
	static int dx[];
	static int dy[];
	
	static double dist(int x1,int y1,int x2,int y2){
		double diff1=Math.abs(x1-x2)*1.0;
		double diff2=Math.abs(y1-y2)*1.0;
		return Math.sqrt(diff1*diff1+diff2*diff2);
	}
	
	static double solve(int teams,int msk,int nowselect,double sofar){
		if(teams==n/2)
			return sofar;
		if(((1<<nowselect)&msk)!=0){
			return solve(teams,msk,nowselect+1,sofar);
		}
		
		double min=-1.0;
		for(int i=nowselect+1;i<n;i++){
			if(((1<<i)&msk)==0){
				double nxt=solve(teams+1,(msk|((1<<i))),nowselect+1,sofar+dist(dx[nowselect],dy[nowselect],dx[i],dy[i]));
				if(min==-1)
					min=nxt;
				else
					min=Math.min(min, nxt);
			}
		}
		return min;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner in =new Scanner(System.in);
		int cse=1;
		while(true){
			n=in.nextInt()*2;
			if(n==0)
				break;
			dx=new int [n];
			dy=new int [n];
			
			for(int i=0;i<n;i++){
				in.next();
				dx[i]=in.nextInt();
				dy[i]=in.nextInt();
			}
			double res=solve(0,0,0,0.0);
			DecimalFormat df=new DecimalFormat("#.##");
			
			System.out.printf("Case %d: %.2f\n",cse++,res);
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
