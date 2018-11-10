package other.my_handler;

/**
 * Created by Yif on 6/30/2018.
 */
public class Message {
    Handler target;
    Runnable callBack;
    Message next;
    private int what;
    private String msg;

    public Message(int what, String msg, Runnable callBack) {
        this.what = what;
        this.msg = msg;
        this.callBack = callBack;
    }

    public Message() {
    }

    public Message(int what, String msg) {
        this.what = what;
        this.msg = msg;
    }

    public int getWhat() {
        return what;
    }

    public void setWhat(int what) {
        this.what = what;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Runnable getCallBack() {
        return callBack;
    }

    void recycleUnchecked() {
        target = null;
        callBack = null;
        next = null;
        what = 0;
        msg = null;
    }
}
