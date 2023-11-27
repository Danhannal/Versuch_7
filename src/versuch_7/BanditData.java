/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package versuch_7;

/**
 *
 * @author Kieran
 */







//add javadoc


public class BanditData 
{
  private int value;
  private final int ID;
  public BanditData(int inputValue, int inputID)
  {
    value = inputValue;
    ID = inputID;
  }
  public void changeValue(int newValue)
  {
    value = newValue;
  }
  public int getValue()
  {
    return value;
  }
  public int getID()
  {
    return ID;
  }
}
