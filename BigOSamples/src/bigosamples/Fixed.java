package bigosamples;

/**
 *
 * @author michelle
 */
public class Fixed {

    public static boolean hasFirstElement(String [] elements){
        if(elements[0] != null)
            return true;
        else
            return false;
    }
    
    public static void main(String[] args) 
    {
        String [] names = {"Seamus", null, "David", "Ali", "Orla"};
        if(hasFirstElement(names)){
            System.out.println("The array's first element is not null");
        }
        else{
            System.out.println("The array's first element is null");
        }
    }

}
