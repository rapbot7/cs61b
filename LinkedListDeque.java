package deque;

public class LinkedListDeque<Item> {
    //链表通用node的结构
private class node{
    public node prev;
    public node next;
    public Item item;
    public node(node p,Item i,node n){
        prev=p;
        item=i;
        next=n;
    }
}

private int size;
private node sentinal;
public LinkedListDeque(){
    size=0;
    sentinal=new node(null,null,null);
    sentinal.prev=sentinal;
    sentinal.next=sentinal;
}
public LinkedListDeque(Item i){
    size=1;
    node n=new node(sentinal,i,sentinal);
    sentinal=new node(n,null,n);
    n.next=sentinal;
    n.prev=sentinal;
}
public void addFirst(Item t){
node p=sentinal.next;
node n=new node(null,t,null);
sentinal.next=n;
n.prev=sentinal;
n.next=p;
p.prev=n;
size=size+1;
}
public void addLast(Item t){
    node p=sentinal.prev;
    node n=new node(null,t,null);
    p.next=n;
    n.prev=p;
    n.next=sentinal;
    sentinal.prev=n;
    size=size+1;
}
    public boolean isEmpty(){
        return sentinal.next == sentinal;
    }
    public int size(){
    return size;
    }
    public void printDeque(){
    node p=sentinal;
    while(p.next!=sentinal) {
        System.out.print(p.next.item+" ");
        p = p.next;
    }
    }
    public Item removeFirst(){
    node p=sentinal.next;
    if(p!=sentinal) {
        sentinal.next = p.next;
        p.next.prev = sentinal;
        size = size - 1;
        return p.item;
    }
    else{
        return null;
    }
    }

    public Item removeLast(){
    node p=sentinal.prev;
    if(p!=sentinal) {
        p.prev.next = sentinal;
        sentinal.prev = p.prev;
        size = size - 1;
        return p.item;
    }
    else{
        return null;
    }
    }
    public Item get(int i){
    node p=sentinal.next;
    int k=0;
       while(k!=i){
       p=p.next;
       k=k+1;
       }
      return p.item;
    }
    public Item getRecursive(int index){
    node p = sentinal.next;
    return getrecursive(index,p);
    }
    private Item getrecursive(int index,node p){
    if(index==0){
        return p.item;
    }
    else{
        p=p.next;
        return getrecursive(index-1,p);
    }
    }
public static void main(String[] args){
    /*
    LinkedListDeque<Integer> p=new LinkedListDeque<Integer>(3);
    p.addfirst(2);
    p.addlast(4);
    /*
    LinkedListDeque<Integer> p1=new LinkedListDeque<Integer>(3);
    System.out.println(p1.isEmpty());

    p.printdeque();
    System.out.println(p.getRecursive(2));

     */

}
}
