package OfficialContests.Syria15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		while (t-- > 0) {
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			int max = Math.max(Integer.parseInt(ns.nextToken()),
					Integer.parseInt(ns.nextToken()));
			System.out.println(max * max);
		}

	}

}
