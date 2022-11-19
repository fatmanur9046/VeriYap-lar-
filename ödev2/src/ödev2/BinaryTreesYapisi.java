
package ödev2;

import java.util.Scanner;

public class BinaryTreesYapisi {
     Scanner scanner=new Scanner(System.in);
    Node root;

    public BinaryTreesYapisi() {
        root=null;
    }
    Node newNode(int data){
        root=new Node(data);
        return root;
    }
    Node insert(Node root,int data){
        int yon;
        if(root!=null){
             System.out.println("saga eklemek için 0 a sola eklemek için 1 e basiniz");
             yon=scanner.nextInt();
            if(yon==0){
                 root.left=insert(root.left,data);
            }
            else if(yon==1){
                 root.right=insert(root.right, data);
            }
        }
        else{
            root=new Node(data);
        }
        return root;
    }
    
   void preorder(Node root){
       if(root!=null){
           System.out.println(root.data);
           preorder(root.left);
           preorder( root.right);
       }
   }
   void inorder(Node root){
       if(root!=null){
           preorder(root.left);
           System.out.println(root.data);
           preorder( root.right);
       }
   }
   void postorder(Node root){
       if(root!=null){
           preorder(root.left);
           preorder( root.right);
           System.out.println(root.data);
       }
   }
     
    
}
