package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva13029_Emoticons {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		int n = in.nextInt();
		while(n-->0)
		{
			
			String s = in.nextLine();
			int	sign = 0;	// for^
			int used = 0;	// for _
            int notused = 0;//for _
            int ans = 0;
			
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i) == '_')
				{
					if(sign>0)
					{
						sign--;
						used++;
					}
					else
					{
						notused = Math.min(notused+1, ans);
					}
				}
				else
				{
					if(used > 0)
					{
						used--;
						ans++;
					}
					else
					{
						if(notused>0)
						{
							used++;
							notused--;
						}
						else
							sign++;
					}
				}	
			}
			out.printf("Case %d: %d\n", cse++, ans);
			
		}
		out.flush();
		out.close();
	}
	
	static class Scanner
	{
		BufferedReader bf;
		StringTokenizer ns;
		
		Scanner(InputStream s)
		{
			bf = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() throws IOException
		{
			while(ns ==null || !ns.hasMoreTokens())
				ns= new StringTokenizer(bf.readLine());
			return ns.nextToken();
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
