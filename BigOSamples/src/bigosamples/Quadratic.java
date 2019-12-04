package bigosamples;

/**
 *
 * @author michelle
 */
public class Quadratic {
    
    public static boolean containsDuplicates(String [] values){
        for(int outer = 0; outer < values.length; outer++){
           for(int inner = outer+1; inner < values.length; inner++){
               if(values[outer].equals(values[inner]))
                   return true;
           } 
        }
        return false;
    }

    public static void main(String[] args) 
    {
        String [] names = {"Helen", "Anne", "Danial", "Damian", "Aoife", "Helen", "Robin", "Barney", "Patrick"};
        if(containsDuplicates(names)){
            System.out.println("The array contains duplicates");
        }
        else{
            System.out.println("The array does not contain duplicates");
        }
            
    }

}
