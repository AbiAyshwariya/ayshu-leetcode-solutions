
class LRUCache {

    class Node{
    int key;
    int val;
    Node prev;
    Node next;
    Node(int _key,int _val){
        key=_key;
        val=_val;
    }
   }
   
   public void deleteNode(Node delNode){
      Node delPrev=delNode.prev;
      Node delNext=delNode.next;
      delPrev.next=delNext;
      delNext.prev=delPrev;
   }


   public void addNode(Node newNode){
    Node temp=head.next;
    newNode.next=temp;
    newNode.prev=head;
    head.next=newNode;
    temp.prev=newNode;
   }

   HashMap<Integer,Node> m=new HashMap<>();
   int cap;
   Node head=new Node(-1,-1);
   Node tail=new Node(-1,-1);

    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }


    
    public int get(int key) {
        if(!m.containsKey(key)){
            return -1;
        }
            Node res=m.get(key);
            int resval=res.val;
            deleteNode(res);
            addNode(res);
            return resval;
        
    }
    
    public void put(int key, int value) {
       if(m.containsKey(key)){
        Node existing=m.get(key);
        m.remove(key);
        deleteNode(existing);
       } 

       if(m.size()==cap){
          m.remove(tail.prev.key);
          deleteNode(tail.prev);
       }

       addNode(new Node(key,value));
       m.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */