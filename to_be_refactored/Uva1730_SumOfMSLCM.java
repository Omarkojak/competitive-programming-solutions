package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva1730_SumOfMSLCM {
	static long [] sumofdivisiors;
	
	public static void sum(int max)
	{
		for(int i=1;i<=max;i++)
		{
			for(int j=i;j<=max;j+=i)
				sumofdivisiors[j] += i;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int max = 20000001;
		sumofdivisiors = new long [max+1];
		sum(max);
		sumofdivisiors[0] = 0;
		sumofdivisiors[1] = 0;
		for(int i=2;i<=max;i++)
			sumofdivisiors[i] += sumofdivisiors[i-1];		
		
		while(true)
		{
			int n = in.nextInt();
			if(n==0)
				break;
			sb.append(sumofdivisiors[n]).append("\n");
		}
		System.out.print(sb);
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
