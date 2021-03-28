public class BTNode<T>
{
    private BTNode left;
    private BTNode right;
    private T element;

    public BTNode(T element,BTNode left, BTNode right)
    {
        this.left = left;
        this.right = right;
        this.element = element;
    }

    public BTNode(T element)
    {
        this.element = element;
        left = null;
        right = null;

    }

    public BTNode() {
        left = null;
        right = null;
        element = null;
    }

    public BTNode getLeft()
    {
        return left;
    }

    public void setLeft(BTNode left)
    {
        this.left = left;
    }

    public BTNode getRight()
    {
        return right;
    }

    public void setRight(BTNode right)
    {
        this.right = right;
    }

    public T getElement()
    {
        return element;
    }

    public void setElement(T element)
    {
        this.element = element;
    }
    public boolean hasLeft(){
        if(this.left == null){
            return false;
        }else return true;
    }
    public boolean hasRight(){
        if(this.right == null){
            return false;
        }else return true;
    }
    public void setLeft(T e) {
        this.left = new BTNode(e);
    }


    public void setRight(T e) {
        this.right = new BTNode(e);
    }

}
