package questions;

public class gasStation {

    public gasStation(){
        canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3});
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        for(int i = 0 ; i < gas.length ; i++){
            int currentGas = gas[i];
            int carIndex = i;
            int length = 1;
            while((currentGas = currentGas - cost[carIndex]) > 0 ){
                carIndex++;
                length++;
                if(carIndex == gas.length){
                    carIndex = 0;
                }
                currentGas += gas[carIndex];
            }
            if(length == gas.length){
                return i;
            }

        }


        return -1;
    }
}
