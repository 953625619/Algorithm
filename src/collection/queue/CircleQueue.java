package collection.queue;

/**
 * 循环队列
 * @param <T>
 */
public class CircleQueue<T> {

    private T[] arr;

    private int front,rear;

    public CircleQueue(int len){
        arr = (T[])new Object[len];
    }

    //入队列
    public void enQueue(T ele) throws ArrayIndexOutOfBoundsException{
        if(!isFull())
        {
            arr[rear] = ele;
            rear = (rear + 1) % arr.length;
        }
        else
            throw new ArrayIndexOutOfBoundsException("队列满了");
    }

    //出队列
    public T deQueue(){
        if(!isEmpty())
        {
            T element =  arr[front];
            front = (front + 1) % arr.length;
            return element;
        }
        return null;
    }

    //队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //队列是否为满
    public boolean isFull(){
        return (rear + 1) % arr.length == front;
    }

    //获得队列容量
    public int size(){
        if(rear > front)
            return rear - front;
        return (rear - front + arr.length) % arr.length;
    }


    public static void main(String[] args) {
        CircleQueue<String> queue = new CircleQueue<>(5);
        System.out.printf("队列是否为空:%s，队列的大小为：%d\n",queue.isEmpty(),queue.size());
        queue.enQueue("H");
        queue.enQueue("E");
        queue.enQueue("L");
        queue.enQueue("L");
//        queue.enQueue("O");
        System.out.printf("\n队列是否满:%s，队列的大小为：%d\n",queue.isFull(),queue.size());
        int len = queue.size();
        for (int i = 0; i < len; i++) {
            System.out.printf(queue.deQueue()+" ");
        }
        System.out.printf("\n队列是否为空:%s，队列的大小为：%d\n",queue.isEmpty(),queue.size());
    }
}
