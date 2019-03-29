package collection.queue;

import collection.LinkNode;

/**
 * 链队
 */
public class LinkedQueue<T> {
    //头结点
    private LinkNode<T> head;
    //尾结点
    private LinkNode<T> tail;
    //链表长度
    private int size;

    public LinkedQueue() {
        head = new LinkNode<>();
        tail = new LinkNode<>();
        size = 0;
    }

    public LinkedQueue(T ele){
        head = new LinkNode<>();
        tail = new LinkNode<>();
        LinkNode<T> node = new LinkNode<>(ele);
        head.setNext(node);
        tail.setNext(node);
        size = 1;
    }

    //获取链表长度
    public int getSize() {
        return size;
    }

    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //入栈
    public void enQueue(T ele){
        LinkNode<T> temp = new LinkNode<>(ele);
        if(head.getNext() == null)
            head.setNext(temp);
        LinkNode<T> node = tail.getNext();
        if(node!=null)
            node.setNext(temp);
        tail.setNext(temp);
        size++;
    }

    //出栈
    public LinkNode<T> deQueue(){
        LinkNode<T> node = head.getNext();
        if(node != null)
        {
            LinkNode<T> temp = node.getNext();
            head.setNext(temp);
            if(tail.getNext() == node)
                tail.setNext(temp);
            size --;
        }
        return node;
    }

    //获取栈顶元素
    public LinkNode<T> peek(){
        LinkNode<T> node = head.getNext();
        return node;
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        System.out.printf("队列是否为空:%s，队列的大小为：%d\n",queue.isEmpty(),queue.getSize());
        queue.enQueue("H");
        queue.enQueue("E");
        queue.enQueue("L");
        queue.enQueue("L");
        queue.enQueue("O");
        System.out.printf("\n队列是否为空:%s，队列的大小为：%d\n",queue.isEmpty(),queue.getSize());
        int len = queue.getSize();
        for (int i = 0; i < len; i++) {
            System.out.printf(queue.deQueue().getData()+" ");
        }
        System.out.printf("\n队列是否为空:%s，队列的大小为：%d\n",queue.isEmpty(),queue.getSize());

    }
}
