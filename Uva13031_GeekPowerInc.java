import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class Uva13031_GeekPowerInc {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(bf.readLine());
		int cse = 1;
		while(t-->0)
		{
			int n = Integer.parseInt(bf.readLine());
			long [] num = new long [1001];
			for(int i=0;i<n;i++)
			{
				StringTokenizer ns = new StringTokenizer(bf.readLine());
				long k = Long.parseLong(ns.nextToken());
				int power = Integer.parseInt(ns.nextToken());
				num[power]+=k;
			}
			
			long max = 0;
			long acc = 0;
			for(int i=1000;i>=0;i--)
			{
				max = Math.max(max, (num[i] + acc) * i);
				acc+=num[i];
			}
			out.printf("Case %d: %d\n", cse++, max);
		}
		out.flush();
		out.close();
	}
	
}
