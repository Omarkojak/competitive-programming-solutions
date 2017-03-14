package cp5_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Uva10303_HowManyTrees {
	
	static BigInteger nCr(int N, int K)		// O(K)
	{
		if(K > N)
			return new BigInteger("0");
		BigInteger res = new BigInteger("1") ;
		for(int i = 1; i <= K; ++i)
		{
			BigInteger b1 = BigInteger.valueOf(N-K+i);
			
			res = b1.multiply(res).divide(BigInteger.valueOf(i));
		}
		return res;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = bf.readLine();
		while(s!=null )
		{
			int n = Integer.parseInt(s);
			//System.out.println(nCr(2000,1000));
			sb.append(nCr(n*2,n).divide(BigInteger.valueOf(n+1))).append("\n");
			s = bf.readLine();
		}
		System.out.print(sb);
	}
	
}
