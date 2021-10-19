// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator {
    private Iterator<Integer> iter;
    Integer next;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        next = iter.hasNext()?iter.next():null; // if the init iterator is empty
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.

    public Integer next(){
        Integer tmp = next;
        next = iter.hasNext()?iter.next():null;
        return tmp;
    }

    public boolean hasNext() {
        return next != null;
    }
}
