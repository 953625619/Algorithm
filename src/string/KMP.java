package string;

public class KMP {

    //寻找回溯的下标
    public static int[] find_next(char[] s){
        int i = 0;                              //记录遍历字符串的下标，从0开始遍历
        int j = -1;                             //记录最大前后缀的下标，还没有开始匹配
        int[] next = new int[s.length+1];       //保存下标
        next[0] = -1;                           //初始化数组，子串中没有相同的字符
        while (i<s.length)
        {
            if(j == -1 || s[i] == s[j])         //找到匹配字符的最大前后缀，下标继续向前找
            {
                ++i;
                ++j;
                next[i] = j;
            }
            else                               //没有找到，开始回溯查找
                j = next[j];
        }
        return next;
    }

    //KMP匹配算法
    public static int index(char[] parent,char[] children,int[] next){
        int index = -1;                 //记录子串匹配父串的索引
        int plen = parent.length;
        int clen = children.length;
        int i = 0;                      //记录遍历主串的下标
        int j = -1;                     //记录子串需要回溯的下标
        while (i < plen && j <clen)
        {
            if(j == -1 || parent[i]==children[j])       //匹配字符成功
            {
                ++i;
                ++j;
            }
            else                        //匹配失败，根据next[]回溯
                j = next[j];
        }
        if(j>=clen)                     //完全匹配成功
            index = i-clen;
        return index;
    }
    public static void main(String[] args) {
        String parent = "xABDBAxxABDBABxxxxx";
        String children = "ABDBAB";
        int[] next = find_next(children.toCharArray());
        int index = index(parent.toCharArray(),children.toCharArray(),find_next(children.toCharArray()));
        System.out.println(index);
    }
}
