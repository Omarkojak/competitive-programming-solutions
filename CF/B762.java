package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B762 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		ArrayList<Integer> usb = new ArrayList<>();
		ArrayList<Integer> ps = new ArrayList<>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int cost = in.nextInt();
			if (in.next().equals("USB"))
				usb.add(cost);
			else
				ps.add(cost);

		}

		Collections.sort(usb);
		Collections.sort(ps);
		long ans = 0;
		int cnt = 0;
		for (int i = 0; i < Math.min(a, usb.size()); i++) {
			cnt++;
			ans += (long) usb.get(i);
		}
		for (int i = 0; i < Math.min(b, ps.size()); i++) {
			cnt++;
			ans += (long) ps.get(i);
		}
		ArrayList<Integer> as = new ArrayList<>();

		for (int j = a; j < usb.size(); j++)
			as.add(usb.get(j));

		for (int j = b; j < ps.size(); j++)
			as.add(ps.get(j));

		Collections.sort(as);

		for (int i = 0; i < Math.min(c, as.size()); i++) {
			cnt++;
			ans += (long) as.get(i);
		}
		System.out.println(cnt + " " + ans);

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}
	}

}
