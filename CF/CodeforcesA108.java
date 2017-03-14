package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class CodeforcesA108 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		String h=s.substring(0, 2);
		String m=s.substring(3, 5);
		int rev=Integer.parseInt(h.charAt(1)+""+h.charAt(0));
		if(rev>Integer.parseInt(m)&&rev<60)
			out.println(h+":"+h.charAt(1)+""+h.charAt(0));
		
		else{
			int hx=Integer.parseInt(h);
			int mx=Integer.parseInt(m);
			hx++;
			h=hx+"";
			if(hx<10)
				h="0"+hx;
			if(hx>15&&hx<20)
				h="20";
			if(hx==24)
				h="00";
			if(hx>5&&hx<10)
				h="10";
			
			out.println(h+":"+h.charAt(1)+""+h.charAt(0));
			
		}
		out.close();
	}

}
