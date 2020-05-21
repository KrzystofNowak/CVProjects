package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * class to read graph parameters from file, check number of consistent subgraphs and check if there is path between two given vertex in this graph
 */
public class DFSearch {

    private boolean[] marked;
    private int count;

    /**
     * constructor
     * @param G
     */
    public DFSearch(Graph G) {
        marked = new boolean[G.V()];
    }

    /**
     * method to do DFS on given graph
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    /**
     * check if given vertex is marked
     * @param v
     * @return
     */
    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }

    /**
     * clear all vertex form being marked
     * @param G
     */
    public void clearMarked(Graph G){
        for(int v = 0; v < G.V(); v++)
            marked[v] = false;
    }

    /**
     *
     * @return number of vertex connected (by path) with given vertex
     */
    public int count() {
        return count;
    }

    /**
     * check if given vertex is proper (is in range from 0 to V-1) V- number ofvertex in given graph
     * @param v
     */
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Inappropriate vertex!");
    }


    /**
     * count number of consistent subgraphs
     * @param G
     * @return
     */
    public int numberOfSubgraphs(Graph G){
        int counterOfSubgraphs = 0;
        for (int v = 0; v < G.V(); v++) {
            if (!marked(v)) {
                dfs(G, v);
                counterOfSubgraphs++;
            }
        }
        return counterOfSubgraphs;
    }

    /**
     * method to print all vertex on path between two given vertex (if path doesn't exist, the statement:'there is no such path' will be shown)
     * @param G
     * @param v
     * @param w
     */
    public void path(Graph G, int v, int w){
        clearMarked(G);
        validateVertex(v);
        validateVertex(w);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(G, v, w, path);
        if(path.isEmpty()) System.out.println("there is no such path");
        else{
            for(int i : path){
                System.out.print(i);
                if(path.indexOf(i) != path.size()-1) System.out.print(" -> ");
            }
        }
    }

    /**
     * method to put vertex on the path between given vertex on arraylist
     * @param G
     * @param v
     * @param w
     * @param path
     */

    private void dfs(Graph G, int v, int w, ArrayList<Integer> path) {
        if(!marked[w]) path.add(v);

        marked[v] = true;

        for (int q : G.adj(v)) {
            if (!marked[q]) {

                dfs(G, q, w, path);
            }
        }
        if(!marked[w]) path.remove(path.size()-1);
    }



    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("NowakKrzysztof.txt"));
        String text;
        int E = 0;
        Graph G = null;

        // get number of vertex from file
        while(scanner.hasNext()){
            text = scanner.nextLine();
            if(text.charAt(0) == '#') continue;
            int V = Integer.parseInt(text);
            G = new Graph(V);
            break;
        }

        // bet number of edges
        while(scanner.hasNext()){
            text = scanner.nextLine();
            if(text.charAt(0) == '#') continue; // there can be comments inside the file
            E = Integer.parseInt(text);
            break;
        }

        // create edges in graph
        for(int i = 0; i < E; i++){
            text = scanner.nextLine();
            if(text.charAt(0) == '#') {
                i--;
                continue;
            }
            String[] edge = text.split(" ");
            G.addEdge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]));
        }

        // check number of consistent subgraphs
        DFSearch search = new DFSearch(G);
        System.out.println("number of subgraphs " +  search.numberOfSubgraphs(G));
        System.out.println();
        search.path(G, 134, 229);
        System.out.println();
        search.path(G, 50, 243);
        System.out.println();
        search.path(G, 364, 95);
        System.out.println();


        Scanner vertexScanner = new Scanner(System.in);
        System.out.println("Type 0 if you want to search path, otherwise type different integer");

        int number = vertexScanner.nextInt();

        while(number == 0){
            System.out.println("give two vertex you want to search path for");
            int v = vertexScanner.nextInt();
            int w = vertexScanner.nextInt();
            search.path(G, v, w);
            System.out.println();
            System.out.println("Type 0 if you want to search next path, otherwise type different integer");
            number = vertexScanner.nextInt();
        }
    }
}