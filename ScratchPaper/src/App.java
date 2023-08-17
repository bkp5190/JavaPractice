public class App {
    public static void main(String[] args) throws Exception {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.print(FindMax.findMax(nums));
    }

    public class FindMax {

        /**
         * This method should return the largest number in the passed in array.
         * 
         * Constraints:
         * 1 <= nums.length <= 100
         * -10000 <= nums[i] <= 10000
         * 
         * @param nums An array containing integers.
         * @return The largest number in nums.
         */
        public static int findMax(int[] nums) {
            // Write your solution here.
            int maximum = (int) Float.NEGATIVE_INFINITY;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= maximum) {
                    maximum = nums[i];
                }
            }
            return maximum;
        }
    }
}
