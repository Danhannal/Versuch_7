/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package versuch_7;

/**
 *
 * @author Kieran
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
   */
  public void changeValue(int newValue)
  {
    value = newValue;
  }

  /**
   *
   * @return
   */
  public int getValue()
  {
    return value;
  }

  /**
   *
   * @return
   */
  public int getID()
  {
    return ID;
  }
}
