package collection.linear;

/**
 * 顺序线性表
 */
public class SequentialLinear<T> {
    //用数组存储元素
    private T[] arr;
    //当前下标
    private int size;

    public SequentialLinear(int len){
        arr = (T[])new Object[len];
        size = 0;
    }

    public int getSize(){
        return size;
    }

    //判断线性表是否已满
    public boolean isFull(){
        return size == arr.length;
    }

    //判断线性表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //添加元素
    public void add(T ele)throws IndexOutOfBoundsException{
        if(!isFull())
            arr[size++] = ele;
        else
            throw new IndexOutOfBoundsException("线性表满了:"+size);
    }

    //获取元素
    public T get(int index){
        T element = null;
        if(arr[index] != null)
            element = arr[index];
        return element;
    }

    //获取元素的索引
    public int index(T ele){
        int index = -1;
        for (int i = 0; i < size; i++) {
            if(arr[i] == ele)
            {
                index = i;
                break;
            }
        }
        return index;
    }

    //删除元素
    public T delete(int index){
        T element = null;
        if(arr[index] != null)
        {
            element = arr[index];
            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i+1];
            }
            size--;
        }
        return element;
    }

    //插入元素
    public void insert(int index,T ele)throws IndexOutOfBoundsException{
        if(isFull())
            throw new IndexOutOfBoundsException("线性表满了");
        else if(index > size+1)
            throw new IndexOutOfBoundsException("索引错误");
        else
            if(arr[index] != null)
                for (int i = size-1; i >= index; i--)
                    arr[i+1] = arr[i];
            arr[index] = ele;
            size++;
    }

    public static void main(String[] args) {
        SequentialLinear<Character> linear = new SequentialLinear<>(5);
        System.out.printf("线性表的长度：%d，线性表是否为空：%s\n",linear.getSize(),linear.isEmpty());
        System.out.println("增加元素：");
        linear.add('a');
        linear.add('b');
        linear.add('c');
        for (int i = 0; i < linear.getSize(); i++) {
            System.out.printf("%s ",linear.get(i));
        }
        System.out.printf("\n线性表的长度：%d，线性表是否为空：%s\n",linear.getSize(),linear.isEmpty());
        System.out.printf("线性表中c处于第%d位",linear.index('c')+1);
        System.out.println("\n在第二个位置插入元素d：");
        linear.insert(1,'d');
        for (int i = 0; i < linear.getSize(); i++) {
            System.out.printf("%s ",linear.get(i));
        }
        System.out.println("\n删除第二个元素：");
        linear.delete(1);
        for (int i = 0; i < linear.getSize(); i++) {
            System.out.printf("%s ",linear.get(i));
        }

    }
}
