/**
 * Write a function that rotates a list by k elements. For example, [1, 2, 3, 4, 5, 6] rotated by
 * two becomes [3, 4, 5, 6, 1, 2]
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerArrayRotation {

  public static void main(String[] args) {
    leftRotate(new int[] {1, 2, 3, 4, 5, 6}, 2);
    leftRotate(new int[] {1, 2, 3, 4, 5, 6, 7}, 3);
    leftRotate(new int[] {1, 2, 3, 4, 5, 6, 7}, 4);
  }
  
  private static void leftRotate(int[] numbers, int noOfRotation) {
    if (numbers == null
        || numbers.length < 1
        || noOfRotation < 0
        || noOfRotation == numbers.length) {
      throw new IllegalArgumentException("Inputs given are not rotatable");
    }

    System.out.println(
        "Left Rotate Array :: " + Arrays.toString(numbers) + " by " + noOfRotation + " rotations");

    System.out.println("Rotated Output :: " + Arrays.toString(rotate(numbers, noOfRotation)));
  }
  
  private static int[] rotate(int[] numbers, int noOfRotation) {
    // remove elements from 0 to noOfRotation and create a list
    List<Integer> numberList =
        IntStream.of(numbers).boxed().filter(i -> i > noOfRotation).collect(Collectors.toList());
    // add them to the list at the backside.
    for (int index = 0; index < noOfRotation; index++) {
      numberList.add(numbers[index]);
    }
    // create the array back from the list
    return numberList.stream().mapToInt(Integer::intValue).toArray();
  }
}
