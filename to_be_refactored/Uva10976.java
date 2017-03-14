package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Uva10976 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		while(s!=null){
			int k=Integer.parseInt(s);
			boolean flag=true;
			ArrayList<Integer> ax=new ArrayList<Integer>();
			ArrayList<Integer> ay=new ArrayList<Integer>();
			for(int x=k+1;x<=k*2;x++){
				int up=k*x;
				int dow=x-k;
				int y=up/dow;
				if(up%dow==0){
				ax.add(x);ay.add(y);
				}
			}
			out.println(ax.size());
			for(int i=0;i<ax.size();i++)
				out.printf("1/%d = 1/%d + 1/%d\n", k,ay.get(i),ax.get(i));
			
			s=bf.readLine();
		}
			out.close();
	}

}
