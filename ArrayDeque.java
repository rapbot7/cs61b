package deque;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int nextLast;
    private int nextFirst;
public ArrayDeque(){
    items = (Item[])new Object[8];
    size  = 0;
    nextLast=4;
    nextFirst=3;
}
private int getrealfirst(){
    if (nextFirst==items.length-1) {
        return 0;
    }
    else{
        return nextFirst+1;
    }
}
private int getreallast(){
    if(nextLast==0){
        return items.length-1;
    }
    else{
        return nextLast-1;
    }
}
private void resize(int capacity){
    //首先我得找到概念中的第一
int realfirst=getrealfirst();
if (realfirst==0){
    Item[] a = (Item[])new Object[capacity];
    System.arraycopy(items,0,a,0,size);
    items=a;
    nextFirst=items.length-1;
    nextLast=size;
}
else{
    Item[] a = (Item[])new Object[capacity];
    for(int n=0;n<size;n=n+1,realfirst=realfirst+1){
        if(realfirst== items.length) {
            realfirst = 0;
            a[n] = items[realfirst];
        }
        else{
            a[n] = items[realfirst];
        }
    }
    items=a;
    nextFirst=items.length-1;
    nextLast=size;
}
}
private void updatenextFirst(){
    if(nextFirst==0){
        nextFirst=items.length-1;
    }
    else{
        nextFirst=nextFirst-1;
    }
}
private void updatenextLast(){
    if(nextLast==items.length-1){
        nextLast=0;
    }
    else{
        nextLast=nextLast+1;
    }
}
private void updateFirstback(){
    if(nextFirst==items.length-1){
        nextFirst=0;
    }
    else{
        nextFirst=nextFirst+1;
    }
}
private void updateLastback(){
    if(nextLast==0){
        nextLast=items.length-1;
    }
    else{
        nextLast=nextLast-1;
    }
}
    public void addFirst(Item t){
    if(size==items.length){
        resize(size*2);
    }
    items[nextFirst]=t;
    updatenextFirst();
    size=size+1;
    }

    public void addLast(Item t){
        if(size==items.length){
            resize(size*2);
        }
        items[nextLast]=t;
        size=size+1;
        updatenextLast();

    }
    public boolean isEmpty(){
    if(size==0){
        return true;
    }
    else{
        return false;
    }
    }
    public int size(){
    return size;
    }
    private boolean CheckSize(){
    double rate = (double)size/items.length;
  if(rate<0.25){
      return true;
  }
  else{
      return false;
  }
    }
    public Item removeFirst(){
    if(!isEmpty()){
        if(CheckSize()) {
            resize(items.length/2);
        }
        int a = getrealfirst();
        Item t = items[a];
        items[a] = null;
        size = size - 1;
        updateFirstback();
        return t;
    }
    else{
        System.out.println("你是不是有病？");
        return null;
    }
    }
    public Item removeLast(){
        if(!isEmpty()){
            if(CheckSize()) {
                resize(items.length/2);
            }
            int a = getreallast();
            Item t = items[a];
            items[a] = null;
            size = size - 1;
            updateLastback();
            return t;

        }
        else {
            System.out.println("你是不是有病？");
            return null;
        }
    }
    public Item get(int index) {
        if (items[index] == null) {
            System.out.println("这里没有东西");
            return null;
        } else {
            return items[index];
        }
    }
    public void printDeque(){
        this.Transfer();
        System.out.println("----------------");
        for(int i=0;i<size;i=i+1){
            System.out.println(items[i]);
        }
        System.out.println("----------------");
    }
    private void Transfer(){
        int realfirst=getrealfirst();
        if (realfirst==0){
            Item[] a = (Item[])new Object[size];
            System.arraycopy(items,0,a,0,size);
            items=a;
            nextFirst=items.length-1;
            nextLast=0;
        }
        else{
            Item[] a = (Item[])new Object[size];
            for(int n=0;n<size;n=n+1,realfirst=realfirst+1){
                if(realfirst == items.length) {
                    realfirst = 0;
                    a[n] = items[realfirst];
                }
                else{
                    a[n] = items[realfirst];
                }
            }
            items=a;
            nextFirst=items.length-1;
            nextLast=0;
        }
}

    public boolean equals(Object o){
    ArrayDeque other=(ArrayDeque) o;
    this.Transfer();
    other.Transfer();
    for(int i=0;i<other.size;i=i+1){
    if(this.items[i]!=other.items[i])
        return false;
    }
    return true;
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> t = new ArrayDeque<Integer>();
        ArrayDeque<Integer> t1= new ArrayDeque<Integer>();
        for (int i = 0; i < 19; i = i + 1) {
            t.addLast(25);
            t.addFirst(i);
            t1.addLast(25);
            t1.addFirst(i);
        }

         System.out.println(t.equals(t1));
         t1.addFirst(5);
         t1.addLast(65);
         System.out.println(t.equals(t1));
         t1.Transfer();
         t1.printDeque();
         System.out.println(t1 instanceof Object);
    }
}





