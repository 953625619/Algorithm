package collection.stack;

import collection.LinkNode;

/**
 * 链栈
 * @param <T>
 */
public class LinkedStack<T> {
    //头结点
    private LinkNode<T> head;
    //链表长度
    private int size;

    public LinkedStack() {
        head = new LinkNode<>();
        size = 0;
    }

    public LinkedStack(T ele){
        head = new LinkNode<>();
        LinkNode<T> node = new LinkNode<>(ele);
        head.setNext(node);
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
    public void push(T ele){
        LinkNode<T> temp = new LinkNode<>(ele);
        LinkNode<T> node = head.getNext();
        if(node!=null)
            temp.setNext(node);
        head.setNext(temp);
        size++;
    }

    //出栈
    public LinkNode<T> pop(){
        LinkNode<T> node = head.getNext();
        if(node != null)
        {
            LinkNode<T> temp = node.getNext();
            head.setNext(temp);
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
        LinkedStack<String> stack = new LinkedStack<>();
        System.out.printf("栈是否为空:%s，栈的大小为：%d\n",stack.isEmpty(),stack.getSize());
        stack.push("H");System.out.print(stack.peek().getData());
        stack.push("E");System.out.print(stack.peek().getData());
        stack.push("L");System.out.print(stack.peek().getData());
        stack.push("L");System.out.print(stack.peek().getData());
        stack.push("O");System.out.print(stack.peek().getData());
        System.out.printf("\n栈是否为空:%s，栈的大小为：%d\n",stack.isEmpty(),stack.getSize());
        int len = stack.getSize();
        for (int i = 0; i < len; i++) {
            System.out.printf("%s",stack.peek().getData());
            stack.pop();
        }
        System.out.printf("\n栈是否为空:%s，栈的大小为：%d\n",stack.isEmpty(),stack.getSize());
    }
}
