class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        //Find row
        int row = 0;

        int totalRows = matrix.length;

        for(int i = 0; i < totalRows; i++){
            int lastColumn = matrix[i].length - 1;
            if(target > matrix[i][lastColumn]){
                row++;
            }
        }

        if(row > matrix.length - 1) return false;
        int l = 0;
        int r = matrix[row].length - 1;

        while(l <= r){
            int m = l+ (r - l) / 2;
            if(target == matrix[row][m]){
                return true;
            } else if(target > matrix[row][m]){
                l = m + 1;
            } else{
                r = m - 1;
            }
        }
        return false;
        
    }
}
