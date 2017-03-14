package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A145_LuckyConversion {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String a = bf.readLine();
		String b = bf.readLine();
		int wrongfours = 0;
		int wrongsevens = 0;
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i) != b.charAt(i))
				if(a.charAt(i) == '4')
					wrongfours++;
				else
					wrongsevens++;
		}
		int res = Math.max(wrongfours, wrongsevens);
		System.out.println(res);
	}

}
