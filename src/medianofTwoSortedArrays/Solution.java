package medianofTwoSortedArrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int sumLength = nums1.length + nums2.length;

        boolean odd = (sumLength & 1) == 1;

        int mid2 = ((nums1.length + nums2.length) >> 1);

        int mid1 = odd ? mid2 : mid2 - 1;

        Integer mid1Value = null, mid2Value = null, index = 0, num2start = 0;

        if (nums1.length == 0) {
            double r = nums2[mid1] + nums2[mid2];
            return r/2;
        }

        if (nums2.length == 0) {
            double r = nums1[mid1] + nums1[mid2];
            return r/2;
        }
        n1:
        for (int value : nums1) {
            n2:
            for (; num2start < nums2.length; ) {
                if (nums2[num2start] <= value) {
                    if (index == mid1) {
                        mid1Value = nums2[num2start];
                    } else if (index == mid2) {
                        mid2Value = nums2[num2start];
                        break n1;
                    }
                    index++;
                    num2start++;
                } else {
                    break n2;
                }
            }


            if (index == mid1) {
                mid1Value = value;
            } else if (index == mid2) {
                mid2Value = value;
                break n1;
            }
            index++;

        }

        if (mid1Value == null) {
            mid1Value = nums2[mid1 - nums1.length];
            mid2Value = nums2[mid1 - nums1.length + 1];
        }

        if (odd) {
            return mid1Value;
        }
        mid2Value = (null == mid2Value) ? nums2[num2start] : mid2Value;
        double result = mid1Value + mid2Value;
        return result / 2;
    }

}
