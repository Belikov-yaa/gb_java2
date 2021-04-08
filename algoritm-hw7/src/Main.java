public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(1,5);
        graph.addEdge(1,4);
        graph.addEdge(0,9);
        graph.addEdge(2,5);
        graph.addEdge(5,7);
        graph.addEdge(3,4);
        graph.addEdge(4,8);
        graph.addEdge(4,7);
        graph.addEdge(5,9);
        graph.addEdge(5,6);
        graph.addEdge(9,6);

//        System.out.println(graph.getAdjList(4));

//        DepthFirstPath dfp = new DepthFirstPath(graph, 0);
//        System.out.println(dfp.hasPathTo(2));
//        System.out.println(dfp.pathTo(2));

        BreadthFirstPath bfp  = new BreadthFirstPath(graph, 0);
        System.out.println(bfp.hasPathTo(3));
        System.out.println(bfp.pathTo(3));



    }
}
