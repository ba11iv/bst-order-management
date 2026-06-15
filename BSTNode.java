package bst_lab;

class BSTNode<Key,T>{

    private Key key;
    private T data;
    private BSTNode<Key,T> left;
    private BSTNode<Key,T> right;

    public BSTNode(){
        left=right=null;
    }

    public BSTNode(Key key,T data){
        this.key=key;
        this.data=data;
        left=right=null;
    }

    public BSTNode(Key key,T data,BSTNode<Key,T> left,BSTNode<Key,T> right){
        this.key=key;
        this.data=data;
        this.left=left;
        this.right=right;
    }

    public Key getKey(){ return key; }

    public void setKey(Key key){ this.key=key; }

    public T getData(){ return data; }

    public void setData(T data){ this.data=data; }

    public BSTNode<Key,T> getLeft(){ return left; }

    public void setLeft(BSTNode<Key,T> left){ this.left=left; }

    public BSTNode<Key,T> getRight(){ return right; }

    public void setRight(BSTNode<Key,T> right){ this.right=right; }

    public boolean isLeaf(){
        return left==null && right==null;
    }
}
