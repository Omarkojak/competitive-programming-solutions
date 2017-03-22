package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva469 {
	static char[][] m;
	static boolean[][] vis;
	static int dx[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int dy[] = { 1, -1, 0, 0, 1, -1, -1, 1 };

	public static boolean valid(int r, int c) {
		return r >= 0 && r < 105 && c >= 0 && c < 105 && m[r][c] == 'W';
	}

	public static int floodfill(int r, int c) {
		vis[r][c] = true;
		int cnt = 1;
		for (int i = 0; i < 8; i++) {
			int rn = r + dx[i];
			int cn = c + dy[i];
			if (valid(rn, cn) && !vis[rn][cn]) {
				cnt += floodfill(rn, cn);
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		bf.readLine();
		while (t-- > 0) {
			String s = bf.readLine();
			StringTokenizer ns = new StringTokenizer(s);
			m = new char[105][105];
			vis = new boolean[105][105];
			int k = 0;
			while (ns.countTokens() != 2) {
				for (int i = 0; i < s.length(); i++)
					m[k][i] = s.charAt(i);
				k++;
				s = bf.readLine();
				ns = new StringTokenizer(s);
			}
			sb.append(floodfill(Integer.parseInt(ns.nextToken()) - 1,
					Integer.parseInt(ns.nextToken()) - 1)
					+ "\n");
			s = bf.readLine();
			while (s != null && !s.isEmpty()) {
				ns = new StringTokenizer(s);
				vis = new boolean[105][105];
				sb.append(floodfill(Integer.parseInt(ns.nextToken()) - 1,
						Integer.parseInt(ns.nextToken()) - 1) + "\n");
				s = bf.readLine();
			}

			if (t != 0)
				sb.append("\n");
		}
		System.out.print(sb);
	}

}
