package other.my_handler;

/**
 * Created by Yif on 6/30/2018.
 */
public abstract class Handler {
    private CallBack mCallback;
    private IMessageQueue messageQueue;

    public Handler(Looper looper) {
        this.mCallback = null;
        messageQueue = looper.messageQueue;
    }

    public Handler() {
        this.mCallback = null;
        messageQueue = Looper.myLooper().messageQueue;
    }

    public Handler(CallBack mCallback) {
        this.mCallback = mCallback;
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

    public void dispatchMessage(Message message) {
        if (message.callBack != null) {
            message.callBack.run();
            return;
        }
        if (mCallback != null) {
            if (mCallback.handleMessage(message))
                return;
        }
        handleMessage(message);
    }

    public interface CallBack {
        boolean handleMessage(Message message);
    }
}
