package CF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class A519 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new OutputStreamWriter(System.out)));
		int w = 0;
		int b = 0;
		for (int i = 0; i < 8; i++) {
			String s = bf.readLine();
			for (int j = 0; j < 8; j++) {
				char c = s.charAt(j);
				if (c == '.')
					continue;
				String k = c + "";
				String s1 = k.toUpperCase();
				if (s1.equals(k)) {
					switch (c) {
					case 'Q':
						w += 9;
						break;
					case 'R':
						w += 5;
						break;
					case 'B':
						w += 3;
						break;
					case 'N':
						w += 3;
						break;
					case 'P':
						w += 1;
						break;
					default:
						break;
					}
				} else {
					switch (c) {
					case 'q':
						b += 9;
						break;
					case 'r':
						b += 5;
						break;
					case 'b':
						b += 3;
						break;
					case 'n':
						b += 3;
						break;
					case 'p':
						b += 1;
						break;
					default:
						break;
					}

				}
			}
		}
		out.println(b == w ? "Draw" : b > w ? "Black" : "White");
		out.close();
	}
}
