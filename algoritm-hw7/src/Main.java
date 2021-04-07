public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(1,2);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(7,8);

        graph.addEdge(0,1);

//        System.out.println(graph.getAdjList(4));

//        DepthFirstPath dfp = new DepthFirstPath(graph, 0);
//        System.out.println(dfp.hasPathTo(2));
//        System.out.println(dfp.pathTo(2));

        BreadthFirstPath bfp  = new BreadthFirstPath(graph, 0);
        System.out.println(bfp.hasPathTo(2));
        System.out.println(bfp.pathTo(2));



    }
}
