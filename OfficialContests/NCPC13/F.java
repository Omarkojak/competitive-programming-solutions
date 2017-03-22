package OfficialContests.NCPC13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
	char[][] temp = { { '*', '*', '*' }, { '*', '*', '*' }, { '*', '*', '*' },
			{ '*', '*', '*' }, { '*', '*', '*' } };

	static char[][] zero = { { '*', '*', '*' }, { '*', ' ', '*' },
			{ '*', ' ', '*' }, { '*', ' ', '*' }, { '*', '*', '*' } };
	static char[][] one = { { ' ', ' ', '*' }, { ' ', ' ', '*' },
			{ ' ', ' ', '*' }, { ' ', ' ', '*' }, { ' ', ' ', '*' } };
	static char[][] two = { { '*', '*', '*' }, { ' ', ' ', '*' },
			{ '*', '*', '*' }, { '*', ' ', ' ' }, { '*', '*', '*' } };
	static char[][] three = { { '*', '*', '*' }, { ' ', ' ', '*' },
			{ '*', '*', '*' }, { ' ', ' ', '*' }, { '*', '*', '*' } };
	static char[][] four = { { '*', ' ', '*' }, { '*', ' ', '*' },
			{ '*', '*', '*' }, { ' ', ' ', '*' }, { ' ', ' ', '*' } };
	static char[][] five = { { '*', '*', '*' }, { '*', ' ', ' ' },
			{ '*', '*', '*' }, { ' ', ' ', '*' }, { '*', '*', '*' } };
	static char[][] six = { { '*', '*', '*' }, { '*', ' ', ' ' },
			{ '*', '*', '*' }, { '*', ' ', '*' }, { '*', '*', '*' } };
	static char[][] seven = { { '*', '*', '*' }, { ' ', ' ', '*' },
			{ ' ', ' ', '*' }, { ' ', ' ', '*' }, { ' ', ' ', '*' } };
	static char[][] eight = { { '*', '*', '*' }, { '*', ' ', '*' },
			{ '*', '*', '*' }, { '*', ' ', '*' }, { '*', '*', '*' } };
	static char[][] nine = { { '*', '*', '*' }, { '*', ' ', '*' },
			{ '*', '*', '*' }, { ' ', ' ', '*' }, { '*', '*', '*' } };

	static char[][] grid;

	public static int ev(int i) {
		boolean flag = true;
		for (int k = 0; k < 5; k++)
			for (int w = i, r = 0; w <= i + 2; w++, r++)
				if (grid[k][w] != zero[k][r])
					flag = false;

		if (flag)
			return 0;

		flag = true;
		for (int k = 0; k < 5; k++)
			for (int w = i, r = 0; w <= i + 2; w++, r++)
				if (grid[k][w] != one[k][r])
					flag = false;

		if (flag)
			return 1;

		flag = true;
		for (int k = 0; k < 5; k++)
			for (int w = i, r = 0; w <= i + 2; w++, r++)
				if (grid[k][w] != two[k][r])
					flag = false;

		if (flag)
			return 2;

		flag = true;
		for (int k = 0; k < 5; k++)
			for (int w = i, r = 0; w <= i + 2; w++, r++)
				if (grid[k][w] != three[k][r])
					flag = false;

		if (flag)
			return 3;

		flag = true;
		for (int k = 0; k < 5; k++)
			for (int w = i, r = 0; w <= i + 2; w++, r++)
				if (grid[k][w] != four[k][r])
					flag = false;

		if (flag)
			return 4;

		flag = true;
		for (int k = 0; k < 5; k++)
			for (int w = i, r = 0; w <= i + 2; w++, r++)
				if (grid[k][w] != five[k][r])
					flag = false;

		if (flag)
			return 5;

		flag = true;
		for (int k = 0; k < 5; k++)
			for (int w = i, r = 0; w <= i + 2; w++, r++)
				if (grid[k][w] != six[k][r])
					flag = false;

		if (flag)
			return 6;

		flag = true;
		for (int k = 0; k < 5; k++)
			for (int w = i, r = 0; w <= i + 2; w++, r++)
				if (grid[k][w] != seven[k][r])
					flag = false;

		if (flag)
			return 7;

		flag = true;
		for (int k = 0; k < 5; k++)
			for (int w = i, r = 0; w <= i + 2; w++, r++)
				if (grid[k][w] != eight[k][r])
					flag = false;

		if (flag)
			return 8;

		flag = true;
		for (int k = 0; k < 5; k++)
			for (int w = i, r = 0; w <= i + 2; w++, r++)
				if (grid[k][w] != nine[k][r])
					flag = false;

		if (flag)
			return 9;

		return -1;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		grid = new char[5][];
		for (int i = 0; i < 5; i++) {
			grid[i] = bf.readLine().toCharArray();
		}

		int found = -1;
		for (int i = 2; i <= 8; i++) {
			int size = i * 3 + (i - 1);
			if (size == grid[0].length) {
				found = i;
				break;
			}
		}
		long mul = (long) Math.pow(10, found - 1);
		long res = 0;
		boolean flag = true;

		for (int i = 0; i < grid[0].length; i += 4, mul /= 10) {
			int num = ev(i);
			if (num == -1)
				flag = false;
			else
				res += num * mul;
		}
		if (flag && res % 6 == 0)
			System.out.println("BEER!!");
		else
			System.out.println("BOOM!!");

	}

}
