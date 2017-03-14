import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;


public class Uva10152 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			int n=Integer.parseInt(bf.readLine());
			String []before=new String[n];
			String []after=new String [n];
			TreeMap<String, Integer> m=new TreeMap<String, Integer>();
			for(int i=0;i<n;i++)
				before[i]=bf.readLine();
			for(int i=0;i<n;i++){
				after[i]=bf.readLine();
				m.put(after[i], i);
			}
			int res[]=new int [n];
			for(int i=0;i<n;i++)
				res[i]=m.get(before[i]);
			ArrayList<Integer>as=new ArrayList<Integer>();
			for(int j=n-1,next=n-1;j>=0;j--)
				if(res[j]!=next)
					as.add(res[j]);
					else
					next--;
			int []r=new int [as.size()];
			for(int i=0;i<as.size();i++)
				r[i]=as.get(i);
			Arrays.sort(r);
			for(int i=as.size()-1;i>=0;i--)
				out.println(after[r[i]]);
			out.println();
			//out.println(as.toString());
			
		}
		
		out.close();
	}

}
/*
2
3
Yertle
Duke of Earl
Sir Lancelot
Duke of Earl
Yertle
Sir Lancelot
9
Yertle
Duke of Earl
Sir Lancelot
Elizabeth Windsor
Michael Eisner
Richard M. Nixon
Mr. Rogers
Ford Perfect
Mack
Yertle
Richard M. Nixon
Sir Lancelot
Duke of Earl
Elizabeth Windsor
Michael Eisner
Mr. Rogers
Ford Perfect
Mack*/