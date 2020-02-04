/**
 * Given a string of words delimited by spaces, reverse the words in string.
 *
 * <p>For example, given "hello world here", return "here world hello"
 */

import java.util.Arrays;
import java.util.List;

public class StringRotation {
  public static void main(String[] args) {
    List<String> inputs =
        Arrays.asList(
            "hello world here", "quick brown lazy fox", "string of words delimited by spaces");
    inputs.stream()
        .forEach(
            input -> {
              System.out.println(
                  "Rotated String of :: " + input + " :: is - " + solution(input, " "));
            });
  }

  private static String solution(String input, String splitCharacter) {
    String[] inputWords = input.trim().split(splitCharacter);
    StringBuilder words = new StringBuilder();

    for (int index = inputWords.length - 1; index >= 0; index--) {
      words = words.append(inputWords[index]).append(" ");
    }

    return words.toString().trim();
  }
}
