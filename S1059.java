package silver;

import java.util.Scanner;

public class S1059 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int l = scan.nextInt();
		int[] lucky = new int[l];
		for (int i = 0; i < l; i++) {
			lucky[i] = scan.nextInt();
		}
		int n = scan.nextInt();
		sorting(lucky, 0, l - 1);
		int sol = unLucky(lucky, l, n);
		System.out.println(sol);
		scan.close();
	}

	static int unLucky(int[] arr, int l, int n) {
		int count = 0;
		int least = 1, large = 0;
		for(int i = 0;i < l;i++) {
			if(n <= arr[i]) {
				large = arr[i];
				break;
			}
			least = arr[i]+1;
		}
		if(large == 0)
			large = arr[l];
		for(int i = least; i< large; i++) {
			for(int j = i+1;j < large;j++) {
				if(i <= n && n <= j)
					count++;
			}
		}
		return count;
	}

	static void sorting(int[] arr, int low, int high) {
		if (low >= high)
			return;
		int mid = (low + high) / 2;

		sorting(arr, low, mid);
		sorting(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	static void merge(int[] arr, int low, int mid, int high) {
		int left = low;
		int right = mid + 1;
		int[] temp = new int[(high - low) + 1];
		int index = 0;

		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right])
				temp[index++] = arr[left++];
			else
				temp[index++] = arr[right++];
		}
		if (left > mid) {
			for (int i = right; i <= high; i++) {
				temp[index++] = arr[i];
			}
		} else {
			for (int i = left; i <= mid; i++) {
				temp[index++] = arr[i];
			}
		}
		for (int i = low; i <= high; i++) {
			arr[i] = temp[i - low];
		}

	}

}
