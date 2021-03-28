import java.util.ArrayList;

public class loadNode {
    int index;
    BTNode node;
    ArrayList<String> list = new ArrayList<String>();

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public BTNode getNode() {
        return node;
    }

    public void setNode(BTNode node) {
        this.node = node;
    }
}
