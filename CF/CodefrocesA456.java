package CF;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CodefrocesA456 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n=Integer.parseInt(bf.readLine());
		laptopq[] a=new laptopq[n];
		for(int i=0;i<n;i++){
			StringTokenizer ns =new StringTokenizer(bf.readLine());
			a[i]=new laptopq(Integer.parseInt(ns.nextToken()), Integer.parseInt(ns.nextToken()));
		}
		Arrays.sort(a);
		boolean found=false;
		for(int i=0;i<n-1&&!found;i++)
			if(a[i].p<a[i+1].p)
				found=true;
		out.println(found? "Happy Alex":"Poor Alex");
		out.close();
	}

}
class laptopq implements Comparable<laptopq>{
	int p;
	int q;
	laptopq(int p,int q){
		this.p=p;
		this.q=q;
	}
	public int compareTo(laptopq o){
		if(this.q>o.q)
			return -1;
		return 1;
	}
}