package bigosamples;

/**
 *
 * @author michelle
 */
public class Linear {

    public static int linearSearch(int [] numbers, int value){
        for(int pos = 0; pos < numbers.length; pos++){
            if(value == numbers[pos]){
                return pos;
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
        int [] numbers = {1,2,3,4,5,6,7,8,9,10};
        int valueToFind = 4;
        int finalPos = linearSearch(numbers, valueToFind);
        if(finalPos > -1){
            System.out.println("The position of " + valueToFind + " in the array is " + finalPos);
        }
    }
}
