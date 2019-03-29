package collection.stack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * 可动态变化的栈
 * @param <T>：泛型
 */
public class VarietyCapacityStack<T> implements Iterable<T>{
    //创建数组保存值
    private  T[] arr;
    //创建顶部指针
    private int N = 0;

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {

        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return arr[--i];
        }

        @Override
        public void remove() {
            arr[--i] = null;
        }
    }

    public VarietyCapacityStack(Class<T> tClass,int len){
        arr = (T[]) Array.newInstance(tClass, 5);
    }

    public void resize(int max){
        T[] array = (T[]) new Object[max];
        array = Arrays.copyOf(arr,arr.length);
        arr = array;
    }

    //入栈,如果栈满则扩大栈
    public void push(T element){
        if(N != arr.length)
            arr[N++] = element;
        else
            resize(arr.length*2);
    }

    //取栈顶元素
    public T peek(){
        if(N>0)
        {
            if(N > 0 && N == arr.length/4)
                resize(arr.length/2);
            return arr[N-1];

        }
        else
            return null;
    }

    //出栈，如果栈过大则压缩栈
    public void pop() throws EmptyStackException {
        if(N>0)
        {
            arr[--N] = null;
            if(N > 0 && N == arr.length/4)
                resize(arr.length/2);
        }
        else
            throw new EmptyStackException();
    }

    //是否为空栈
    public boolean isEmpty(){
        return N==0;
    }

    //栈的大小
    public int size(){
        return N;
    }

    public static void main(String[] args) {
        VarietyCapacityStack<String> stack = new VarietyCapacityStack<>(String.class,1);
        System.out.printf("栈是否为空:%s，栈的大小为：%d\n",stack.isEmpty(),stack.size());
        stack.push("H");System.out.print(stack.peek());
        stack.push("E");System.out.print(stack.peek());
        stack.push("L");System.out.print(stack.peek());
        stack.push("L");System.out.print(stack.peek());
        stack.push("O");System.out.print(stack.peek());
        System.out.printf("\n栈是否为空:%s，栈的大小为：%d\n",stack.isEmpty(),stack.size());
        for (String s:
             stack) {
            System.out.printf("%s",s);
            stack.pop();
        }
        System.out.printf("\n栈是否为空:%s，栈的大小为：%d\n",stack.isEmpty(),stack.size());

    }
}
