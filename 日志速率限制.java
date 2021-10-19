import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

class Pair<Integer, String> {
    public Integer first;
    public String second;

    public Pair(Integer first, String second) {
        this.first = first;
        this.second = second;
    }
}
class Logger {
    private Deque<Pair<String, Integer>> msgQueue;
    private HashSet<String> msgSet;

    /** Initialize your data structure here. */
    public Logger() {
        msgQueue = new LinkedList<Pair<String, Integer>>();
        msgSet = new HashSet<String>();

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        // clean up.
        while (msgQueue.size() > 0) {
            Pair<String, Integer> head = msgQueue.getFirst();
            if (timestamp - head.second >= 10) {
                msgQueue.removeFirst();
                msgSet.remove(head.first);
            } else
                break;
        }

        if (!msgSet.contains(message)) {
            Pair<String, Integer> newEntry = new Pair<String, Integer>(message, timestamp);
            msgQueue.addLast(newEntry);
            msgSet.add(message);
            return true;
        } else
            return false;

    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */