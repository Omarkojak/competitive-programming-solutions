package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA349 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		int []a=new int [n];
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(ns.nextToken());
		boolean flag=true;
		int t25=0;
		int t50=0;
		
		for(int i=0;i<n&&flag;i++){
			if(a[i]==25)
				t25++;
			if(a[i]==50){
				t50++;
				if(t25==0)
					flag=false;
				else
					t25--;
			}
			if(a[i]==100){
				if(t50==0){
					t25-=3;
					if(t25<0)
						flag=false;
				}else{
					t50--;
					t25--;
					if(t25<0)
						flag=false;
				}
			}
				
				
		}
		out.println(flag?"YES":"NO");
		out.close();
			
	}

}
