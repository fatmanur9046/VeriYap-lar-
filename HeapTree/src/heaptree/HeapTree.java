
package heaptree;


public class HeapTree {

    public static void main(String[] args)
{
heap h = new heap();
int[] array = {1,67,41,66,123,71,5,3,7,9,99};
System.out.println("Sıralanmamış hali");
h.print(array);

h.sort(array); // sırala

System.out.println("\nSıralanmış hali");
h.print(array);
System.out.println("\nMaksimum : " + h.maximum(array));
System.out.println("Minimum : " + h.minimum(array));
}
}