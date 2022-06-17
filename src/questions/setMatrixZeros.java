package questions;

import java.io.LineNumberReader;
import java.util.HashSet;
import java.util.LinkedList;

public class setMatrixZeros {

    public setMatrixZeros(){
        setZeroes(new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}});
    }

    public void setZeroes(int[][] matrix) {
        LinkedList<int[]> zeros = new LinkedList<>();
        for(int rows = 0 ; rows < matrix.length ; rows++){
            for(int columns = 0 ; columns < matrix[0].length ; columns++){
                if(matrix[rows][columns] == 0 ){
                    zeros.add(new int[]{rows,columns});
                }
            }
        }
        for(int[] k : zeros){
            setRowColToZero(k[0],k[1], matrix);
        }
        System.out.println(matrix);
    }

    public void setRowColToZero(int row, int col, int[][] matrix){
        int[][] vectors = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};

        for(int i = 0 ; i < vectors.length; i++){
            int x = row + vectors[i][0];
            int y  = col + vectors[i][1];

            while(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length){
                if(matrix[x][y] != 0){
                    matrix[x][y] = 0;
//                    seen.add(""+x+y);
                }

                x += vectors[i][0];
                y += vectors[i][1];
            }
        }
    }
}
