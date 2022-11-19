
package ödev2;

import java.util.Scanner;


public class Ödev2 {

    
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        BinaryTreesYapisi bt=new BinaryTreesYapisi();
        int secim=-1;
        int sayi;
        Node root;
        int yon;
        while(secim!=0){
            System.out.println("1-ekle");
            System.out.println("2-Preorder");
            System.out.println("3-inorder");
            System.out.println("4-postorder");
            System.out.println("0-cikis");
            System.out.println("seciniz:");
            secim=scanner.nextInt();
            
            if(secim==1){
                root=bt.newNode(10);
                System.out.println("sayi giriniz");  sayi=scanner.nextInt();
                bt.insert( root,sayi);
            }
            if(secim==2){
               root=bt.newNode(10);
                bt.preorder(root);
            }
            if(secim==3){
                
                root=bt.newNode(10);
                bt.inorder(root);
            }
            if(secim==4){
                root=bt.newNode(10);
                bt.postorder(root);
            }
            if(secim==0){
                System.out.println("cikis yaptiniz");
            }
            
        }
        
    }
    
}
