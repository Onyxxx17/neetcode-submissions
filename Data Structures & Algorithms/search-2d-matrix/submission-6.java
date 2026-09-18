class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int fR = 0;
        int lR = matrix.length - 1;
        int tC = matrix[0].length - 1;
        int cR = 0;
        //Find the correct row
        while(fR <= lR){
            cR = fR + (lR - fR) / 2;
            if(target < matrix[cR][0]){
                lR = cR - 1;
            } else if(target > matrix[cR][tC]){
                fR = cR + 1;
            } else{
                break;
            }
        }

        //Now find in that row
        int l = 0;
        int r = matrix[cR].length - 1;
        while(l <= r){
            int m = l + (r - l) / 2;
            if(target < matrix[cR][m]){
                r = m - 1;
            } else if(target > matrix[cR][m]){
                l = m + 1;
            } else{
                return true;
            }
        }

        return false;
    }
}
