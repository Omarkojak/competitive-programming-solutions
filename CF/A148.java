package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A148 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int a[] = new int[4];
		for (int i = 0; i < 4; i++)
			a[i] = Integer.parseInt(bf.readLine());

		int n = Integer.parseInt(bf.readLine());
		int b = 0;
		for (int i = 1; i <= n; i++) {
			boolean flag = false;
			for (int j = 0; j < 4; j++)
				if (i % a[j] == 0) {
					flag = true;
					break;
				}
			if (!flag)
				b++;

		}
		out.print(n - b);
		out.close();

	}

}
