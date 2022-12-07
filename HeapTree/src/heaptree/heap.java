
package heaptree;


public class heap {
private static int n;

private int left(int i)
{
return (2 * i) + 1;
}

private int right(int i)
{
return (2 * i) + 2;
}

public int minimum(int [] array)
{
return array[array.length - 1]; 
}

public int maximum(int [] array)
{
return array[0]; 
}

public void sort(int [] array)
{
n = array.length-1;

heapify(array); 
}

private void heapify(int [] array)
{
for(int i = n; i >= 0; i--) heap(array,i); 
}

private void heap(int [] array, int i)
{
int left = left(i); 
int right= right(i);
int largest = i; 

if((left <= n) && (array[left] > array[largest]) ) 
largest = left;

if((right <= n) && (array[right] > array[largest]) )
largest = right;

if(largest != i)
{

int temp = array[i];
array[i] = array[largest];
array[largest] = temp;

heap(array,largest); 
}
}

public void print(int [] array)
{
for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
}
}
