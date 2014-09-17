package com.rateme.search;


import java.util.ArrayList;
import java.util.List;


public class AdjacencyList {
    private final int V;
    private int E;

    private List<Integer>[] adj;

    public AdjacencyList (int V) {
        if (V < 0) throw new IllegalArgumentException();
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }

    public int V() { return V; }

    public int E() { return E; }


    public void addEdge(int v, int w) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException("v=" + v + " V=" + V);
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException("w=" + w+ " V=" + V);
        E++;
        if(!adj[v].contains(w)) {
            adj[v].add(w);
        }
        if(!adj[w].contains(v)) {
            adj[w].add(v);
        }
    }


    public Iterable<Integer> adj(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        return adj[v];
    }
}
