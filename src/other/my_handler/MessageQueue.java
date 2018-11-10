package other.my_handler;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Yif on 6/30/2018.
 */
public class MessageQueue implements IMessageQueue {
    private final BlockingDeque<Message> queue;
    private boolean quitting;

    public MessageQueue(int cap) {
        queue = new LinkedBlockingDeque<>(cap);
    }

    @Override
    public Message next() throws InterruptedException {
        return queue.take();
    }

    @Override
    public void enqueueMessage(Message message) {
        queue.push(message);
    }

    @Override
    public void quit(boolean safe) {
        synchronized (this) {
            if (quitting)
                return;
            quitting = true;

            if (safe) removeAllFutureMessagesLocked();
            else removeAllMessagesLocked();
            quitting = false;
        }
    }

    private void removeAllFutureMessagesLocked() {
    }

    private void removeAllMessagesLocked() {
    }
}
