package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;


public class CodeforcesA609 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int m=Integer.parseInt(bf.readLine());
		int []a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(bf.readLine());
		Arrays.sort(a);
		int sum=0;
		int r=0;
		for(int i=n-1;i>-1;i--){
			sum+=a[i];
			r++;
			if(sum>=m)
				break;
		}
		out.print(r);
		out.close();
	}

}
