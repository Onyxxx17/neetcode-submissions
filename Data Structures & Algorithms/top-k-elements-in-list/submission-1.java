class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];

        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else{
                map.put(num,1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int n = 0;
        for(int i = freq.length -1; i > 0; i-- ){
            for(int j : freq[i]){
                result[n++] = j;
                if(n == k){
                    return result;
                }
            }
        }
        return result;
    }
}
