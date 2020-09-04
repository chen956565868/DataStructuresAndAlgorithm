package com.atguigu.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //遍历二维数组 得到有效数据的个数sum
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.printf(chessArr1[i][j]+"   ");
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
            System.out.println();
        }
        System.out.println("sum="+sum);
        //根据sum 创建稀疏数组sparseArr[sum+1][3]
        int[][] sparseArr = new int[sum + 1][3];
        //将二维数组的有效数据 存入稀疏数组
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
            System.out.println();
        }
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        //读取稀疏数组的第一行 创建二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //遍历稀疏数组 赋值
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("------------");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf(data+"  ");
            }
            System.out.println();
        }












    }
}
