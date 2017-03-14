package OfficialContests.CodeCraft15;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class I {
	static char[]s;
	static int n;
	static long dp[][];
	static char []l = {'L', 'O', 'L'};
	
	public static long solve(int idx1, int idx2)
	{
		if(idx2 == 3)
			return 1;
		if(idx1 == n)
			return 0;
		if(dp[idx1][idx2] != -1)
			return dp[idx1][idx2];
		
		long take = 0;
		if(s[idx1] == l[idx2])
			take = solve(idx1+1, idx2+1);
		long leave = solve(idx1+1, idx2);
		return dp[idx1][idx2] = take + leave;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(bf.readLine());
		while(t-->0)
		{
			s = bf.readLine().toCharArray();
			n = s.length;
			dp = new long [n][3];
			for(int i=0;i<n;i++)
				Arrays.fill(dp[i], -1);
			sb.append(solve(0,0)).append("\n");
		}
		System.out.print(sb);
	
	}

}
