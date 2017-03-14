import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


public class Uva10132 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());bf.readLine();
		while(t-->0){
			//String s=bf.readLine();
			String line;
			ArrayList<String>as=new ArrayList<String>();
			while(bf.ready() && !(line=bf.readLine()).equals("")){
				as.add(line);
				//out.println(s);
			}
			TreeMap<String, Integer>mp=new TreeMap<String, Integer>();
			int max=0;
			String smx="";
			for(int i=0;i<as.size();i++){
				for(int j=i+1;j<as.size();j++){
					String t1=as.get(i)+as.get(j);
					String t2=as.get(j)+as.get(i);
					if(mp.containsKey(t1)){
						int v=mp.get(t1);
						mp.put(t1, v+1);
						if(v+1>max){max=v+1;smx=t1;}
					}else{
						mp.put(t1, 1);
						if(max==0){max=1;smx=t1;}	
					}
					if(mp.containsKey(t2)){
						int v=mp.get(t2);
						mp.put(t2, v+1);
						if(v+1>max){max=v+1;smx=t2;}
					}else{
						mp.put(t2, 1);	
						if(max==0){max=1;smx=t2;}
					}
				}
			}
			
			out.println(smx);
			if(t!=0)
			out.println();
			
	}
			
		
		out.close();
	}
}