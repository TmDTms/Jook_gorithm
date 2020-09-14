package silver;
import java.util.Scanner;

public class S1037 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for(int i=0;i < n;i++) {
			a[i] = scan.nextInt();
		}
		int min = a[0], max = a[n-1];
		for(int i = 0;i < n;i++) {
			if(a[i] > max)
				max = a[i];
			if(a[i] < min)
				min = a[i];
		}
		System.out.println(max*min);
	}

}
