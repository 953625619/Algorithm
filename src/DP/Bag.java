package DP;


public class Bag {
    //01背包问题
    public static int getBag(int maxWeight,int[] weight,int[] value){
        int weightLen = maxWeight;  //用背包的容量作为表格的列
        int valueLen = value.length;//用物品的数量作为表格的行
        int maxValue = 0;           //记录最大权值
        int[][] bag = new int[valueLen][weightLen];     //用表格记录背包
        for (int i = 0; i < valueLen; i++) {
            for (int j = 0; j < weightLen; j++) {
                if (i == 0) {                           //第一行
                    if(weight[i] <= j+1)                //如果重量比背包小，那就可以装进去
                        bag[i][j] = value[0];
                    else
                        bag[i][j] = 0;                  //否则，背包装不进去，只能为0
                }
                else {
                    if (weight[i] > j+1)                                                          //如果重量比背包大，那么装不进去
                        bag[i][j] = bag[i - 1][j];                                               //背包只能取之前装过的最大价值
                    else if(weight[i] == j+1)                                                    //如果重量和背包相同
                        bag[i][j] = Math.max(bag[i - 1][j],value[i]);                           //那么就看装这件东西划算，还是不装这件东西装别的东西划算
                    else                                                                            //如果重量比背包小
                        bag[i][j] = Math.max(bag[i - 1][j], bag[i - 1][j - weight[i]] + value[i]);  //那么可以装进背包，看看拿出一些东西腾出空间来装这个东西之后的价值大
                                                                                                    // 还是不装之前的总价值大
                }
                maxValue = bag[i][j];                                                               //找到当前最大价值了
            }
        }
        for (int i = 0; i < bag.length; i++) {                                                      //看看表格最后的结果
            for (int j = 0; j < bag[i].length; j++) {
                System.out.printf("%d ",bag[i][j]);
            }
            System.out.printf("%n");
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int maxWeight = 4;
//        int[] weight = {1,4,3};
//        int[] value = {1500,3000,2000};
        int[] weight = {4,3,1};
        int[] value = {3000,2000,1500};
//        String[] goods = {"音响","笔记本电脑","吉他"};
        System.out.println(getBag(maxWeight,weight,value));
    }
}
