package bigosamples;

/**
 *
 * @author michelle
 */
public class Exponential {

    public static int fibonacci(int num){
        System.out.println("Running fibonacci method");
        if(num <=1 ){
            return num;
        }
        else{
            return fibonacci(num-1) + fibonacci(num-2);
        }
    }
    public static void main(String[] args) 
    {
        System.out.println(fibonacci(4));
    }

}
