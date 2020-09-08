package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的个数
    //定义数组boolean[] 记录某个结点是否被访问过
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String vertexValue[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String value : vertexValue) {
            graph.insertVertex(value);
        }
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.showGraph();

        //dfs
        graph.dfs();
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new  ArrayList<String>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index){
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标获取下一个邻接结点的下标
    public int getNextNeighbor(int v1,int v2){
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    private void dfs(boolean[] isVisited,int i){
        //访问该节点
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;
        //查找结点i的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1){//有邻接结点
            if (!isVisited[w]){//w没有被访问
                dfs(isVisited,w);
            }else {
                //如果w结点已经被访问过
                w = getNextNeighbor(i, w);
            }
        }
    }

    public void dfs(){
        //遍历所有的结点 进行dfs
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //返回顶点个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    //返回边的个数
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i对应的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1,int v2) {
        return edges[v1][v2];
    }

    //插入顶点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**添加边
     * @param v1 表示点的下标
     * @param v2 点的下标
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
