package cp5_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Uva10948_ThePrimaryProblem {
	static boolean isPrime [];
	static ArrayList<Integer> primes;
	
	public static void sieve (int max){
		isPrime = new boolean [max + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		primes = new ArrayList<>();
		
		for(int i = 2;i <= max;i++){
			if(isPrime[i]){
				primes.add(i);
	    		if(1l * i * i <= max)
	    			for(int j = i * i;j < max + 1 ;j += i)
	    			{
	    				isPrime[(int)j] = false;
	    			}
			}
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sieve(((int) 1e6)+2);
		while(true)
		{
			int n = Integer.parseInt(bf.readLine());
			if(n==0)
				break;
			sb.append(n).append(":\n");
			if(n%2!=0)
			{
				if(isPrime[n-2])
					sb.append(2+"+"+(n-2)).append("\n");
				else
					sb.append("NO WAY!\n");
				continue;
			}
			int a1 = -1;
			for(int k:primes)
				if(k<n&&isPrime[n-k])
				{
					a1 = k;
					break;
				}
			if(a1!=-1)
				sb.append(a1+"+"+(n-a1)).append("\n");
			else
				sb.append("NO WAY!\n");
			
		}
		System.out.print(sb);
	}

}
