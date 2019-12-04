package QueueExceptions;

/**
 *
 * @author nifemi
 * similar to the map exception file, this along with the QueueFullException file handle queue exceptions
 */
public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException(String message){
        super(message);
    }

    public QueueEmptyException()
    {
    }
}
