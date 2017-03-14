package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B152_Steps {
	static int n,m;
	static final long inf = (long) 1e18;
	
	static boolean valid(int x, int y)
	{
		return x>=1 && x<=n && y>=1 && y<=m;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		int k = in.nextInt();
		long ans = 0;
		while(k-->0)
		{
			int dx = in.nextInt();
			int dy = in.nextInt();
			
			long movx = inf;
			if(dx>0)
				movx = (n-x)/dx;
			if(dx<0)
				movx = (1-x)/dx;
			
			long movy = inf;
			if(dy>0)
				movy = (m-y)/dy;
			if(dy<0)
				movy = (1-y)/dy;
			
			long min = Math.min(movx, movy);
			ans+=min;
			x+=dx*min;
			y+=min*dy;
		}
		System.out.println(ans);
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
