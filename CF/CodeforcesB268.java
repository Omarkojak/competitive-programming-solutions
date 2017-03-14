package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CodeforcesB268 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		long result=0;
		int n=Integer.parseInt(bf.readLine());
		long r=0;
	    
	    int butt=0;
	   while(butt<n){
		   r+=n-butt+(n-butt-1)*butt;
		  butt++;
	   }
		out.println(r);
		out.close();
	}
}
