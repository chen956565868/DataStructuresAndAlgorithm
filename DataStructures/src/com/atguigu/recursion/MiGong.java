package com.atguigu.recursion;

public class MiGong {
    public static void main(String[] args) {
        //创建二维数组模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"   ");
            }
            System.out.println();
        }
        System.out.println("------------");
        setWay(map, 1, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"   ");
            }
            System.out.println();
        }

    }



    /**
     * 使用递归回溯给小球找路
     * @param map   地图
     * @param i     开始位置
     * @param j
     * @return
     * 0：没有走过   1：墙     2：走过   3：走过 走不通
     */
    public static boolean setWay(int[][] map,int i, int j){
        if (map[6][5] == 2){//通路已经找到
            return true;
        }else {
            if (map[i][j]==0) {//当前这个点没有走过
                // 下-右-上-左
                map[i][j] = 2; // 假定该点是可以走通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左走
                    return true;
                } else {
                    //说明该点是走不通，是死路
                    map[i][j] = 3;
                }
                return false;
            }else {
                // 如果 map[i][j] != 0 , 可能是 1， 2， 3
                return false;
            }
        }
    }
}
