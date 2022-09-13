import java.util.Arrays;
import java.util.Scanner;

public class AGGRCOW_Aggressive_cows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
			int noD=sc.nextInt();
			int noC=sc.nextInt();
			
			int[] dist = new int[noD];
			for (int i = 0; i < dist.length; i++) {
				dist[i]=sc.nextInt();
			}
			Arrays.sort(dist);
			
			countMaximumMinDistance(dist,noD,noC);
			t--;
		}

	}

	private static void countMaximumMinDistance(int[] dist, int noD, int noC) {
		// TODO Auto-generated method stub
		int high=dist[dist.length-1]-dist[0];
		int low=0;
		int ans=0;						// holds the last updated and the final ans (maximum min dist bet cows
		
		while(low<=high)
		{
			int mid = (high+low)/2;
			if(doCowsFit(noC,mid,dist)==true)
			{
				ans=mid;
				low=mid+1;
			}
			else
			{
				high=mid-1;
			}
		}
		
		System.out.println(ans);
	}

	private static boolean doCowsFit(int noC, int mid, int[] dist) {
		// TODO Auto-generated method stub
		int cow=1;
		int pos=0;
		
		for(int i=pos+1;i<dist.length;i++)
		{
			if(dist[i]-dist[pos]>=mid)
			{
				cow++;
				pos=i;
			}
			
			if(noC==cow)
				return true;
		}
		
		
		return false;
	}

}
