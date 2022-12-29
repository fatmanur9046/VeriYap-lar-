/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package quiksortödevi;


public class Quiksortödevi{
    static int i=0;
    static int[] sonuc;
     
    public static void main(String[] args) {
        int[] dizi = { 65, 10, 14, 22, 78, 8, 85, 49, 50, 32 };
        int n = dizi.length;
        for(int j=0;j<10;j++){
        quickSort(dizi, j, n - 1);
        System.out.println("Sıralanmış dizi: ");
        printArray(dizi, n);
        }
        int enk=dizi[0];
       for(i=0;i<8;i++){
           if(dizi[i]<enk){
               enk=dizi[i];
           }
       }
        System.out.println(enk+" en iyi pivot");
    }
    
    
    static void degistir(int[] dizi, int i, int j)
    {
        int temp = dizi[i];
        dizi[i] = dizi[j];
        dizi[j] = temp;
        sonuc[i]=+1;
    }
    
    static void quickSort(int[] dizi, int sol, int sag)
    {   
        if (sol < sag) {
            sonuc[i]=+1;
            
            int pi = partition(dizi, sol, sag);
  
            
            quickSort(dizi, sol, pi - 1);
            quickSort(dizi, pi + 1, sag);
        }
    }
  
    static int partition(int[] dizi, int sol, int sag)
    {
  
        
        int pivot = dizi[sag];
  
       
        int i = (sol - 1);
  
        for (int j = sol; j <= sag - 1; j++) {
  
           
            if (dizi[j] < pivot) {
  
                
                i++;
                degistir(dizi, i, j);
            }
        }
        degistir(dizi, i + 1, sag);
        return (i + 1);
    }
    
    
    static void printArray(int[] dizi, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(dizi[i] + " ");
  
      
    }
}


