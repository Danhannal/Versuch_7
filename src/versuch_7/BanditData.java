/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package versuch_7;

/**
 *
 * @author Kieran
 * 
 */

/**
  * Data class which holds a value and an ID
 */
public class BanditData 
{
  private int value;
  private final int ID;

  /**
   *
   * @param inputValue
   * @param inputID
   */
  public BanditData(int inputValue, int inputID)
  {
    value = inputValue;
    ID = inputID;
  }

  /**
   * This method gives access to the value of the Data Class
   * @param newValue
   * 
   * 
   */
  public void changeValue(int newValue)
  {
    value = newValue;
  }

  /**
   * This method returns the value of the Data Class
   * @return value
   * 
   *
   */
  public int getValue()
  {
    return value;
  }

  /**
   * This method returns the thread ID it is used in
   * @return ID
   * 
   * 
   */
  public int getID()
  {
    return ID;
  }
}
