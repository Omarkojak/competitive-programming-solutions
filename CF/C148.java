package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C148 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ns = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(ns.nextToken());
		int a = Integer.parseInt(ns.nextToken());
		int b = Integer.parseInt(ns.nextToken());
		int[] arr = new int[n];
		arr[0] = 1;
		int sum = 1;
		int idx = 1;
		if (b == 0 && a > 0) {
			arr[1] = 1;
			idx++;
		}
		while (b-- > 0) {
			arr[idx] = sum + 1;
			sum += arr[idx];
			idx++;
		}
		boolean flag = true;
		while (a > 0 && idx < n) {
			arr[idx] = arr[idx - 1] + 1;
			if (arr[idx] > 50000)
				flag = false;
			idx++;
			a--;
		}

		while (idx < n)
			arr[idx++] = 1;

		if (a > 0 || b > 0 || !flag)
			System.out.println(-1);
		else
			for (int x : arr)
				System.out.print(x + " ");

	}

}
