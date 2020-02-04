/**
 * Given a string, return whether it represents a number.
 *
 * <p>Here are the different kinds of numbers:
 *
 * <p>"10", a positive integer
 *
 * <p>"-10", a negative integer
 *
 * <p>"10.1", a positive real number
 *
 * <p>"-10.1", a negative real number
 *
 * <p>"1e5", a number in scientific notation
 *
 * <p>And here are examples of non-numbers:
 *
 * <p>"a" "x 1" "a -2" "-"
 */
public class CheckNumericStrings {

  public static void main(String[] args) {
    System.out.println(isNumeric("10"));
    System.out.println(isNumeric("-10"));
    System.out.println(isNumeric("10.1"));
    System.out.println(isNumeric("-10.1"));
    System.out.println(isNumeric("1e5"));
    System.out.println(isNumeric("a"));
    System.out.println(isNumeric("x 1"));
    System.out.println(isNumeric("a-2"));
    System.out.println(isNumeric("-"));
    System.out.println(isNumeric("+10"));
  }

  // use NumberUtils.isCreatable instead of the custom method when we want to check hexa
  private static boolean isNumeric(String numericStr) {
    System.out.print("" + numericStr + " is a Numeric String? ");
    if (numericStr.isEmpty()) {
      return false;
    }
    final char[] numericCharacters = numericStr.toCharArray();
    // check if the string starts with any signs or not
    int index = numericCharacters[0] == '-' || numericCharacters[0] == '+' ? 1 : 0;
    boolean isNumeric = Boolean.FALSE;
    // normal string numeric string + scientific
    for (; index < numericCharacters.length; index++) {
      if (Character.isDigit(numericCharacters[index])
          || (index != 0 && (numericCharacters[index] == 'e' || numericCharacters[index] == '.'))) {
        isNumeric = Boolean.TRUE;
      } else {
        return Boolean.FALSE;
      }
    }
    return isNumeric;
  }
}
