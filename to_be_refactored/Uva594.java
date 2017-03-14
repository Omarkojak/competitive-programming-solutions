package to_be_refactored;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Uva594 {

	public static int solve(int n){
		int lowlow = n & 0x000000FF;
		int highhigh = n & 0xFF000000;
		int highlow = n & 0x00FF0000;
		int lowhigh = n & 0x0000FF00;
		return (lowhigh << 8 | highlow >>> 8) | (lowlow << 24 | highhigh >>> 24);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		String s=bf.readLine();
		while(s!=null){
			int n=Integer.parseInt(s);
			out.printf("%d converts to %d\n", n,solve(n));			
			s=bf.readLine();
		}
		out.flush();
		out.close();
	}

}
