package other.my_handler;

/**
 * Created by Yif on 6/30/2018.
 */
public interface IMessageQueue {
    Message next() throws InterruptedException;

    void enqueueMessage(Message message) throws InterruptedException;

    void quit(boolean safe);
}
