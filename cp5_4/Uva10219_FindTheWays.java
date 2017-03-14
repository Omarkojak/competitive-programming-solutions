package cp5_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Uva10219_FindTheWays {
	
	static BigInteger nCr(int N, int K)		// O(K)
	{
		if(K > N)
			return BigInteger.valueOf(0);
		BigInteger res = new BigInteger("1");
		for(int i = 1; i <= K; ++i)
		{
			BigInteger b1 = BigInteger.valueOf(N-K+i).multiply(res);
			res = b1.divide(BigInteger.valueOf(i));
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = bf.readLine();
		while(s!=null&&s.length()!=0)
		{
			StringTokenizer ns =new StringTokenizer(s);
			int n = Integer.parseInt(ns.nextToken());
			int k = Integer.parseInt(ns.nextToken());
			
			//sb.append(res.length()).append("\n");
			BigInteger res = nCr(n, Math.min(k, n-k));
			sb.append(res.toString().length()).append("\n");
			s=bf.readLine();
		}
		System.out.print(sb);
	}

}
