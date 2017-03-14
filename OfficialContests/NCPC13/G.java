package OfficialContests.NCPC13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		char[] s1 = bf.readLine().toCharArray();
		char[] s2 = bf.readLine().toCharArray();
		if(s1.length != s2.length)
		{
			System.out.println("Deletion failed");
			return;
		}
		boolean flag = true;
		for(int i=0;i<s1.length && flag;i++)
			if((n & 1) == 0)
			{
				if(s1[i] != s2[i])
					flag = false;
			}else
			{
				if(s1[i] == s2[i])
					flag = false;
			}
		if(flag)
			System.out.println("Deletion succeeded");
		else
			System.out.println("Deletion failed");

	}
}
