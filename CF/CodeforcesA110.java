package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesA110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		int sum=0;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)=='7'||s.charAt(i)=='4')
				sum++;
		
		s=sum+"";
		boolean flag=true;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!='7'&&s.charAt(i)!='4'){
				flag=false;
				break;
			}
		}
		out.print(flag?"YES":"NO");
		out.close();
		
	}

}
