package cp4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva11831 {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int n, m;
	static char[][] mz;

	public static boolean valid(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m && mz[r][c] != '#';
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = bf.readLine();
		while (!s.equals("0 0 0")) {
			StringTokenizer ns = new StringTokenizer(s);
			n = Integer.parseInt(ns.nextToken());
			m = Integer.parseInt(ns.nextToken());
			int inst = Integer.parseInt(ns.nextToken());
			mz = new char[n][m];
			int idxi = -1;
			int idxj = -1;
			for (int i = 0; i < n; ++i) {
				s = bf.readLine();
				for (int j = 0; j < m; ++j) {
					mz[i][j] = s.charAt(j);
					if (mz[i][j] != '.' && mz[i][j] != '*' && mz[i][j] != '#') {
						idxi = i;
						idxj = j;
					}
				}
			}
			String in = bf.readLine();
			int cnt = 0;
			int lastdr = 0;
			if (mz[idxi][idxj] == 'S')
				lastdr = 1;
			if (mz[idxi][idxj] == 'O')
				lastdr = 2;
			if (mz[idxi][idxj] == 'N')
				lastdr = 3;
			for (int i = 0; i < inst; ++i) {
				if (in.charAt(i) == 'D')
					lastdr = (lastdr + 1) % 4;
				else if (in.charAt(i) == 'E') {
					--lastdr;
					if (lastdr == -1)
						lastdr = 3;
				} else {
					if (valid(idxi + dx[lastdr], idxj + dy[lastdr])) {
						idxi += dx[lastdr];
						idxj += dy[lastdr];
						if (mz[idxi][idxj] == '*') {
							mz[idxi][idxj] = '.';
							cnt++;
						}
					}
				}
			}
			sb.append(cnt + "\n");
			s = bf.readLine();
		}
		System.out.print(sb);
	}
}
