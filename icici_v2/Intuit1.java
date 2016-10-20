package icici_v2;

import java.util.ArrayList;
import java.util.List;

public class Intuit1 {

	public static void main(String[] arrgs) {
		int arr[]={4,1,5,1,1,1,2};
System.out.println(isArray_Balanced(arr));
	}

	static int isArray_Balanced(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int leftSum = 0, rightSum = 0;
		int result = 0;
		boolean lFlag=false,rFlag=false;
		if(arr[left]>arr[right]){
			leftSum=arr[left];
			lFlag=true;
		}
		if(arr[left]<arr[right]){
			rightSum=arr[right];
			rFlag=true;
		}
		while (left < right) {
			if (left == right) {
				if (leftSum == rightSum) {
					result = 1;
					break;
				} else {
					result = 0;
					break;
				}
			}
			if (arr[left] > arr[right]) {
				if(rFlag && right == 0 ){
					right--;
					continue;
				}
				rightSum += arr[right];
				right--;
			} else if (arr[left] < arr[right]) {
				if(lFlag && left == 0 ){
					left++;
					continue;
				}
				leftSum += arr[left];
				left++;
			} else {
				right--;
				left++;
			}
		}
		if (leftSum == rightSum) {
			result = 1;
			
		} else {
			result = 0;
			
		}
		return result;
	}
}
