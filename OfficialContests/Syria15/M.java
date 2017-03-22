package OfficialContests.Syria15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class M {
	static final int limit = ((int) 1e4) + 5;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			int N = Integer.parseInt(bf.readLine());
			TreeMap<String, Integer> coaches = new TreeMap<>();
			String[] arr = new String[limit];
			int[][] schedule = new int[limit][368];
			int idx = 0;
			while (N-- > 0) {
				StringTokenizer ns = new StringTokenizer(bf.readLine());
				ns.nextToken();
				int start = Integer.parseInt(ns.nextToken());
				int end = Integer.parseInt(ns.nextToken());
				int V = Integer.parseInt(ns.nextToken());
				while (V-- > 0) {
					String s = ns.nextToken();

					if (!coaches.containsKey(s)) {
						coaches.put(s, idx);
						arr[idx] = s;
						idx++;
					}
					int num = coaches.get(s);

					schedule[num][start] += 1;
					schedule[num][end + 1] -= 1;

				}
			}
			ArrayList<String> output = new ArrayList<>();
			for (int i = 0; i < idx; i++) {
				boolean conflict = false;
				for (int j = 1; j < 368; j++) {
					schedule[i][j] += schedule[i][j - 1];
					if (schedule[i][j] >= 2)
						conflict = true;
				}
				if (conflict)
					output.add(arr[i]);
			}
			Collections.sort(output);
			sb.append(output.size()).append("\n");
			for (String s : output)
				sb.append(s).append("\n");
		}
		System.out.print(sb);

	}

}
