package vti.utils;

import java.util.Scanner;

/**
 * This class is enter input from User
 * 
 * @author NNDuy
 * @version 1.0
 * @Date Oct 31, 2017
 */
public class Input {

  /**
   * enter input is Integer.
   * 
   * @param scanner
   *          - use Scanner to enter
   * @return int
   */
  public int readInt(Scanner scanner) {
    int result = -1;
    while (result == -1) {
      try {
        result = Integer.parseInt(scanner.nextLine());
      } catch (Exception e) {
        System.out.println(Constants.ERROR_VALIDATE);
      }
    }
    return result;
  }

  /**
   * enter input is String.
   * 
   * @param scanner
   *          - use Scanner to enter
   * @return String
   */
  public String readStr(Scanner scanner) {
    String result = scanner.nextLine();
    while (result == null || "".equals(result)) {
      System.out.println(Constants.ERROR_VALIDATE);
      result = scanner.nextLine();
    }
    // trim result
    return result.trim();
  }
}
