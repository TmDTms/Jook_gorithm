package silver;

import java.util.Scanner;

public class Sb1010 {
	
	int[][] bridgeData = new int[100][100];
	
	public int bridge(int a, int b) {
		if(a == b || b == 0)
			return 1;
		if(bridgeData[a][b] == 0)
			bridgeData[a][b] = bridge(a-1, b-1) + bridge(a-1, b);
		return bridgeData[a][b];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		int[] n = new int[test];
		int[] m = new int[test];
		int[] result = new int[test];
		Sb1010 sol = new Sb1010();
		
		for(int i = 0; i < test; i++) {
			n[i] = scan.nextInt();
			m[i] = scan.nextInt();
			result[i] = sol.bridge(m[i], n[i]);
		}
		for(int j = 0; j < test; j++) {
			System.out.println(result[j]);
		}
	}

}
