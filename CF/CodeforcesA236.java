package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.TreeSet;


public class CodeforcesA236 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		TreeSet<String> t=new TreeSet<String>();
		for(int i=0;i<s.length();i++)
			t.add(s.charAt(i)+"");
		
		int l=t.size();
		out.println(l%2==0?"CHAT WITH HER!":"IGNORE HIM!");
		out.close();
		
		
	}

}
