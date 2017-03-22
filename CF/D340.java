package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D340 {

	static int bs(ArrayList<Integer> as, int x) {
		int low = 0, high = as.size() - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (as.get(mid) > x)
				high = mid - 1;
			else {
				low = mid + 1;
			}
		}
		return low;
	}

	static int LIS(int[] arr) {
		int lis = 0, n = arr.length;
		ArrayList<Integer> as = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int pos = bs(as, arr[i]);
			if (pos == as.size())
				as.add(arr[i]);
			else
				as.set(pos, arr[i]);
			if (pos + 1 > lis)
				lis = pos + 1;
		}
		return lis;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		System.out.println(LIS(arr));

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
