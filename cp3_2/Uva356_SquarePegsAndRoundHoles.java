package cp3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva356_SquarePegsAndRoundHoles {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = in.nextLine();
		while(s!=null && s.length()!=0)
		{
		int n = Integer.parseInt(s);
		double radsq = (n-0.5)*(n-0.5);
		int inside = 0;
		int segment = 0;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				double leftlower = i * i + j * j;
				double rightupper = (i+1) * (i+1) + (j+1) * (j+1);
				if(leftlower >= radsq)
					continue;
				if(leftlower < radsq && rightupper <= radsq)
					inside++;
				else
					segment++;
			}
		sb.append("In the case n = ").append(n);
		sb.append(", "+segment*4+" cells contain segments of the circle.\n");
		sb.append("There are "+ inside*4+" cells completely contained in the circle.\n");
		s = in.nextLine();
		if(s!=null && s.length()!=0)
			sb.append("\n");
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
