package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A711 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		boolean flag = false;
		for(int i=0;i<n;i++)
		{
			String s = in.nextLine();
			char c1 = s.charAt(0);
			char c2 = s.charAt(1);
			
			char c3 = s.charAt(3);
			char c4 = s.charAt(4);
			if(flag)
				sb.append(c1 + "" + c2 + "|" + c3 +""+c4 ).append("\n");
			else
			{
				if(c1 == c2 && c1 == 'O')
				{
					sb.append("++|" + c3 +""+c4 ).append("\n");
					flag =  true;
					continue;
				}
				if(c3 == c4 && c3 == 'O')
				{
					sb.append(c1 + "" + c2 + "|++").append("\n");
					flag =  true;
					continue;
				}
				sb.append(c1 + "" + c2 + "|" + c3 +""+c4 ).append("\n");
				
				
			}
			
		}
		if(flag)
			System.out.println("YES");
		else
		{
			System.out.println("NO");
			return;
		}
		System.out.print(sb);
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
