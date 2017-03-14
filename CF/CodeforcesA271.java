package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesA271 {
	
	public static boolean check(int r){
		String s=r+"";
		for(int i=0;i<s.length();i++)
			for(int j=i+1;j<s.length();j++)
				if(s.charAt(i)==s.charAt(j))
					return false;
		
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		boolean flag=false;
		int r=n+1;
		while(!flag){
			if(check(r))
				flag=true;
			else
				r++;
			
		}
		out.print(r);
		out.close();
	}

}
