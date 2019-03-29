package collection.queue;

/**
 * 固定容量的队列
 */
public class FixedCapacityQueue<T> {

    private T[] arr;

    private int front, rear;

    public FixedCapacityQueue(int len){
        arr = (T[])new Object[len];
    }

    //入队列
    public void enQueue(T ele) throws ArrayIndexOutOfBoundsException{
        if(rear < arr.length)
            arr[rear++] = ele;
        else
            throw new ArrayIndexOutOfBoundsException("队列满了");
    }

    //出队列
    public T deQueue(){
        if(front != rear)
            return arr[front++];
        return null;
    }

    //队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //队列是否为满
    public boolean isFull(){
        return rear == arr.length;
    }

    //获得队列容量
    public int size(){
        return rear - front;
    }

    public static void main(String[] args) {
        FixedCapacityQueue<String> queue = new FixedCapacityQueue<>(5);
        System.out.printf("队列是否为空:%s，队列的大小为：%d\n",queue.isEmpty(),queue.size());
        queue.enQueue("H");
        queue.enQueue("E");
        queue.enQueue("L");
        queue.enQueue("L");
        queue.enQueue("O");
        System.out.printf("\n队列是否满:%s，队列的大小为：%d\n",queue.isFull(),queue.size());
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            System.out.printf(queue.deQueue()+" ");
        }
        System.out.printf("\n队列是否为空:%s，队列的大小为：%d\n",queue.isEmpty(),queue.size());

    }
}
