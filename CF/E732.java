package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class E732 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int m = in.nextInt();
		HashMap<Integer, PriorityQueue<Socket>> mp = new HashMap<>();
		Computer[] arr = new Computer[n];
		for (int i = 0; i < n; i++) {
			int power = in.nextInt();
			arr[i] = new Computer(i, power);
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++)
			mp.put(arr[i].power, new PriorityQueue<Socket>());

		PriorityQueue<Socket> pq;
		for (int i = 0; i < m; i++) {
			int curr = in.nextInt();
			int cnt = 0;
			while (true) {
				pq = mp.get(curr);
				if (pq != null) {
					pq.add(new Socket(i + 1, cnt));
				}
				if (curr <= 1)
					break;
				curr = (curr + 1) >> 1;
				cnt++;
			}
		}
		Socket min;
		boolean socketused[] = new boolean[m];
		int computertoadapter[] = new int[n];
		int[] adapters = new int[m];
		int used = 0, matched = 0;
		for (int i = n - 1; i >= 0; i--) {
			Computer c = arr[i];
			pq = mp.get(c.power);
			min = null;
			while (!pq.isEmpty()) {
				min = pq.remove();
				if (!socketused[min.id - 1])
					break;
				min = null;
			}
			if (min == null)
				continue;
			computertoadapter[c.idx] = min.id;
			adapters[min.id - 1] = min.adapters;
			used += min.adapters;
			matched++;
			socketused[min.id - 1] = true;
		}

		StringBuilder sb = new StringBuilder();
		// sb.append(matched + " " + used).append("\n");
		out.println(matched + " " + used);
		for (int i = 0; i < m; i++) {
			sb.append(adapters[i]);
			if (i != m - 1)
				sb.append(" ");
		}
		sb.append("\n");
		for (int i = 0; i < n; i++) {
			sb.append(computertoadapter[i]);
			if (i != n - 1)
				sb.append(" ");
		}
		// System.out.println(sb);
		out.println(sb);
		out.flush();
		out.close();
	}

	static class Computer implements Comparable<Computer> {
		int idx;
		int power;

		Computer(int a, int b) {
			idx = a;
			power = b;
		}

		public int compareTo(Computer c) {
			return power - c.power;
		}

	}

	static class Socket implements Comparable<Socket> {
		int id;
		int adapters;

		Socket(int a, int b) {
			id = a;
			adapters = b;
		}

		public int compareTo(Socket o) {
			return adapters - o.adapters;
		}

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
