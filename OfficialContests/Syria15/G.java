package OfficialContests.Syria15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(bf.readLine());
			char[][] grid = new char[3][n * 3];
			for (int i = 0; i < 3; i++) {
				String s = bf.readLine();
				for (int j = 0; j < 3 * n; j++)
					grid[i][j] = s.charAt(j);
			}
			int max = 0;
			for (int j = 0; j < 3 * n; j += 3) {
				int cnt = 0;
				for (int i = 0; i < 3; i++) {
					if(grid[i][j] == '*')
						cnt++;
					if(grid[i][j + 1] == '*')
						cnt++;
					if(grid[i][j + 2] == '*')
						cnt++;
				}
				max = Math.max(max, cnt * 4);
			}
			System.out.println(max);

		}

	}
}
