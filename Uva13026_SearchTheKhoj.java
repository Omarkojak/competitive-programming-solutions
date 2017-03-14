import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Uva13026_SearchTheKhoj {
	
	public static boolean match(String s1, String s2)
	{
		if(s1.length() != s2.length())return false;
		boolean flag = false;
		for(int i=0;i<s1.length();i++)
			if(s1.charAt(i) != s2.charAt(i))
			{
				if(flag)
					return false;
				else
					flag = true;
			}
		return true;
	
	
	
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(bf.readLine());
		int cse = 1;
		while(t-->0)
		{
			int n = Integer.parseInt(bf.readLine());
			String arr [] = new String [n];
			for(int i=0;i<n;i++)
				arr[i] = bf.readLine();
			String s = bf.readLine();
			out.printf("Case %d:\n", cse++);
			for(int i=0;i<n;i++)
				if(match(s, arr[i]))
					out.println(arr[i]);
			
			
			
		}
		out.flush();
		out.close();
	}

}
