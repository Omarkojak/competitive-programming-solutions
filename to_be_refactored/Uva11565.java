package to_be_refactored;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva11565 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine());
		while(t-->0){
			StringTokenizer ns=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(ns.nextToken());
			int b=Integer.parseInt(ns.nextToken());
			int c=Integer.parseInt(ns.nextToken());
			boolean sol=false;
			for (int x = -22; x <= 22 && !sol; x++) 
				if (x * x <= c)
				for (int y = -100; y <= 100 && !sol; y++) if (y != x && x * x + y * y <= c) 
					for (int z = -100; z <= 100 && !sol; z++)
						if (z != x && z != y &&x + y + z == a && x * y * z == b && x * x + y * y + z * z == c) {
							System.out.println(x+" "+y+" "+z); 
							sol = true; }
				
			if(!sol)
				System.out.println("No solution.");
			
		}
	
	}

}
