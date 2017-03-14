package cp5_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Uva10079_PizzaCutting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			long n = Long.parseLong(bf.readLine());
			if(n<0)
				break;
			long res = ((n*(n+1))>>1) +1;
			sb.append(res).append("\n");
			
		}
		System.out.print(sb);
	}

}
