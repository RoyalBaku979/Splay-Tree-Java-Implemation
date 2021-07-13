package Node;

public class SplayNode
{
   public SplayNode left, right, parent;
   public int element;

    /** Constructor of Splay Node **/
    public SplayNode()
    {
        this(0, null, null, null);
    }
    /** Constructor of Splay Node with element **/
    public SplayNode(int ele)
    {
        this(ele, null, null, null);
    }
    /** Constructor of Splay node with all parameter **/
    public SplayNode(int ele, SplayNode left, SplayNode right, SplayNode parent)
    {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.element = ele;
    }
}
