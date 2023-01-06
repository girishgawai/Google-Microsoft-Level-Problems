package dp;

import java.util.Arrays;
import java.util.Scanner;

public class EDIST_Edit_distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0)
		{
			String str1 = sc.next();
			String str2 = sc.next();
			
//			int minOp_toTransfroms1_s2 = minimumEdits(str1,str2,0,0);	// ek 0 str1 ka iterator index dusra 0 str ka
			
			// DP --> Top Down
			int[][] dp = new int[str1.length()][str2.length()];
			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], -1);								// Array is defaulty filled with -1 because 0 can be the ans(min no of ops)
			}
			int minOp_toTransfroms1_s2 = minimumEdits(str1,str2,0,0,dp);	// ek 0 str1 ka iterator index dusra 0 str ka
			
//			// DP --> Bottom UP
//			int minOp_toTransfroms1_s2 = minimumEdits(str1,str2);
			System.out.println(minOp_toTransfroms1_s2);
			t--;
		}

	}

	// DP --> Top Down
	private static int minimumEdits(String str1, String str2, int i, int j, int[][] dp) {
		// TODO Auto-generated method stub
		if(i==str1.length())		// agr phli str1 khtm ho gyi and dusri bchi hue hi hai toh bchi hue str2 ki len bhej dege whi op nums
		{										// is minimum num of edits rhege.. bchi hue str ki len means bche hue Operations jo lgege
			return str2.length()-j;
		}
		
		if(j==str2.length())		// agr dusri str2 khtm ho gyi and phli bchi hue hi hai toh bchi hue str1 ki len bhej dege whi op nums
		{										// is minimum num of edits rhege.. bchi hue str ki len means bche hue Operations jo lgege
			return str1.length()-i;
		}
		
		if(str1.charAt(i)==str2.charAt(j))					// agr dono ke chars match ho gye toh koi v operation use hi nhi hua
		{																// so directly next characters pe switch krege dono Strings me
			return minimumEdits(str1, str2, i+1, j+1, dp);
		}
		
		if(dp[i][j]!=-1)				// using the yaad kri hue value-ans
			return dp[i][j];				
		
		int Delete = minimumEdits(str1, str2, i+1, j, dp);
		int Insert = minimumEdits(str1, str2, i, j+1, dp);
		int Replace = minimumEdits(str1, str2, i+1, j+1, dp);
		
		int ans = Math.min(Delete, Math.min(Insert, Replace)) + 1;			// current op toh chla hai usko pkdne k liye +1
		
		
		return dp[i][j] = ans;					// memorizing the ans
	}

	// DP --> Bottom Up
//	private static int minimumEdits(String str1, String str2) {
//		
//	}
	
	private static int minimumEdits(String str1, String str2, int i, int j) {
		// TODO Auto-generated method stub
		if(i==str1.length())		// agr phli str1 khtm ho gyi and dusri bchi hue hi hai toh bchi hue str2 ki len bhej dege whi op nums
		{										// is minimum num of edits rhege.. bchi hue str ki len means bche hue Operations jo lgege
			return str2.length()-j;
		}
		
		if(j==str2.length())		// agr dusri str2 khtm ho gyi and phli bchi hue hi hai toh bchi hue str1 ki len bhej dege whi op nums
		{										// is minimum num of edits rhege.. bchi hue str ki len means bche hue Operations jo lgege
			return str1.length()-i;
		}
		
		if(str1.charAt(i)==str2.charAt(j))					// agr dono ke chars match ho gye toh koi v operation use hi nhi hua
		{																// so directly next characters pe switch krege dono Strings me
			return minimumEdits(str1, str2, i+1, j+1);
		}
		
		
		int Delete = minimumEdits(str1, str2, i+1, j);
		int Insert = minimumEdits(str1, str2, i, j+1);
		int Replace = minimumEdits(str1, str2, i+1, j+1);
		
		int ans = Math.min(Delete, Math.min(Insert, Replace)) + 1;			// current op toh chla hai usko pkdne k liye +1
		
		
		return ans;
	}
}
