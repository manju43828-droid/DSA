class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
          HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        // Store nums1 elements
        for (int num : nums1) {
            set1.add(num);
        }

        // Check common elements
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert HashSet to int[]
        int[] result = new int[resultSet.size()];
        int i = 0;

        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}