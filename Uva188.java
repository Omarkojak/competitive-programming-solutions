import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Uva188 {

	static int brute(int[] w)
	{
		int n = w.length;
		int cur = 1;
		while(true)
		{
			int nxt = -1;
			for(int i = 0; i < n; i++)
				for(int j = i + 1; j < n; j++)
					if((cur/w[i])%n == (cur/w[j])%n)
						nxt = Math.max(nxt, Math.min((cur/w[i] + 1)*w[i], (cur/w[j] + 1)*w[j]));
			if(nxt == -1)
				break;
			else
				cur = nxt;
		}
		return cur;
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(sc.hasNext())
		{
			String line = sc.nextLine();
			StringTokenizer st = new StringTokenizer(line);
			
			int[] w = new int[st.countTokens()];
			for(int i = 0; i < w.length; i++)
			{
				String word = st.nextToken();
				int ww = 0;
				for(int j = 0; j < word.length(); j++)
					ww = (ww << 5) + word.charAt(j) - 'a' + 1;
				w[i] = ww;
			}
			
			out.format("%s\n%d\n\n", line, brute(w));
		}
		out.flush();
	}
}

	