package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CodeforcesA540 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		String s1=bf.readLine();
		String s2=bf.readLine();
		int r=0;
		for(int i=0;i<n;i++){
			int c1=Integer.parseInt(s1.charAt(i)+"");
			int c2=Integer.parseInt(s2.charAt(i)+"");
			int b=Math.abs(c1-c2);
			int f=Math.abs((10-Math.max(c1, c2))+(Math.min(c1, c2)-0));
			r+=Math.min(b, f);			
		}
		out.println(r);
		out.close();
	}
}
