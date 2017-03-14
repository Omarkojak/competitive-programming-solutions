package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva410 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		int i=1;
		while(s!=null&&s.length()!=0){
			
			StringTokenizer ns =new StringTokenizer(s);
			int c=Integer.parseInt(ns.nextToken());
			int n=Integer.parseInt(ns.nextToken());
			ns=new StringTokenizer(bf.readLine());
			int []a=new int [2*c];
			double sum=0;
			for(int m=0;m<n;m++){
				a[m]=Integer.parseInt(ns.nextToken());
				sum+=a[m];
			}
			Arrays.sort(a);
			double k=sum/c*1.0;
			double r=0;
			//out.println(k);
			out.printf("Set #%d\n", i++);
			int j=0;
			for(int w=0;w<c;w++){
				out.printf(" %d:", w);
				
				if(a[j]!=0)
					out.printf(" %d %d\n", a[j], a[2*c-j-1]);
				else if(a[2*c-j-1]!=0)
					out.printf(" %d\n", a[2*c-j-1]);
				else
					out.printf("\n");
				sum=a[2*c-j-1]+a[j];
				
					r+=Math.abs(sum-k);
				//out.println(r);
				j++;
			}
			out.printf("IMBALANCE = %.5f", r);
			out.printf("\n\n");
			s=bf.readLine();
		
		}
		out.close();
	}

}
