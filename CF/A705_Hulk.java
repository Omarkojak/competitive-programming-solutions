package CF;

import java.util.Scanner;

public class A705_Hulk {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = in.nextInt();
		for(int i=0;i<n;i++)
		{
			if((i & 1) == 0)
				sb.append("I hate ");
			else
				sb.append("I love ");
			if(i == n-1)
				sb.append("it");
			else
				sb.append("that ");
		}
		System.out.println(sb);
	}

}
