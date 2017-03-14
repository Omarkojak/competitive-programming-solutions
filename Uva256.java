import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Uva256 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String s=bf.readLine();
		ArrayList<String>[] as=new ArrayList[9];
		as[2]=new ArrayList<String>();		
		as[4]=new ArrayList<String>();
		as[6]=new ArrayList<String>();
		as[8]=new ArrayList<String>();

		int [] ns = { 2, 4, 6, 8 };
        int div[] = {  10, 100, 1000, 10000};
        for(int i=0;i<4;i++)
        	for(int j=0;j<div[i]*div[i];j++)
        		 if(((j%div[i])+(j/div[i]))*((j%div[i])+(j/div[i])) == j)
        			 as[ns[i]].add(String.format(new String("%0"+ns[i]+"d"), j));
		while(s!=null&&s.length()!=0){
			int n=Integer.parseInt(s);
			for(int k=0;k<as[n].size();k++)
				out.println(as[n].get(k));
			s=bf.readLine();
		}
		out.close();
	}

	}

