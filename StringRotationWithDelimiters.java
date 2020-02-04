/**
 * Given a string and a set of delimiters, reverse the words in the string while maintaining the
 * relative order of the delimiters.
 *
 * <p>For example, given "hello/world:here", return "here/world:hello"
 *
 * <p>Follow-up: Does your solution work for the following cases: "hello/world:here/",
 * "hello//world:here"
 */
import java.util.Arrays;
import java.util.List;

public class StringRotationWithDelimiters {
  private static final String DELIMITERS = "(-*&^%$#@!_/://)";

  public static void main(String[] args) {
    List<String> inputs =
        Arrays.asList(
            "hello/world:here", "quick:brown//lazy&fox", "hello/world:here/", "hello//world:here");
    inputs.stream()
        .forEach(
            input -> {
              System.out.println(solution(input));
            });
  }

  private static String solution(String input) {
    String[] words = input.split("[" + DELIMITERS + "]+");
    String[] delimiters = input.split("[^" + DELIMITERS + "]+");
    StringBuilder output = new StringBuilder();
    int totalWords = words.length - 1;
    for (int index = 0; index < delimiters.length; index++) {
      if (totalWords >= 0) {
        output.append(delimiters[index]).append(words[totalWords]);
        totalWords--;
      } else {
        output.append(delimiters[index]);
      }
    }
    // additional check to make sure if count of words is grater than delimiters
    if (totalWords > 0) {
      for (; totalWords >= 0; totalWords--) {
        output.append(words[totalWords]);
      }
    }
    return output.toString();
  }
}
