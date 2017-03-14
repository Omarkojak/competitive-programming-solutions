package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesA96 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		boolean flag=false;
		String s=bf.readLine();
		int c0=0;
		int c1=0;
		for(int i=0;i<s.length();i++){
			char k=s.charAt(i);
			if(k=='1'){
				c1++;
				c0=0;
			}else{
				c0++;
				c1=0;
				
			}
			
			if(c1==7||c0==7){
				flag=true;
				break;
			}
				
		}
		System.out.println(flag? "YES":"NO");
		
		
	}

}
