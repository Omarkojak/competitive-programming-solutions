package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesA474 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		char c=bf.readLine().charAt(0);
		String s="qwertyuiopasdfghjkl;zxcvbnm,./";
		String in=bf.readLine();
		String r="";
		for(int i=0;i<in.length();i++){
			int j;char k=in.charAt(i);
			for(j=0;j<s.length();j++)
				if(k==s.charAt(j))
					break;
			r+=(c=='R')? s.charAt(j-1):s.charAt(j+1);
		}
		out.println(r);
		out.close();
	}

}
