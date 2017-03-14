package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CodeforcesA579 {
	
	public static int ev(int x){
		if(x<=1)
			return x;
		if(x%2==0)
			return ev(x/2);
		else
			return 1+ev(x/2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		out.println(ev(n));
		out.close();
		}
	}

