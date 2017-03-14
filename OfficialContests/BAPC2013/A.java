package OfficialContests.BAPC2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class A {
	static final long inf = (long) 1e18;
	
	public static Long ceil(long ans)
	{
		int r = 0;
		if(ans%100 != 0)
			r++;
		ans/=100;
		return ans+r;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while (t-- > 0) {
			int cars = in.nextInt();
			int events = in.nextInt();
			TreeMap<String, Long> peoplenames = new TreeMap<>();
			TreeMap<String, Trio> carsinfos = new TreeMap<>();
			TreeMap<String, String> currcar = new TreeMap<>();
			TreeMap<String, Long> currcost = new TreeMap<>();

			for (int i = 0; i < cars; i++)
				carsinfos.put(in.next(), new Trio(in.nextInt(), in.nextInt(),
						in.nextInt()));
			for (int i = 0; i < events; i++) {
				int time = in.nextInt();
				String personname = in.next();
				char type = in.next().charAt(0);

				if (peoplenames.containsKey(personname)
						&& peoplenames.get(personname) == -inf) {
					in.next();
					continue;
				}
				if (type == 'p') {
					if (currcar.containsKey(personname)) {
						peoplenames.put(personname, -inf);
						in.next();
						continue;
					}
					String car = in.next();
					if(!carsinfos.containsKey(car))
					{
						peoplenames.put(personname, -inf);
						continue;
					}
						
					if (!peoplenames.containsKey(personname))
						peoplenames.put(personname, 0L);
					
					currcar.put(personname, car);
				}
				if (type == 'r') {
					if (!currcar.containsKey(personname)) {
						peoplenames.put(personname, -inf);
						in.next();
						continue;
					}
					if (!currcost.containsKey(personname))
						currcost.put(personname, 0L);
					long dist = in.nextLong();
					long totalcost =currcost.get(personname) + carsinfos.get(currcar.get(personname)).kmcost * dist;
					long bill = peoplenames.get(personname) + totalcost
							+ carsinfos.get(currcar.get(personname)).pickup;
					peoplenames.put(personname, bill);
					currcar.remove(personname);
					currcost.remove(personname);
				}

				if (type == 'a') {
					if (!currcost.containsKey(personname))
						currcost.put(personname, 0L);
					if (!currcar.containsKey(personname)) {
						peoplenames.put(personname, -inf);
						in.next();
						continue;
					}
					Long after = currcost.get(personname)+ ceil(carsinfos.get(currcar.get(personname)).price * in.nextLong());
					currcost.put(personname, after);
				}
			}
			for (Entry<String, Long> e : peoplenames.entrySet()) {
				out.println(e.getKey()
						+ " "
						+ ((e.getValue() == -inf || currcar.containsKey(e
								.getKey())) ? "INCONSISTENT" : e.getValue()));
			}
		}
		out.flush();
		out.close();
	}

	static class Trio {
		int price;
		int pickup;
		int kmcost;

		Trio(int a, int b, int c) {
			price = a;
			pickup = b;
			kmcost = c;
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
