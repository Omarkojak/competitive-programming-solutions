package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CodeforcesA471 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int []a=new int [10];
		StringTokenizer ns =new StringTokenizer(bf.readLine());
		int diff=0;boolean flaga=true;
		for(int i=0;i<6;i++){
			int x=Integer.parseInt(ns.nextToken());
			if(a[x]==0)
				diff++;
			a[x]++;
			if(a[x]==4) flaga=false;
		}
		if(diff>3 ||flaga)
			out.println("Alien");
		else{
			boolean flage=false; 
			for(int i=1;i<10;i++)
				if(a[i]!=0)
					if(a[i]==6||a[i]==2)
						flage=true;
				
			
			out.println(flage? "Elephant":"Bear");		
			
		}
		out.close();
	}

}
