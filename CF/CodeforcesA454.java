package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CodeforcesA454 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int k=1;
		for(int i=0;i<n;i++){
			String s="";
			for(int j=0;j<(n-k)/2;j++)
				s+="*";
			for(int j=0;j<k;j++)
				s+="D";
			for(int j=0;j<(n-k)/2;j++)
				s+="*";
			out.println(s);
			if(i<n/2)
				k+=2;
			else
				k-=2;
		}
		out.close();
	}

}
