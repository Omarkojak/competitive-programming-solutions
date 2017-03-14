package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CodeforcesA591 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int l=Integer.parseInt(bf.readLine());
		double p=Integer.parseInt(bf.readLine());
		double q=Integer.parseInt(bf.readLine());
	
		double cnst=p/q;
		double x=cnst*l;
		cnst+=1;
		cnst=1/cnst;
		x*=cnst;
		out.println(x);
		out.close();
	}

}
