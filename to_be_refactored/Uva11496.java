package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Uva11496 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(!s.equals("0")){
			int n=Integer.parseInt(s);
			int []a=new int [n+2];
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			for(int i=1;i<=n;i++)
				a[i]=Integer.parseInt(ns.nextToken());
			int res=0;
			boolean big=false;boolean sml=false;
			a[0]=a[n];
			a[n+1]=a[1];
			//out.println(Arrays.toString(a));
			if(a[1]>a[0])
				sml=true;
			else
				big=true;
			for(int i=0;i<n+1;i++)
				if(sml){
					if(a[i+1]<a[i]){
					res++;
					sml=false;big=true;
					}
				}else{
					if(a[i+1]>a[i]){
						res++;
						sml=true;big=false;
						}
				}
				
			
			out.println(res);
			s=bf.readLine();
		}
		out.close();
	}

}
