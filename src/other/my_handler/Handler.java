package other.my_handler;

/**
 * Created by Yif on 6/30/2018.
 */
public abstract class Handler {
    private IMessageQueue messageQueue;

    public Handler(Looper looper) {
        messageQueue = looper.messageQueue;
    }

    public Handler() {
        messageQueue = Looper.myLooper().messageQueue;
    }

    public void sendMessage(Message message) {
        message.target = this;
        try {
            messageQueue.enqueueMessage(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void handleMessage(Message message);
}
