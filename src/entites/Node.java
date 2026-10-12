package entites;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String name;

    private Color color;
    private final List<Node> adjacent = new ArrayList<>();

    public Node(String name) {
        this.name = name;
        this.color = Color.WHITE;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Node> getAdjacent() {
        return adjacent;
    }

    public void addAdjacent(Node node) {
        adjacent.add(node);
    }

    public boolean isAdjacent(Node node) {
        return adjacent.contains(node);
    }
}
