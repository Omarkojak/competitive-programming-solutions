package OfficialContests.Syria15;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {

	public static boolean solve(int idx, int[] cnt) {
		if (idx == 5)
			return true;
		if (idx == 0) {
			if (cnt[0] == 0)
				return false;
			cnt[0] = cnt[0] - 1;
			return solve(idx + 1, cnt);
		}

		if (idx == 1) {
			if (cnt[0] < 2 && cnt[1] == 0)
				return false;

			boolean f = false;
			if (cnt[0] >= 2) {
				cnt[0] -= 2;
				f = solve(idx + 1, cnt);
				cnt[0] += 2;
			}
			if (cnt[1] >= 1) {
				cnt[1] -= 1;
				f |= solve(idx + 1, cnt);
			}
			return f;
		}

		if (idx == 2) {
			if ((cnt[0] == 0 && cnt[1] == 0) && cnt[2] == 0)
				return false;
			boolean f = false;
			if (cnt[0] >= 1 && cnt[1] >= 1) {
				cnt[0] -= 1;
				cnt[1] -= 1;
				f |= solve(idx + 1, cnt);
				cnt[0] += 1;
				cnt[1] += 1;
			}
			if (cnt[2] >= 1) {
				cnt[2] -= 1;
				f |= solve(idx + 1, cnt);
				cnt[2] += 1;
			}
			return f;
		}

		if (idx == 3) {
			if (cnt[1] <= 1 && cnt[0] == 0 && cnt[2] == 0 && cnt[3] == 0)
				return false;
			boolean f = false;
			if (cnt[3] >= 1) {
				cnt[3] -= 1;
				f |= solve(idx + 1, cnt);
				cnt[3] += 1;
			}

			if (cnt[2] >= 1 && cnt[0] >= 1) {
				cnt[0] -= 1;
				cnt[2] -= 1;
				f |= solve(idx + 1, cnt);
				cnt[0] += 1;
				cnt[2] += 1;
			}
			if (cnt[1] >= 2) {
				cnt[1] -= 2;
				f |= solve(idx + 1, cnt);
				cnt[1] += 2;

			}
			return f;

		}
		if (idx == 4) {
			if (cnt[1] == 0 && cnt[2] == 0 && cnt[0] == 0 && cnt[3] == 0
					&& cnt[4] == 0)
				return false;

			boolean f = false;
			if (cnt[4] >= 1) {
				cnt[4] -= 1;
				f |= solve(idx + 1, cnt);
				cnt[4] += 1;
			}

			if (cnt[1] >= 1 && cnt[2] >= 1) {
				cnt[1] -= 1;
				cnt[2] -= 1;
				f |= solve(idx + 1, cnt);
				cnt[1] += 1;
				cnt[2] += 1;
			}
			
			if (cnt[0] >= 1 && cnt[3] >= 1) {
				cnt[0] -= 1;
				cnt[3] -= 1;
				f |= solve(idx + 1, cnt);
				cnt[0] += 1;
				cnt[3] += 1;
			}
			
			return f;

		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			char[] s = bf.readLine().toCharArray();
			int[] cnt = new int[5];
			for (char c : s)
				cnt[c - 'A']++;
			sb.append(solve(0, cnt)? "YES\n":"NO\n");

		}
		System.out.print(sb);

	}
}
