package questions;

public class excelColumnToNumber {

    public excelColumnToNumber(){
        System.out.println(titleToNumber("AA"));
    }


    public int titleToNumber(String columnTitle) {
        int titleNum = 0;
        for(int i = columnTitle.length()-1 ; i >= 0 ; i --){
            titleNum += (Math.pow(26,(columnTitle.length()-1-i))*(columnTitle.charAt(i) - 64));
        }
char z = '9';
//Character.getNumericValue()
        return titleNum;
    }
}
