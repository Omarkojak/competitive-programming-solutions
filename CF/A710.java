package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A710 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int col = s.charAt(0) - 'a' + 1;
		int row = s.charAt(1) - '0';
		if(col > 1 && col < 8 && row > 1 && row < 8 )
		{
			System.out.println(8);
			return;
		}
		if((row == 8 && col == 8) || (row == 8 && col == 1) || (row == 1 && col == 1) || (row == 1 && col == 8))
		{
			System.out.println(3);
			return;

		}
		System.out.println(5);
	

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
