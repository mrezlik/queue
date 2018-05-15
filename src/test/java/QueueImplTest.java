import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {

    @Test
    void testQueueCreation(){
        Queue queue = new QueueImpl();
    }


    @Test
    void testEnqueue(){
        Queue<Integer> queue = new QueueImpl<>();
        queue.enqueue(10);
        assertSame(10, queue.dequeue());
    }

    @Test
    void testManyEnqueue(){
        Queue<Integer> queue = new QueueImpl<>();
        queue.enqueue(10);
        queue.enqueue(20);
        assertSame(10, queue.dequeue());
        assertSame(20, queue.dequeue());
    }

}