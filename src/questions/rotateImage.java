package questions;

public class rotateImage {

    public rotateImage(){
        int [][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(matrix);
    }

    public void rotate(int[][] matrix) {
        //flip elements about diagonal
        int n = matrix[0].length;
        if(n == 1) return;

        for(int col = 1 ; col < n ; col ++){
            int row = col -1;
            for(int  z = col; z < n ; z++){
                System.out.println("row + "+row + "col "+col);
                int temp = matrix[row][z];
                matrix[row][z] = matrix[z][row];
                matrix[z][row] = temp;
            }
        }

        int l = 0;
        int r = n-1;
        while(l < r){
            for(int i = 0 ; i < n ; i++){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;


            }
            l++;
            r--;
        }
    }
}
