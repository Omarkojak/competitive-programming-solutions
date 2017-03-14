package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesA41 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s1=bf.readLine();
		String s2=bf.readLine();
		if(s1.length()!=s2.length())
			out.println("NO");
		else{
			boolean flag=true;
			for(int i=0,j=s1.length()-1;i<s1.length();i++,j--)
				if(s1.charAt(i)!=s2.charAt(j)){
					flag=false;
					break;
			}
			out.println(flag?"YES":"NO");
		}
		out.close();
		
	}

}
