package questions;
import java.util.*;

public class matrixSpiralTraversal {
    //Function to return a list of integers denoting spiral traversal of matrix.
    public static ArrayList<Integer> spirallyTraverse(int matrix[][], int rows, int columns)
    {
        ArrayList<Integer> values = new ArrayList<>();
        int top = 0;
        int down = rows -1;
        int right = columns-1;
        int left = 0;
        int direction = 0;
        while(left <= right && down >= top){
            if(direction == 0){
                for (int i = left; i <= right; i++) {
                    values.add(matrix[top][i]);
                }
                top++;
            }
            if(direction == 1){
                for (int i = top; i <= down; i++) {
                    values.add(matrix[i][right]);
                }
                right--;
            }

            if(direction == 2){
                for(int i = right; i>=left ; i--){
                    values.add(matrix[down][i]);
                }
               down--;
            }
            if(direction == 3){
                for(int i = down ; i >= top ; i--){
                    values.add(matrix[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;

        }

        return values;
        // code here
    }
}
