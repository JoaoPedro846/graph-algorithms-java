package graph;

import entites.Color;
import entites.Node;
import exceptions.NodeNotFoundException;

import java.util.*;

public class Graph {
    private final List<Node> nodes;

    public Graph() {
        nodes = new ArrayList<>();
    }

    public void addNode(Node node){
        if(!nodes.contains(node)){
            nodes.add(node);
        }
    }

    public void addEdge(Node source, Node target, boolean directed ){
        addNode(source);
        addNode(target);
        if(!directed) {
            if (!source.getAdjacent().contains(target) && !target.getAdjacent().contains(source)) {
                source.addAdjacent(target);
                target.addAdjacent(source);
            }
        }else {
            if (!source.getAdjacent().contains(target)) {
                source.addAdjacent(target);
            }
        }
    }

    public List<Node> bfs(Node source, Node target){

        if(!nodes.containsAll(Arrays.asList(source, target))){
            throw new NodeNotFoundException("Source or target node does not belong to this graph.");
        }

        resetColors();

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> previous = new HashMap<>();

        queue.add(source);
        source.setColor(Color.GRAY);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            current.setColor(Color.BLACK);

            if(current.equals(target)){
                List<Node> path = new ArrayList<>();
                Node node = target;

                while (node != null) {
                    path.add(node);
                    node = previous.get(node);
                }

                Collections.reverse(path);
                return path;
            }

            for(Node neighbor : current.getAdjacent()) {
                if (neighbor.getColor() == Color.WHITE){
                    neighbor.setColor(Color.GRAY);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }

        }

        return new ArrayList<>();
    }

    public int[][] adjacentArray(){
        int[][] adjacentArray = new int[nodes.size()][nodes.size()];

        for(int i = 0; i < nodes.size(); i++){
            for(int j = 0; j < nodes.size(); j++){
                if(nodes.get(i).isAdjacent(nodes.get(j))){
                    adjacentArray[i][j] = 1;
                }
                else{
                    adjacentArray[i][j] = 0;
                }
            }
        }

        return adjacentArray;
    }

    public void resetColors(){
        for(Node node : nodes){
            node.setColor(Color.WHITE);
        }
    }

    public void printMat(){
        int[][] matrix = adjacentArray();

        System.out.print("   ");

        for (Node node : nodes){
            System.out.print(node.getName() + " ");
        }

        System.out.println();
        for(int i = 0; i < matrix.length; i++){
            System.out.print(nodes.get(i).getName() + "  ");
            for(int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
