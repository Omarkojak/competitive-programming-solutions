package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Uva10783 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());
		for(int i=1;i<=t;i++){
			int a=Integer.parseInt(bf.readLine());
			int b=Integer.parseInt(bf.readLine());
			int k=a;
			if(k%2==0)
				k++;
			long sum=0;
			while(k<=b){
				sum+=k;
				k+=2;
			}
			out.println("Case "+i+": "+sum);
			
		}
		out.close();
	}

}
