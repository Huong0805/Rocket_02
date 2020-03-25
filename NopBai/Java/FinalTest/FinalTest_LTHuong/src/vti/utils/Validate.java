package vti.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is validate input.
 * 
 * @author NNDuy
 * @version 1.0
 * @Date Oct 31, 2017
 */
public class Validate {

  private Pattern pattern;
  private Matcher matcher;

  /**
   * validate email input.
   * 
   * @param input
   *          - email input
   * @return boolean
   */
  public boolean email(final String input) {
    pattern = Pattern.compile(Constants.EMAIL_PATTERN);
    matcher = pattern.matcher(input);
    return matcher.matches();
  }

  /**
   * validate birth date input.
   * 
   * @param input
   *          - birth date input
   * @return boolean
   */
  public boolean birthDate(final String input) {
    // pattern = Pattern.compile(Constants.BIRTHDATE_PATTERN);
    // matcher = pattern.matcher(input);
    // return matcher.matches();
    return true;
  }

  /**
   * validate phone input.
   * 
   * @param input
   *          - phone input
   * @return boolean
   */
  public boolean phone(final String input) {
    pattern = Pattern.compile(Constants.PHONE_PATTERN);
    matcher = pattern.matcher(input);
    return matcher.matches();
  }

  /**
   * validate experience In Year input.
   * 
   * @param input
   *          - experience In Year input
   * @return boolean
   */
  public boolean experienceInYear(final String input) {
    pattern = Pattern.compile(Constants.NUMBER_PATTERN);
    matcher = pattern.matcher(input);
    return matcher.matches();
  }

  /**
   * validate graduation Date input.
   * 
   * @param input
   *          - graduation Date input
   * @return boolean
   */
  public boolean graduationDate(final String input) {
    // pattern = Pattern.compile(Constants.PHONE_PATTERN);
    // matcher = pattern.matcher(input);
    // return matcher.matches();
    return true;
  }

  /**
   * validate graduation Rank input.
   * 
   * @param input
   *          - graduation Rank input
   * @return boolean
   */
  public boolean graduationRank(final String input) {
    return input.equals(Constants.GRADUATION_RANK_EXCELLENCE)
        || input.equals(Constants.GRADUATION_RANK_GOOD)
        || input.equals(Constants.GRADUATION_RANK_POOR)
        || input.equals(Constants.GRADUATION_RANK_FAIR);
  }

  /**
   * validate code Recruitment input.
   * 
   * @param input
   *          - graduation Rank input
   * @return boolean
   */
  public boolean codeRecruitment(final String input) {
    pattern = Pattern.compile(Constants.CODE_RECRUITMENT_PATTERN);
    matcher = pattern.matcher(input);
    return matcher.matches();
  }
}