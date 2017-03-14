package to_be_refactored;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;


public class Uva10226 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());bf.readLine();
		StringBuilder sb=new StringBuilder();
		while(t-->0){
			int tokens=0;
			TreeMap<String, Integer>mp=new TreeMap<String, Integer>();
			ArrayList<String>as=new ArrayList<String>();
			String s=bf.readLine();
			while(s!=null&&!s.isEmpty()){
				tokens++;
				if(mp.containsKey(s)){
					int v=mp.get(s);
					mp.put(s, v+1);
				}else{
					mp.put(s, 1);
					as.add(s);
				}
				s=bf.readLine();
			}
			Collections.sort(as);
			for(int i = 0; i < as.size(); i++)
				sb.append(as.get(i)+" "+(new DecimalFormat("0.0000").format(mp.get(as.get(i))*100.0/tokens))+"\n");
			if(t!=0)
				sb.append("\n");
			
		}
		out.print(sb);
		out.close();
	}

}
