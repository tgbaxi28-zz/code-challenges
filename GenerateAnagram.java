/* Generate all permutations of a string */
public class GenerateAnagram {
  public static void main(String[] args) {
    String s = "ABC";
    permutations("", s);
  }

  private static void permutations(String candidate, String remaining) {
    if (remaining.length() == 0) {
      System.out.println(candidate);
    }

    for (int i = 0; i < remaining.length(); i++) {
      String newCandidate = candidate + remaining.charAt(i);
      String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
      permutations(newCandidate, newRemaining);
    }
  }
}
