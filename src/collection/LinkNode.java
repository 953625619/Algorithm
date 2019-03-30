package collection;

/**
 * 链表的结点
 * @param <T>
 */
public class LinkNode<T> {
    //数据域
    private T data;
    //指向后继的指针域
    private LinkNode next;
    //指向前驱的指针域
    private LinkNode prev;

    public LinkNode() {
        this.data = null;
    }

    public LinkNode(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public LinkNode(T data, LinkNode next){
        this.data = data;
        this.next = next;
        this.prev = null;
    }


    public LinkNode(T data, LinkNode next, LinkNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public LinkNode getPrev() {
        return prev;
    }

    public void setPrev(LinkNode prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "data=" + data +
                ", next=" + next +
                ", prev=" + prev +
                '}';
    }
}
