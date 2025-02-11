package Practice.BinarySearch;

public class Searcha2DMatrix {
    // https://leetcode.com/problems/search-a-2d-matrix/
    public boolean searchMatrix(int[][] matrix, int target) {
        int up = 0;
        int down = matrix.length-1;
        int lastCol = matrix[0].length-1;
        while( up <= down){
            int mid = (up+down)/2;
            if(matrix[mid][lastCol] == target){
                return true;
            }else if( matrix[mid][lastCol] < target){
                up = mid+1;
            }else{
                down = mid-1;
            }
        }
        // now up has insertion position
        int insertionRowPos = up;

        if(insertionRowPos == -1) insertionRowPos = 0;
        if(insertionRowPos == matrix.length) return false;
        if( matrix[insertionRowPos][0] > target) return false;

        int left = 0;
        int right = lastCol;
        while( left <= right){
            int mid = (left+right)/2;
            if( matrix[insertionRowPos][mid] == target){
                return true;
            }else if( matrix[insertionRowPos][mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
