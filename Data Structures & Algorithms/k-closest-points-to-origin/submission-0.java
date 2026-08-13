class Solution {
    public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<double[]> minHeap = new PriorityQueue<>(Comparator.comparing(a-> a[0]));

            for(int[] point: points){
                double distance = Math.sqrt((point[0] * point[0]) + point[1] * point[1]);
                minHeap.offer(new double[]{distance,point[0],point[1]});
            }

            int[][] res = new int[k][2];
            for(int i = 0; i < k; i++){
                double[] closest = minHeap.poll();
                res[i] = new int[]{(int)closest[1],(int)closest[2]};
            }

            return res;
    }
}
