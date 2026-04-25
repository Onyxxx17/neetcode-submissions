class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        //Find row
        int fRow = 0;
        int lRow = matrix.length - 1;
        int cRow = 0;
        while(fRow <= lRow){
            cRow = fRow + (lRow - fRow) / 2;
            int tColumns = matrix[cRow].length;
            if(target > matrix[cRow][tColumns - 1]){
                fRow = cRow + 1;
            } else if(target < matrix[cRow][0]){
                lRow = cRow - 1;
            } else{
                break;
            }
        }

        if(fRow > lRow) return false;
        int l = 0;
        int r = matrix[cRow].length - 1;

        while(l <= r){
            int m = l+ (r - l) / 2;
            if(target == matrix[cRow][m]){
                return true;
            } else if(target > matrix[cRow][m]){
                l = m + 1;
            } else{
                r = m - 1;
            }
        }
        return false;
        
    }
}
