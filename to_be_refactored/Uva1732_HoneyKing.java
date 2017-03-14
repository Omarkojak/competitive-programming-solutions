package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva1732_HoneyKing {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		int cse = 1;
		while(t-->0)
		{
			int n = in.nextInt();
			int nn = n;
			int maxx = 0,minx= (int) 1e6;
			int maxy = 0,miny = (int) 1e6;
			while(n-->0)
			{
				int x = in.nextInt();
				int y = in.nextInt();
				maxx = Math.max(maxx, x);
				maxy = Math.max(maxy, y);
				minx = Math.min(minx, x);
				miny = Math.min(miny,y);
			}
			int diameter = 0;
			diameter = Math.max(maxx-minx, maxy - miny);
			
			out.printf("Case %d: %d\n", cse++, diameter * (diameter - 1) * 3 +1);
			
		}
		out.flush();
		out.close();
	}
	static class Scanner
	{
		StringTokenizer st;
		BufferedReader bf;
		
		Scanner(InputStream s)
		{
			bf = new BufferedReader(new InputStreamReader(s));
		}
		
		public String next() throws IOException
		{
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(bf.readLine());
			return st.nextToken();
		}
		
		public int nextInt() throws NumberFormatException, IOException
		{
			return Integer.parseInt(next());
		}
		
		public String nextLine() throws IOException
		{
			return bf.readLine();
		}
	}
	
}
