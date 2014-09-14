package com.rateme.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BFS {
    private boolean[] marked;
    private List<Integer> neighbours = new ArrayList<Integer>();

    public BFS (AdjacencyList G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    private void bfs(AdjacencyList G, int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        marked[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.remove();

            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    q.add(w);
                    neighbours.add(w);
                }
            }
        }
    }

    public List<Integer> getNeighbours() {
        return neighbours;
    }
}
