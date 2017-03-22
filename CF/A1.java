package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		long n = Long.parseLong(ns.nextToken());
		long m = Long.parseLong(ns.nextToken());
		long a = Long.parseLong(ns.nextToken());

		long r1 = n / a + ((n % a == 0) ? 0 : 1);
		long r2 = m / a + ((m % a == 0) ? 0 : 1);

		System.out.println((r1 * r2));

	}

}
