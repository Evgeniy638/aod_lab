public class NodeTree {
    NodeTree left;
    NodeTree right;
    char value;

    static char defaultValue = '@';

    public NodeTree(char value) {
        this(null, null, value);
    }

    public NodeTree(NodeTree left, NodeTree right) {
        this(left, right, defaultValue);
    }

    public NodeTree(NodeTree left, NodeTree right, char value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
