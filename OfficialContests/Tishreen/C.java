package OfficialContests.Tishreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(bf.readLine());
		int cse = 1;
		while (t-- > 0) {
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(ns.nextToken());
			int m = Integer.parseInt(ns.nextToken());
			int cnt = 0;
			int max = -1;
			for (int i = 0; i < n; i++) {
				String line = bf.readLine();
				int stars = 0;
				for (int j = 0; j < m; j++)
					if (line.charAt(j) == '*')
						stars++;

				if (max == -1 && stars > 0)
					max = stars;

				if (stars == max && max != -1)
					cnt++;
			}
			if (cnt == 2)
				out.printf("Case %d: Zero\n", cse++);
			else
				out.printf("Case %d: Eight\n", cse++);

		}
		out.flush();
		out.close();
	}

}
