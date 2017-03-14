package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesB552 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		if(n<100){
			if(n<10)
				out.println(n);
			else
				out.println(9+2*(n-9));
		}else{
			long r=9+2*90;
			String kn=n+"";
			String km=100+"";
			long multi=100;
			while(kn.length()!=km.length()){
				multi*=9;
				r+=multi*km.length();
				multi/=9;
				multi*=10;
				km+="0";
			}
			r+=(n-multi+1)*km.length();
			out.println(r);
		}
			out.close();
	}

}
