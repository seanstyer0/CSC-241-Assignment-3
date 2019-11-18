/*
Name: Sean Styer
File: BubbleSort.java
Input: Path to a .txt file of integers
Output: One sorted array using bubble sort
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class BubleSort{
  public static void main(String[] args){
    //take in the provided file path and convert the data file into an array
    String filePath = args[0];
    int numInts = getLength(filePath);
    int[] input = createArray(filePath, numInts);

    //sort and print the sorted array one element per line
    sort(input);

    for(int i = 0; i < input.length - 1; i++){
      System.out.print(input[i] + " ");
    }
    System.out.print(input[input.length - 1]);
  }

  //sort an array of integers using bubble sort
  public static void sort(int[] A){
    //B1
    int bound = A.length - 1;
    //B2
    int t = 0;
    while(true){
      t = 0;
      for (int j = 0; j < bound; j++){
        //B3
        if(A[j] > A[j+1]){
          swapElements(A,j,j+1);
          t = j;
        }
      }
      if(t == 0){
        break;
      }
      else{
        bound = t;
      }
    }
  }

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

  public static void swapElements(int[] A, int a, int b){
    int temp = A[a];
    A[a] = A[b];
    A[b] = temp;
  }
}
