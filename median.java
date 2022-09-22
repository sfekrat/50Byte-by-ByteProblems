
public class median {
	// Finding median of two sorted arrays in O(log(n+m))
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	double res;
    	// Performing the binary search on the smallest array.
    	if (nums1.length <= nums2.length) {
    		res = binarySearch(nums1, nums2);
    	} else {
    		res = binarySearch(nums2, nums1);    	}
    	return res;
    }  
    public static double binarySearch(int[] nums1, int[] nums2) {
    	double res = 0.0;
    	int x = nums1.length;
    	int y = nums2.length;
    	int start = 0;
    	int end = x;
    	
    	while (start <= end) {
    		int partitionX = (start + end) /2;
    		int partitionY = (x + y + 1 )/2 - partitionX;
    		
    		int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
    		int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
    		
    		int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
    		int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
    		
    		if(maxLeftX <= minRightY && maxLeftY <= minRightX){
        		if((x + y) % 2 == 0) {
        			return (double) (Math.max(maxLeftX, maxLeftY) +
        					Math.min(minRightX, minRightY))/2;
        		} else {
        			return (double) Math.max(maxLeftX, maxLeftY);
        		}
    		} else if(maxLeftX > minRightY){
    			end = partitionX - 1;
    		} else {
    			start = partitionX + 1;
    		}
    	}
    	return res;
    }
	public static void main(String[] args) {
		int[] nums2 = {1,2};
		int[] nums1 = {3,4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
		
	}
}
