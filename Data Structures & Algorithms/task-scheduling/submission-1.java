class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char task: tasks){
            count[task-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int cnt: count){
            if(cnt > 0){
                maxHeap.add(cnt);
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;

            if(!q.isEmpty() && q.peek()[1] <= time){
                maxHeap.add(q.poll()[0]);
            }

            if(!maxHeap.isEmpty()){
                int max = maxHeap.poll();

                if(max > 1){
                int[] freqWithAvailableTime = new int[]{max - 1,time+n+1};
                q.add(freqWithAvailableTime); 
                }
            }

        }

        return time;

    }
}
