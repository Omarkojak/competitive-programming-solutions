package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesB118 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int spaces=n;
		int max=0;
		for (int i=0; i<=n; i++,max++){
			for (int j=0; j<spaces; j++)
				out.print("  ");
			for (int k=0; k<=max; k++){
				
				out.print(k);
				if (i!=0)
					out.print(" ");
				
			}
			for (int k=max-1; k>=0; k--){
				out.print(k);
				if (k!=0)
					out.print(" ");
			}
				
			out.println();
			spaces--;
		}
		spaces=1;
		max=n-1;
		for (int i=1; i<=n; i++,max--){
			for (int j=0; j<spaces; j++)
				out.print("  ");
			for (int k=0; k<=max; k++){
				
				out.print(k);
				if (i!=n)
					out.print(" ");
				
			}
			for (int k=max-1; k>=0; k--){
				out.print(k);
				if (k!=0)
					out.print(" ");
			}
			out.println();
			spaces++;
		}
		
		out.close();
	}

}