package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Uva11933 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n=Integer.parseInt(bf.readLine());
		while(n!=0){
			int a=0;int b=0;boolean fa=true; boolean fb=false;
			for(int i=0;i<32;i++)
				if((n&(1<<i))!=0)
					if(fa){
						a|=1<<i;
						fa=false;fb=true;
					}else{
						b|=1<<i;
						fa=true;fb=false;
					}
		
			
			out.printf("%d %d\n",a,b);
			n=Integer.parseInt(bf.readLine());
		}
		out.flush();
		out.close();
	}

}
