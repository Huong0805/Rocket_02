package vti.utils;

/**
 * This class is declare variable constants.
 * 
 * @author NNDuy
 * @version 1.0
 * @Date Oct 31, 2017
 */
public class Constants {

  // Create a variable for the connection string database.
  // download driver here: https://o7planning.org/vi/10227/thu-vien-dieu-khien-cac-loai-co-so-du-lieu-khac-nhau-trong-java
  
  // SQL Server
  //public static final String CONNECTION_STRING = "jdbc:sqlserver://localhost;databasename=JavaFinalTest;integratedSecurity=true;CharacterSet=UTF-8;";
  //public static final String DRIVER_SQL_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  
  
  // MySQL
  public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/JavaFinalTest?autoReconnect=true&useSSL=false";
  public static final String DRIVER_SQL_NAME = "com.mysql.cj.jdbc.Driver";
  public static final String DATABASE_USERNAME = "root";
  public static final String DATABASE_PASSWORD = "root";
  
  // declare message for connect database
  public static final String ERROR_CONNECT_DATABASE_STR = "Error! connect database.";
  public static final String ERROR_DISCONNECT_DATABASE_STR = "Error! disconnect database.";
  public static final int ERROR_CONNECT_DATABASE_INT = -1;
  public static final int ERROR_SQL_EXCEPTION_INT = -2;
  public static final String ERROR_DRIVER_NAME = "Error! driver name.";
  public static final String SUCCESS = "Success!";
  public static final String ERROR = "Error";
  public static final String SUCCESS_REGISTER_PACKAGE = "Submitted this candidate successfully";
  public static final String ERROR_REGISTER_PACKAGE = "Submitted this candidate "
      + "NOT successfully...";
  public static final String NOT_EXITS_EMAIL_REGISTER_PACKAGE = "Not Email in Database";
  public static final String NOT_EXITS_CODE_RECRUITMENT_REGISTER_PACKAGE = "Not code "
      + "recruitment in Database";
  // format
  public static final String FORMAT_NAME_COLUMN_BASE_CADIDATE = "%-30s %-30s %-30s %-30s "
      + "%-30s %-30s";
  public static final String FORMAT_VALUES_COLUMN_BASE_CADIDATE = "%-30s %-30s %-30s %-30s "
      + "%-30s %-30s";
  public static final String FORMAT_NAME_COLUMN_EXPERIENCE = "%-30s %-30s";
  public static final String FORMAT_VALUES_COLUMN_EXPERIENCE = "%-30d %-30s";
  public static final String FORMAT_NAME_COLUMN_FRESHER = "%-30s %-30s %-30s";
  public static final String FORMAT_VALUES_COLUMN_FRESHER = "%-30s %-30s %-30s";
  public static final String FORMAT_NAME_COLUMN_INTERN = "%-30s %-30s %-30s";
  public static final String FORMAT_VALUES_COLUMN_INTERN = "%-30s %-30d %-30s";

  // declare name table and name field

  public static final int CANDIDATE_TYPE_EXPERIENCE = 0;
  public static final int CANDIDATE_TYPE_FRESHER = 1;
  public static final int CANDIDATE_TYPE_INTERN = 2;

  // declare pattern validate
  public static final String ERROR_VALIDATE = "Invalid value, input again!";
  public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
  public static final String BIRTHDATE_PATTERN = "";
  public static final String GRADUATION_DATE_PATTERN = "";
  public static final String NUMBER_PATTERN = "^[0-9][0-9]?$|^100$";
  public static final String CODE_RECRUITMENT_PATTERN = "^[0-9]{5,}$";
  public static final String DATE_PATTERN = "\\d{4}-[01]";
  public static final String PHONE_PATTERN = "^[1-9]{7,}$";
  public static final String GRADUATION_RANK_EXCELLENCE = "Excellence";
  public static final String GRADUATION_RANK_GOOD = "Good";
  public static final String GRADUATION_RANK_POOR = "Poor";
  public static final String GRADUATION_RANK_FAIR = "Fair";
}
