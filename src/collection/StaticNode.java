package collection;

/**
 * 静态结点
 * @param <T>
 */
public class StaticNode<T> {
    //数据域
    private T data;
    //游标
    private int cur;

    public StaticNode() {
    }

    public StaticNode(T data) {
        this.data = data;
    }

    public StaticNode(T data, int cur) {
        this.data = data;
        this.cur = cur;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }
}
