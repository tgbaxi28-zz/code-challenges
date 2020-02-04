/**
 * Given a sorted list of integers, square the elements and give the output in sorted order.
 *
 * <p>For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
 */
 
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquareAndSort {
  public static void main(String[] args) {
    System.out.println(arrayToString(solution(new int[] {-9, -2, 0, 2, 3})));
  }
  
  private static int[] solution(int[] numbers) {
    System.out.println("Input: " + arrayToString(numbers));
    System.out.print("Squared and Sorted Output would be : ");
    return IntStream.of(numbers).map(number -> Double.valueOf(Math.pow(number, 2)).intValue())
        .boxed().collect(Collectors.toList()).stream()
        .mapToInt(Integer::intValue)
        .sorted()
        .toArray();
  }
  
  private static String arrayToString(int[] numbers) {
    return IntStream.of(numbers).mapToObj(Integer::toString).collect(Collectors.joining(","));
  }
}
