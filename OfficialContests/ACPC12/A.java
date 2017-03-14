package OfficialContests.ACPC12;

import java.util.PriorityQueue;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int candi = in.nextInt();
		int voters = in.nextInt();
		int[][] prefs = new int[voters][candi];
		int round1[] = new int[candi];
		for (int i = 0; i < voters; i++) {
			for (int j = 0; j < candi; j++) {
				int x = in.nextInt()-1;
				if (j == 0)
					round1[x]++;
				prefs[i][j] = x;
			}
		}

		int win = voters / 2 + 1;
		PriorityQueue<obj> pq = new PriorityQueue<>();
		int winner = -1;
		for (int i = 0; i < candi; i++)
		{
			pq.add(new obj(round1[i], i));
			if (round1[i] >= win)
				winner = i;
		}
		if (winner != -1) {
			System.out.println((winner + 1) + " " + 1);
			return;
		}
		
		obj o1 = pq.poll();
		obj o2 = pq.poll();

		int v1 = 0; int v2 = 0;
		for(int i=0;i<voters;i++)
			for(int j=0;j<candi;j++)
			{
				if(prefs[i][j] == o1.candi)
				{
					v1++;
					break;
				}
				if(prefs[i][j] == o2.candi)
				{
					v2++;
					break;
				}
			}
		//System.err.println(v1+" " +v2);
		if(v1 > v2)
			System.out.println((o1.candi+1) + " " +2);
		else
			System.out.println((o2.candi+1) + " " +2);

		

	}

	static class obj implements Comparable<obj> {
		int votes;
		int candi;

		obj(int a, int b) {
			votes = a;
			candi = b;
		}

		public int compareTo(obj o)
		{
			if(votes != o.votes)
				return o.votes - votes;
			return candi - o.candi;
		}

	}

}
