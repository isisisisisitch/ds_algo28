package ca.bytetube._04_stack;

public interface List<E> {

    // Clear all the elements
    public void clear();

    // Add elements to the index position
    public void add(int index, E element);


    // Returns the element corresponding to the index position
    public E get(int index);


    // Delete elements to the index position

    public E remove(int index);


    // Set the element at the index position
    public E set(int index, E element);

    // Return the index of the element
    public int indexOf(E element);


}
