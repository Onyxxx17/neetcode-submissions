class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Set<String> seen = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            } else{
                map.put(nums[i], 1);
            }
        }

        //For each index, find two sum i guess
        for(int i = 0; i < nums.length; i++){
            int target = 0 - nums[i];
            for(int j = i+1; j < nums.length; j++){
                    int need = target - nums[j];
                    if(map.containsKey(need)){
                        if(nums[i] == need && map.get(need) < 2) continue;
                        if(nums[j] == need && map.get(need) < 2) continue;
                        if(nums[i] == nums[j] && nums[i] == need && nums[j] == need && map.get(need) < 3) continue;
                        int a = nums[i], b = nums[j], c = need;
                        // Ensure consistent ordering for key
                        int min = Math.min(a, Math.min(b, c));
                        int max = Math.max(a, Math.max(b, c));
                        int mid = a + b + c - min - max;
                        String key = min + "," + mid + "," + max;

                        if(!seen.contains(key)){
                            seen.add(key);
                            List<Integer> triplet = Arrays.asList(a, b, c);
                            set.add(triplet);
                        }
                    }
            }
        }

        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}
