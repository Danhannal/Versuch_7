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
  * Data class which is used to transfer a value and an ID
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
   *
   * @param newValue
   * 
   * This method gives access to the value of the Data Class
   */
  public void changeValue(int newValue)
  {
    value = newValue;
  }

  /**
   *
   * @return value
   * 
   * This method returns the value of the Data Class
   */
  public int getValue()
  {
    return value;
  }

  /**
   *
   * @return ID
   * 
   * This method returns the thread ID it is used in
   */
  public int getID()
  {
    return ID;
  }
}
