/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the
 * array.
 *
 * <p>Each element in the array represents your maximum jump length at that position.
 *
 * <p>Determine if you are able to reach the last index.
 *
 * <p>Example 1:
 *
 * <p>Input: [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1, then 3 steps to
 * the last index.
 *
 * <p>Input: [3,2,1,0,4] Output: false Explanation: You will always arrive at index 3 no matter
 * what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class IntegerHoping {
  public static void main(String[] args) {
    System.out.println("Hoping of number is Possible? : " + solution(new int[] {2, 3, 1, 1, 4}, 0));
    System.out.println("Hoping of number is Possible? : " + solution(new int[] {1, 1, 0, 1}, 0));
    System.out.println("Hoping of number is Possible? : " + solution(new int[] {2, 0, 1, 0}, 0));
    System.out.println("Hoping of number is Possible? : " + solution(new int[] {3, 2, 1, 0, 4}, 0));
  }

  private static boolean solution(int[] numbers, int startingPosition) {
    if (startingPosition == numbers.length - 1) {
      return Boolean.TRUE;
    }

    int furthestNumber = Math.min(numbers[startingPosition] + startingPosition, numbers.length - 1);

    for (int nextPosition = furthestNumber; nextPosition > startingPosition; nextPosition--) {
      if (solution(numbers, nextPosition)) {
        return Boolean.TRUE;
      }
    }

    return Boolean.FALSE;
  }
}
