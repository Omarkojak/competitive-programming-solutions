package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva13007_DAsInDaedalus {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = in.nextLine();
		while(s!=null && s.length()!=0)
		{
			StringTokenizer ns = new StringTokenizer(s);
			int n = Integer.parseInt(ns.nextToken());
			int m = Integer.parseInt(ns.nextToken());
			int [] a = {1,10,100,1000,10000};
			int res = 0;
			while(m-->0)
			{
				int budget = in.nextInt();
				int ded = in.nextInt();
				int sum = 0;
				for(int i=1;i<n;i++)
					sum+=in.nextInt();
				
				int won = (sum + ded<= budget)? ded:0;
				int max = won;
				for(int i=0;i<a.length;i++)
					if(sum + a[i] <= budget)
						max = Math.max(max, a[i]);
				res += max - won;
			}
			sb.append(res).append("\n");
			s = in.nextLine();
		}
		System.out.print(sb);

	}
	
	static class Scanner
	{
		StringTokenizer ns;
		BufferedReader bf;
		
		Scanner(InputStream s)
		{
			bf = new BufferedReader(new InputStreamReader(s));
		}
		
		String next() throws IOException
		{
			while(ns == null || !ns.hasMoreTokens())
				ns = new StringTokenizer(bf.readLine());
			return ns.nextToken();
		}
		
		int nextInt() throws IOException, NumberFormatException
		{
			return Integer.parseInt(next());
		}
		
		long nextLong() throws IOException, NumberFormatException
		{
			return Long.parseLong(next());
		}
		
		public String nextLine() throws IOException
		{
			return bf.readLine();
		}
	}

}
