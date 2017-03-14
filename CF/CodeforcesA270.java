package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesA270 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int ang=Integer.parseInt(bf.readLine());
			int rem=180-ang;
			if(rem!=0&&360%rem==0)
				out.println("YES");
			else
				out.println("NO");
				
		}
		out.close();
	}

}
