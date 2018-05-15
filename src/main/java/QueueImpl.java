public class QueueImpl<T> implements Queue<T> {

    private T element;

    public void enqueue(T element) {
        this.element = element;
    }

    public T dequeue() {
        return element;
    }
}
