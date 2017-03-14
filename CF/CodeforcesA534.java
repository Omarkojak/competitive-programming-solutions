package CF;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class CodeforcesA534 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int n=Integer.parseInt(bf.readLine());
		if(n==1||n==2){
			out.println(1);
			out.println(1);
		}
		if(n==3){
			out.println(2);
			out.println("1 3");
		}
		if(n>=4){
			out.println(n);
			int odd=n;int even=n;
			if(n%2==0)
				odd--;
			else
				even--;
			String s=""+odd;odd-=2;
			while(odd>=1){s+=" "+odd;odd-=2;}
			while(even>=2){s+=" "+even;even-=2;}
			out.println(s);
		}
		out.close();
	}

}
