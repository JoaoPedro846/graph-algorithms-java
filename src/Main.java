import entites.Node;
import exceptions.NodeNotFoundException;
import graph.Graph;

void main(){
    Graph graph = new Graph();

    Node A = new Node("A");
    Node B = new Node("B");
    Node C = new Node("C");
    Node D = new Node("D");
    Node E = new Node("E");
    Node F = new Node("F");
    Node G = new Node("G");


    graph.addNode(A);
    graph.addNode(B);
    graph.addNode(C);
    graph.addNode(D);
    graph.addNode(E);
    graph.addNode(F);
    graph.addNode(G);

    graph.addEdge(A, C, false);
    graph.addEdge(A, D, false);
    graph.addEdge(C, D, true);
    graph.addEdge(C, F, false);
    graph.addEdge(D, G, true);
    graph.addEdge(G, E, false);

    try {
        System.out.println("Find BFS:");


        System.out.println();
        System.out.println("From A to B");

        List<Node> find = graph.bfs(A, B);

        if (!find.isEmpty()) {
            System.out.println("Path: " + find.stream()
                    .map(Node::getName)
                    .collect(Collectors.joining(" -> ")));
        } else {
            System.out.println("Impossible path!");
            System.out.println();
        }

        System.out.println();
        System.out.println("From A to E");

        find = graph.bfs(A, E);

        if (!find.isEmpty()) {
            System.out.println("Path: " + find.stream()
                    .map(Node::getName)
                    .collect(Collectors.joining(" -> ")));
        } else {
            System.out.println("Impossible path!");
            System.out.println();
        }

        System.out.println();
        System.out.println("From E to E");

        find = graph.bfs(E, E);

        if (!find.isEmpty()) {
            System.out.println("Path: " + find.stream()
                    .map(Node::getName)
                    .collect(Collectors.joining(" -> ")));
        } else {
            System.out.println("Impossible path!");
            System.out.println();
        }
    }
    catch (NodeNotFoundException e){
        System.out.println(e.getMessage());
    }

    System.out.println();
    System.out.println("Adjacent Matrix:");
    System.out.println();

    graph.printMat();
}