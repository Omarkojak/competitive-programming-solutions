import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva13012_IdentifyingTea {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = bf.readLine();
		while(s!=null && s.length()!=0)
		{
			int n = Integer.parseInt(s);
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int cnt = 0;
			while(ns.hasMoreTokens())
			{
				if(Integer.parseInt(ns.nextToken()) == n)
					cnt++;
			}
			sb.append(cnt).append("\n");
			s = bf.readLine();
		}
		System.out.print(sb);
	}

}
