package bst_lab;

class BST<Key extends Comparable<? super Key>,T>{

    private BSTNode<Key,T> root;
    int size;

    BST(){
        root=null;
        size=0;
    }

    public void clear(){
        root=null;
        size=0;
    }

    public int size(){
        return size;
    }

    public void insert(Key k,T e){
        root=inserthelp(root,k,e);
        size++;
    }

    private BSTNode<Key,T> inserthelp(BSTNode<Key,T> rt,Key k,T e){

        if(rt==null)
            return new BSTNode<>(k,e);

        if(rt.getKey().compareTo(k)>0)
            rt.setLeft(inserthelp(rt.getLeft(),k,e));
        else
            rt.setRight(inserthelp(rt.getRight(),k,e));

        return rt;
    }

    public T findMIN(){
        return findMINhelp(root);
    }

    private T findMINhelp(BSTNode<Key,T> b){

        if(b==null)
            return null;

        if(b.getLeft()==null)
            return b.getData();

        return findMINhelp(b.getLeft());
    }

    public T findMAX(){
        return findMAXhelp(root);
    }

    private T findMAXhelp(BSTNode<Key,T> b){

        if(b==null)
            return null;

        if(b.getRight()==null)
            return b.getData();

        return findMAXhelp(b.getRight());
    }

    public boolean isBST(){
        return isBST(root,null,null);
    }

    private boolean isBST(BSTNode<Key,T> node,Key min,Key max){

        if(node==null)
            return true;

        if(min!=null && node.getKey().compareTo(min)<=0)
            return false;

        if(max!=null && node.getKey().compareTo(max)>=0)
            return false;

        return isBST(node.getLeft(),min,node.getKey())
            && isBST(node.getRight(),node.getKey(),max);
    }

    public T find(Key k){
        return findhelp(root,k);
    }

    private T findhelp(BSTNode<Key,T> rt,Key k){

        if(rt==null)
            return null;

        if(rt.getKey().compareTo(k)>0)
            return findhelp(rt.getLeft(),k);
        else if(rt.getKey().compareTo(k)==0)
            return rt.getData();
        else
            return findhelp(rt.getRight(),k);
    }

    private BSTNode<Key,T> getmin(BSTNode<Key,T> rt){

        if(rt.getLeft()==null)
            return rt;

        return getmin(rt.getLeft());
    }

    private BSTNode<Key,T> deletemin(BSTNode<Key,T> rt){

        if(rt.getLeft()==null)
            return rt.getRight();

        rt.setLeft(deletemin(rt.getLeft()));
        return rt;
    }

    public T remove(Key k){

        T temp=findhelp(root,k);

        if(temp!=null){
            root=removehelp(root,k);
            size--;
        }

        return temp;
    }

    private BSTNode<Key,T> removehelp(BSTNode<Key,T> rt,Key k){

        if(rt==null)
            return null;

        if(rt.getKey().compareTo(k)>0)
            rt.setLeft(removehelp(rt.getLeft(),k));
        else if(rt.getKey().compareTo(k)<0)
            rt.setRight(removehelp(rt.getRight(),k));
        else{

            if(rt.getLeft()==null)
                return rt.getRight();

            if(rt.getRight()==null)
                return rt.getLeft();

            BSTNode<Key,T> temp=getmin(rt.getRight());

            rt.setKey(temp.getKey());
            rt.setData(temp.getData());

            rt.setRight(deletemin(rt.getRight()));
        }

        return rt;
    }

    public void print(){
        inorder(root);
    }

    private void inorder(BSTNode<Key,T> p){

        if(p==null)
            return;

        inorder(p.getLeft());
        System.out.println(p.getData());
        inorder(p.getRight());
    }

    public boolean contains(Order o){
        return contains(root,o);
    }

    private boolean contains(BSTNode<Key,T> node,Order o){

        if(node==null)
            return false;

        if(node.getData().equals(o))
            return true;

        return contains(node.getLeft(),o)
            || contains(node.getRight(),o);
    }

    int depth(BSTNode<Key,T> node){

        if(node==null)
            return 0;

        int left=1+depth(node.getLeft());
        int right=1+depth(node.getRight());

        return Math.max(left,right);
    }

    boolean isBalanced(){
        return isBalanced(root);
    }

    boolean isBalanced(BSTNode<Key,T> node){

        if(node==null)
            return true;

        int left=depth(node.getLeft());
        int right=depth(node.getRight());

        if(Math.abs(left-right)>1)
            return false;

        return isBalanced(node.getLeft())
            && isBalanced(node.getRight());
    }

    public void printTotalPrice(){

        double total=totalPrice(root);
        System.out.println("Total Price = "+total);
    }

    private double totalPrice(BSTNode<Key,T> node){

        if(node==null)
            return 0;

        Order o=(Order)node.getData();

        return o.getPrice()
            +totalPrice(node.getLeft())
            +totalPrice(node.getRight());
    }
}
