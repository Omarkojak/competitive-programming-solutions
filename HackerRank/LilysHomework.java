package HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class LilysHomework {
	static ArrayList<Integer> as;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr1[] = new int[n];
		int arr2[] = new int[n];
		as = new ArrayList<>();
		TreeMap<Integer, Integer> mp1 = new TreeMap<>();
		TreeMap<Integer, Integer> mp2 = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			arr1[i] = in.nextInt();
			arr2[i] = arr1[i];
			as.add(arr1[i]);
			mp1.put(arr1[i], i);
			mp2.put(arr1[i], i);
		}
		Collections.sort(as);

		System.out.println(Math.min(asc(arr1, mp1), desc(arr2, mp2)));

	}

	static int asc(int[] arr, TreeMap<Integer, Integer> mp) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			int x = as.get(i);
			if (arr[i] != x) {
				int pos = mp.get(x);
				arr[pos] = arr[i];
				arr[i] = x;
				mp.put(arr[pos], pos);
				cnt++;
			}
		}
		return cnt;
	}

	static int desc(int[] arr, TreeMap<Integer, Integer> mp) {
		int n = arr.length;
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			int x = as.get(i);
			int j = n - i - 1;
			if (arr[j] != x) {
				int pos = mp.get(x);
				arr[pos] = arr[j];
				arr[j] = x;
				mp.put(arr[pos], pos);
				cnt++;
			}
		}
		return cnt;
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
