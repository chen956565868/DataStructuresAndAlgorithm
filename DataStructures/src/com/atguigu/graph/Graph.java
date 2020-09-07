package com.atguigu.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    //存储顶点集合
    private ArrayList<String> vertexList;
    //存储图对应的邻接矩阵
    private int[][] edges;
    //表示边的个数
    private int numOfEdges;
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
    }

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new  ArrayList<String>(n);
        numOfEdges = 0;
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
