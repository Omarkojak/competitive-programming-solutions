import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva750 {
	static int[]a;
	static int linec,r1,c1;
	
	public static boolean place(int r, int c) {
		for (int prev = 0; prev < c; prev++)
			if (a[prev] == r || (Math.abs(a[prev] - r) == Math.abs(prev - c)))
				return false;
		return true;
	
	}
	
	public static void eval(int c){
		if(c==8&&a[c1]==r1){
			if(linec>9)
				System.out.print(linec+"      "+(a[0]+1));
			else
				System.out.print(" "+linec+"      "+(a[0]+1));
			
			for(int j=1;j<8;j++)
				System.out.print(" "+(a[j]+1));
			
			linec++;
			System.out.println();
		}
		for(int r=0;r<8;r++)
			if(place(r,c)){
				a[c]=r;
				eval(c+1);
			}
			
		
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));	
		int t=Integer.parseInt(bf.readLine());
		String th=bf.readLine();
		while(t-->0){
			StringTokenizer ns = new StringTokenizer(bf.readLine());
			r1=Integer.parseInt(ns.nextToken())-1;
			c1=Integer.parseInt(ns.nextToken())-1;
			System.out.println("SOLN       COLUMN");
			System.out.println(" #      1 2 3 4 5 6 7 8");
			System.out.println();
			a=new int [8];
			linec=1;
			eval(0);
			
			if(t!=0){
				th=bf.readLine();
				System.out.println();
			}
		}
	}

}
