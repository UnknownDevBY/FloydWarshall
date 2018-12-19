package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private final static int INF = 99;
    private static int graph[][] = {
            {INF,   5,   6, INF, INF, INF, INF, INF, INF, INF},
            {INF, INF,   4, INF,   3, INF, INF, INF, INF, INF},
            {INF, INF, INF,   4, INF,   1, INF, INF, INF, INF},
            {INF, INF, INF, INF, INF,   7, INF, INF, INF, INF},
            {INF, INF, INF, INF, INF,   2,   8,  10, INF, INF},
            {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
            {INF, INF, INF, INF, INF, INF, INF,   7,   5,   5},
            {INF, INF, INF, INF, INF, INF, INF, INF, INF,   3},
            {INF, INF, INF, INF, INF, INF, INF, INF, INF,   4},
            {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}
    };
    private static int[][] path;

    public static void main (String[] args) {
        path = new int[graph.length][graph.length];
        initPath();
        floydWarshall();
        Scanner scanner = new Scanner(System.in);
        System.out.println("starting vertex: ");
        int from = scanner.nextInt();
        System.out.println("final vertex: ");
        int to = scanner.nextInt();
        printPath(from, to);
    }

    private static void initPath() {
        for(int i = 1; i != path.length; i++)
            for(int j = 0; j != path.length; j++)
                path[j][i] = i;
    }

    private static void floydWarshall() {
        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph.length; j++)
                for (int k = 0; k < graph.length; k++)
                    if (graph[i][j] + graph[j][k] < graph[i][k]) {
                        graph[i][k] = graph[i][j] + graph[j][k];
                        path[i][k] = j;
                    }
    }

    private static void printPath(int from, int to) {
        LinkedList<Integer> list = new LinkedList<>();
        int temp;
        temp = to;
        while (temp != path[from][temp]) {
            list.addFirst(temp);
            temp = path[from][temp];
        }
        list.addFirst(temp);
        System.out.print((from + 1));
        list.forEach(integer -> System.
                out.print("->" + (integer + 1)));
        System.out.print(" price = " + graph[from][to] + "\n");
    }
}