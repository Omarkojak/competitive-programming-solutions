package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B151 {

	public static char check(String s) {
		boolean decr = true;
		boolean same = true;
		char c = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '-')
				continue;
			if (i == 3 || i == 6) {
				if (s.charAt(i - 2) <= s.charAt(i))
					decr = false;
			} else if (s.charAt(i - 1) <= s.charAt(i))
				decr = false;

			if (c != s.charAt(i))
				same = false;
		}
		if (decr)
			return 'P';
		if (same)
			return 'T';
		return 'G';
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		PhoneBook[] arr = new PhoneBook[n];
		for (int i = 0; i < n; i++) {
			int k = in.nextInt();
			arr[i] = new PhoneBook(in.next());
			while (k-- > 0) {
				char type = check(in.nextLine());
				switch (type) {
				case 'T':
					arr[i].taxi++;
					break;
				case 'P':
					arr[i].pizza++;
					break;
				default:
					arr[i].girls++;
				}
			}
		}
		int max = 0;
		ArrayList<String> as = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (arr[i].taxi == max)
				as.add(arr[i].name);
			else if (arr[i].taxi > max) {
				max = arr[i].taxi;
				as = new ArrayList<>();
				as.add(arr[i].name);
			}
		}
		out.print("If you want to call a taxi, you should call: ");
		for (int i = 0; i < as.size(); i++) {
			out.print(as.get(i));
			if (i == as.size() - 1)
				out.println(".");
			else
				out.print(", ");
		}

		max = 0;
		as = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (arr[i].pizza == max)
				as.add(arr[i].name);
			else if (arr[i].pizza > max) {
				max = arr[i].pizza;
				as = new ArrayList<>();
				as.add(arr[i].name);
			}
		}
		out.print("If you want to order a pizza, you should call: ");
		for (int i = 0; i < as.size(); i++) {
			out.print(as.get(i));
			if (i == as.size() - 1)
				out.println(".");
			else
				out.print(", ");
		}

		max = 0;
		as = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (arr[i].girls == max)
				as.add(arr[i].name);
			else if (arr[i].girls > max) {
				max = arr[i].girls;
				as = new ArrayList<>();
				as.add(arr[i].name);
			}
		}
		out.print("If you want to go to a cafe with a wonderful girl, you should call: ");
		for (int i = 0; i < as.size(); i++) {
			out.print(as.get(i));
			if (i == as.size() - 1)
				out.println(".");
			else
				out.print(", ");
		}

		out.flush();
		out.close();
	}

	static class PhoneBook {
		String name;
		int taxi, pizza, girls;

		PhoneBook(String a) {
			name = a;
			taxi = 0;
			pizza = 0;
			girls = 0;
		}

		public String toString() {
			return taxi + "t " + pizza + "p " + girls + "g ";
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

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
