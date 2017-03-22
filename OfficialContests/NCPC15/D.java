package OfficialContests.NCPC15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D {

	public static int ceil(int max, int k) {
		return max / k + ((max % k == 0) ? 0 : 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int k = Integer.parseInt(ns.nextToken());
		int max = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		while (n-- > 0) {
			int start = Integer.parseInt(bf.readLine());
			while (!q.isEmpty() && q.peek() <= start)
				q.poll();
			q.add(start + 1000);
			max = Math.max(max, q.size());
		}
		System.out.println(ceil(max, k));

	}

}
