package collection.linear;

import collection.LinkNode;

/**
 * 双向链表
 */
public class BidirectionalLinear<T> {
    //头结点
    private LinkNode<T> head;
    //链表长度
    private int size;

    public BidirectionalLinear(T ele){
        head = new LinkNode<>();
        LinkNode<T> node = new LinkNode<>(ele);
        head.setNext(node);
        node.setPrev(head);
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

    //添加结点
    public void add(T ele){
        LinkNode<T> temp = new LinkNode<>(ele);
        LinkNode<T> node = head;
        while (node.getNext()!=null)
            node = node.getNext();
        node.setNext(temp);
        temp.setPrev(node);
        size++;
    }

    //删除结点
    public LinkNode<T> deleteByElement(T ele){
        LinkNode<T> node = head;
        LinkNode<T> temp = null;
        while (node.getNext() != null)
        {
            if(node.getNext().getData() == ele)
            {
                temp = node.getNext();
                temp.getNext().setPrev(node);
                node.setNext(temp.getNext());
                size--;
                break;
            }
            node = node.getNext();
        }
        return temp;
    }

    //删除结点
    public LinkNode<T> deleteByIndex(int index){
        LinkNode<T> node = head;
        LinkNode<T> temp = null;
        if(index > size)
            return null;
        int i = 0;
        while (i++ < index)
            node = node.getNext();
        temp = node.getNext();
        temp.getNext().setPrev(node);
        node.setNext(temp.getNext());
        size--;
        return temp;
    }

    //插入结点
    public void insert(int index,T ele)throws IndexOutOfBoundsException{
        LinkNode<T> node = head;
        LinkNode<T> temp = null;
        LinkNode<T> element = new LinkNode<>(ele);
        if(index > size)
            throw new IndexOutOfBoundsException("索引错误");
        int i = 0;
        while (i++ < index)
            node = node.getNext();
        temp = node.getNext();
        element.setNext(temp);
        temp.setPrev(element);
        element.setPrev(node);
        node.setNext(element);
        size++;
    }

    //获取结点
    public LinkNode<T> get(T ele){
        LinkNode<T> node = head;
        LinkNode<T> temp = null;
        while (node.getNext() != null)
        {
            if(node.getNext().getData() == ele)
            {
                temp = node.getNext();
                break;
            }
            node = node.getNext();
        }
        return temp;
    }

    //根据索引获取结点
    public LinkNode<T> getByIndex(int index){
        LinkNode<T> node = head;
        LinkNode<T> temp = null;
        if(index > size)
            return null;
        int i = 0;
        while (i++ < index)
            node = node.getNext();
        temp = node.getNext();
        return temp;
    }

    //获取元素索引
    public int index(T ele){
        LinkNode<T> node = head;
        int index = -1;
        int i = 0;
        while (node.getNext() != null)
        {
            if(node.getNext().getData() == ele)
            {
                index = i;
                break;
            }
            node = node.getNext();
            i++;
        }
        return index;
    }

    public static void main(String[] args) {
        BidirectionalLinear<Character> linear = new BidirectionalLinear<>('a');
        System.out.printf("线性表的长度：%d，线性表是否为空：%s\n",linear.getSize(),linear.isEmpty());
        System.out.println("增加元素：");
        linear.add('b');
        linear.add('c');
        linear.add('d');
        for (int i = 0; i < linear.getSize(); i++) {
            System.out.printf("%s ",linear.getByIndex(i).getData());
        }
        System.out.printf("\n线性表的长度：%d，线性表是否为空：%s\n",linear.getSize(),linear.isEmpty());
        System.out.printf("线性表中c处于第%d位",linear.index('c')+1);
        System.out.println("\n在第二个位置插入元素d：");
        linear.insert(1,'d');
        for (int i = 0; i < linear.getSize(); i++) {
            System.out.printf("%s ",linear.getByIndex(i).getData());
        }
        System.out.println("\n删除第二个元素：");
        linear.deleteByIndex(1);
        for (int i = 0; i < linear.getSize(); i++) {
            System.out.printf("%s ",linear.getByIndex(i).getData());
        }
    }
}
