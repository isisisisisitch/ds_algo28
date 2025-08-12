package ca.bytetube._04_stack;

public class Stack<E> {
    private ArrayList<E> arrayList;

    public Stack() {
        this.arrayList = new ArrayList<>();
    }

    /// / Number of elements
    public int size() {
        return arrayList.size();
    }

    // Is stack empty Top of stack
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }


    public void push(E element) {
        arrayList.add(element);
    }


    public E pop() {
        return arrayList.remove(arrayList.size - 1);
    }

    // Get the top element of the stack
    public E top() {

        return arrayList.get(arrayList.size - 1);
    }

    // Clear all elements in stack
    public void clear() {
        arrayList.clear();
    }
}
