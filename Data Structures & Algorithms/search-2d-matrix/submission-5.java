class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Find the correct row first
        int firstRow = 0;
        int lastRow = matrix.length - 1;
        int correctRow = 0;
        int totalColumns = matrix[0].length - 1;

        while(firstRow <= lastRow){
            //Compare with the last integer in each row
            correctRow= firstRow + (lastRow - firstRow) / 2;
            if(target > matrix[correctRow][totalColumns]){
                firstRow = correctRow + 1;
            } else if(target < matrix[correctRow][0]){
                lastRow = correctRow - 1;
            } else{
                break;
            }
        }

        System.out.println(correctRow);

        //Now find the integer in the correct row
        int first = 0;
        int last = totalColumns;

        while(first <= last){
            int mid = first + (last - first) / 2;
            int currNum = matrix[correctRow][mid];
            if(target == currNum) {
                return true;
            } else if(target > currNum){
                first = mid + 1;
            } else{
                last = mid - 1;
            }
        }

        return false;
    }
}
