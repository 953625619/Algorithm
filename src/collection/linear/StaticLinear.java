package collection.linear;

import collection.StaticNode;

/**
 * 静态链表
 */
public class StaticLinear<T> {
    //用结点类型的数组存储元素
    private StaticNode<T>[] arr;
    //标记线性表的元素数量
    private int size;

    public StaticLinear(int len) {
        arr = new StaticNode[len + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StaticNode<>();
            if(i == arr.length - 1)
                arr[i].setCur(-1);
            else
                arr[i].setCur(i+1);
        }
    }

    //判断是否为空
    public boolean isEmpty() {
        return arr[arr.length-1].getCur() == -1;
    }

    //判断是否已满
    public boolean isFull() {
        return arr[0].getCur() == arr.length;
    }

    //链表长度
    public int len(){
        return arr.length;
    }
    //链表元素数量
    public int getSize(){
        return size;
    }
    //添加元素
    public void add(T data) throws IndexOutOfBoundsException {
        if (!isFull()) {
            int available = arr[0].getCur();
            arr[available].setData(data);
            arr[0].setCur(arr[available].getCur());
            int used = arr.length-1;
            while (arr[used].getCur() != -1)
                used = arr[used].getCur();
            arr[used].setCur(available);
            arr[available].setCur(-1);
            size ++;
        } else
            throw new IndexOutOfBoundsException("线性表满了");
    }

    //删除元素
    public StaticNode<T> delete(T data) {
        StaticNode<T> node = null;
        if (!isEmpty())
        {
            int last = arr.length-1;
            int used = arr[last].getCur();
            while (used != -1 && arr[used].getData() != data)
            {
                last = used;
                used = arr[used].getCur();
            }
            if(used != -1)
            {
                arr[last].setCur(arr[used].getCur());
                node = arr[used];
                size --;
                int available = arr[0].getCur();
                arr[used].setCur(available);
                arr[used].setData(null);
                arr[0].setCur(used);
            }
        }
        return node;
    }

    //获取元素
    public StaticNode<T> get(int index){
        StaticNode<T> node = null;
        if(index > 0 && index < arr.length - 1)
            node = arr[index];
        return node;
    }

    //获取元素的索引
    public int index(T ele){
        int index = -1;
        int used = arr.length-1;
        while (used != -1)
        {
            used = arr[used].getCur();
            if(arr[used].getData() == ele)
            {
                index = used;
                break;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        StaticLinear<Character> linear = new StaticLinear<>(5);
        System.out.printf("线性表是否为空:%s，线性表的大小为：%d\n",linear.isEmpty(),linear.getSize());
        System.out.println("添加元素：");
        linear.add('a');
        linear.add('b');
        linear.add('c');
        for (int i = 0; i < linear.len(); i++) {
            if(linear.get(i)!=null && linear.get(i).getData() != null)
                System.out.printf("%s ",linear.get(i).getData());
        }
        System.out.printf("\n线性表是否为空:%s，线性表的大小为：%d\n",linear.isEmpty(),linear.getSize());

        System.out.println("删除元素c：");
        linear.delete('c');
        for (int i = 0; i < linear.len(); i++) {
            if(linear.get(i)!=null && linear.get(i).getData() != null)
                System.out.printf("%s ",linear.get(i).getData());
        }
        System.out.printf("\n线性表是否为空:%s，线性表的大小为：%d\n",linear.isEmpty(),linear.getSize());

        System.out.printf("a所在的下标为：%d",linear.index('a'));
    }
}
