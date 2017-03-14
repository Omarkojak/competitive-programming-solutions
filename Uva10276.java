import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Uva10276 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int n=Integer.parseInt(bf.readLine());
			int []pegs=new int [n];
			int empty=n;
			boolean flag=true;
			int i=1;
			while(flag){
				boolean k=false;
				for(int j=0;j<n&&!k;j++)
					if(pegs[j]==0){
						pegs[j]=i;
						k=true;
						}else{
							int sum=pegs[j]+i;
							int sqr=(int)Math.sqrt(sum);
							if(sqr*sqr==sum){
								pegs[j]=i;
								k=true;
							}
						}
							
				if(k)
					i++;
				else
					break;
			}
			out.println(i-1);
		}
		out.close();
	}

}
