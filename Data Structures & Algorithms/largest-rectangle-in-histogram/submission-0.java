class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0;i < heights.length; i++){
            int start = i;

            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int height = stack.peek()[1];
                int index = stack.peek()[0];
                int area = height * (i - index);
                maxArea = Math.max(area,maxArea);
                stack.pop();
                start = index;
            }

            stack.push(new int[]{start, heights[i]});
        }

        for(int[] pairs: stack){
            int index = pairs[0];
            int height = pairs[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}
