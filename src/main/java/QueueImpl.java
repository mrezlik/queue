public class QueueImpl<T> implements Queue<T> {

    private T[] array;
    private int last;

    @SuppressWarnings("unchecked")
    public QueueImpl(){
        int DEFAULT_SIZE_OF_ARRAY = 2;
        this.array = (T[]) new Object[DEFAULT_SIZE_OF_ARRAY];
        this.last = -1;
    }

    public void enqueue(T element) {
        if(isFull()) {
            resize();
        }
        this.array[++last] = element;

    }

    public T dequeue() {
        if(isEmpty()){
            throw new EmptyQueueException("Queue is empty!");
        }
        T firstElement = array[0];
        changeOrderOfQueue();
        return firstElement;
    }

    @Override
    public int size() {
        return array.length;
    }

    @SuppressWarnings("unchecked")
    private void changeOrderOfQueue() {
        T[] secondArray = (T[]) new Object[array.length];
        for(int i = 0; i<array.length-1; i++){
            secondArray[i] = array[i+1];
        }
        this.array = (T[]) new Object[array.length];
        for(int i = 0; i<secondArray.length-1; i++){
            array[i] = secondArray[i];
        }
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] secondArray = (T[]) new Object[array.length*2]; //TODO: what if array size was bigger than int?
        for(int i = 0; i<array.length; i++){
            secondArray[i] = array[i];
        }
        this.array = (T[]) new Object[array.length*2];
        for(int i = 0; i<secondArray.length-1; i++){
            array[i] = secondArray[i];
        }

    }

    private boolean isEmpty(){
        return last == -1;
    }

    private boolean isFull(){
        return last == array.length-1;
    }
}
