/*
Name: Sean Styer
File: DualPivotQuickSort.java
Input: Path to a .txt file of integers
Output: One sorted array using dual pivot quick sort
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class DualPivotQuickSort{
  public static void main(String[] args){
    //take in the provided file path and convert the data file into an array
    String filePath = args[0];
    int numInts = getLength(filePath);
    int[] input = createArray(filePath, numInts);

    //sort the array using dual pivot quick sort and print it out
    sort(input,0,input.length-1);
    for(int i = 0; i < input.length - 1; i++){
      System.out.print(input[i] + " ");
    }
    //print the last value without a white space
    System.out.println(input[input.length-1]);
  }

  //take in a path to a data file of integers and enter them into an array
  public static int[] createArray(String filePath, int numInts){
    File file = new File(filePath);
    int[] userInput = new int[numInts];

    //parse through the file and save each line as an integer in the array
    try {
            Scanner in = new Scanner(file);
            int i = 0;
            while (in.hasNextInt()) {
                userInput[i] = in.nextInt();
                i++;
            }
            in.close();
        }
        //in the event of an error, print the error
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    return userInput;
  }
  //parse through a file and return the number of elements
  public static int getLength(String filePath){
    int count = 0;
    File input = new File(filePath);

    //while the data file has a next element, increase the counter
    try {
            Scanner in = new Scanner(input);
            int i = 0;
            while (in.hasNextInt()) {
                count++;
                in.nextInt();
            }
            in.close();
        }
        //in the event of an error, print the error
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    return count;
  }
  //use dual pivot insertion sort to sort an array of integers
  public static void sort(int[] A, int left, int right){
    //sort the array A in index range left,...,right
    if(right - left >= 1){  //line 1
      int p = A[left]; int q = A[right];  //line 2
      if(p < q){ int temp = p; p = q; q = temp; temp = A[left]; A[left] = A[right]; A[right] = temp;}  //line 3
      int i = left + 1; int g = right - 1; int k = i; //line 4
      while(k <= g){  //line 5
        if(A[k] > p){ //line 6
          int temp = A[k]; A[k] = A[i]; A[i] = temp;  //line 7
          i++;  //line 8
        }
        else{ //line 9
          if(A[k] < q){ //line 10
            while(A[g] < q && k < g){ //line 11
              g--;
            }
            int temp = A[k];  A[k] = A[g]; A[g] = temp; //line 12
            g--;  //line 13
            if(A[k] > p){ //line 14
              temp = A[k]; A[k] = A[i]; A[i] = temp;  //line 15
              i++;  //line 16
            } //line 17
          } //line 18
        } //line 19
        k++;  //line 20
      } //line 21
      i--; g++; //line 22
      int temp = A[left]; A[left] = A[i]; A[i] = temp;  //line 23
      temp = A[right]; A[right] = A[g]; A[g] = temp;  //line 24
      sort(A, left, i-1); //line 25
      sort(A, i+1, g-1);  //line 26
      sort(A, g+1, right);  //line 27
    } //line 28
  }
}
