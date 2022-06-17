package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class pascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        int prevRowIndex = -1;

        for(int i = 0; i < numRows ; i++){
            if(prevRowIndex == -1){
                list.add(Arrays.asList(1));
                prevRowIndex++;
                continue;
            }
            List<Integer> temp = new LinkedList<>();
            for(int k = 0 ; k < i+1 ; k++){
                int tl = k-1;
                int tr = k;
                int tlv = 0;
                int trv = 0;
                if(tl >= 0){
                    tlv = list.get(prevRowIndex).get(tl);
                }
                if(tr < list.get(prevRowIndex).size()){
                    trv = list.get(prevRowIndex).get(tr);
                }
                temp.add(tlv+trv);
            }
            prevRowIndex++;
            list.add(temp);
        }

        return list;

    }
}
