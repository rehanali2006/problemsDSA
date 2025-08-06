public class LinkedList {
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    void addAtMid(int data,int idx){
        Node newNode = new Node(data);
        size++;
        Node temp=head;
        if(head==null){
            head=newNode;
            return;
        }
        int i=0;
        while(i< idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;

    }
    // void removeFist(){
    //         if(head==null){
    //         System.out.println("no node to delete");
    //     }
    //     head=head.next;
    // }

    // public void removeLast(){
    //     Node temp=head;
    //     if(head==null){
    //         System.out.println("no node to delete");
    //         return;
    //     }
    //     else if(head.next==null){
    //         head=null;
    //         return;
    //     }
    //     while(temp.next.next != null){
    //         temp=temp.next;
    //     }
    //     temp.next=null;
    // }

    // public void reverseLinkedList(Node rightHead){
    //     Node next;
    //     Node prev=null;
    //     Node curr=rightHead;

    //     while(curr!=null){
    //         next=curr.next;
    //         curr.next=prev;
    //         prev=curr;
    //         curr=next;
    //     }
    //     rightHead=prev;
    // }

    // void deleteNthNode(int n){
    //     Node temp=head;
    //     if(head==null || n>size){
    //         System.out.println("no node to del");
    //         return;
    //     }
    //     for(int i=1;i<size-n;i++){
    //         temp=temp.next;
    //     }
    //     temp.next=temp.next.next;

    // }

    public Node calcMid(){
        int mid=size/2;
        Node temp=head;
        for(int i=0;i<mid;i++){
            temp=temp.next;
        }

        return temp;
    }
    Node zigzag(){
        //calculating mid from this question
        Node rightHead=calcMid();
        reverseLinkedList(rightHead);
        return Merge(rightHead,head);

    }

    Node Merge(Node rightHead,Node head ){
        Node rT=rightHead;
        Node lT=head;
         Node ans=head;
         Node temp=new Node(-1);
        while(rT!=null && lT!=null){
            temp=lT;
            lT=lT.next;
            
            temp.next=rT;
            rT=rT.next;
            temp=temp.next;
        }
        return ans.next;
        
    }
     


    void print(Node ans){
        Node temp=ans;
        if(ans==null){
            System.out.println("null");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data +"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        LinkedList ll=new LinkedList();
        ll.addAtMid(1,0);
        ll.addAtMid(2,1);

        ll.addAtMid(3,2);
        ll.addAtMid(4,3);

        
        
        
        Node ans=ll.zigzag();
        ll.print(ans);        
    }
}
