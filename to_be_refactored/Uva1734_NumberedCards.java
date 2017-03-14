package to_be_refactored;
import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva1734_NumberedCards {
	static boolean digits[];
	
	public static int solve(int msk)
	{
		
		
		return 0;
	}

	public static void main(String[] args) {
		

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
