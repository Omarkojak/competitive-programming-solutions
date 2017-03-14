import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva1729_Owllen {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int cse = 1;
		int t = in.nextInt();
		while(t-->0)
		{
			String s =in.nextLine();
			int [] cnt = new int [26];
			for(int i=0;i<s.length();i++)
				cnt[s.charAt(i)-'a'] ++;
			int min = (int) 1e7;
			for(int i=0;i<26;i++)
				min = Math.min(min, cnt[i]);
			out.printf("Case %d: %d\n", cse++, min);
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
