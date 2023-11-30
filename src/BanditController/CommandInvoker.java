/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanditController;

import java.awt.Component;
import java.util.HashMap;

/**
 * Manages all supported commands from the application
 * @author MOD-USER
 */
public class CommandInvoker 
{
    private HashMap<Component, CommandInterface> commands;
    
  /**
   * The standard constructor
   */
  public CommandInvoker()
    {
        commands = new HashMap<Component, CommandInterface>();
    }
    
  /**
   * Adds a new command to be called by the desired action source
   * @param key An instance of the action source
   * @param value An instance of the command to add
   */
  public void addCommand(Component key, CommandInterface value)
    {
        commands.put(key, value);
    }
    
  /**
   * Executes a previously added command for the action source
   * @param key
   */
  public void executeCommand(Component key)
    {
        commands.get(key).execute();
    }
}
