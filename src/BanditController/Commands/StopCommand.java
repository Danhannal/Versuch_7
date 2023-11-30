/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanditController.Commands;

import BanditController.CommandInterface;
import view.MainWindowBandit;
import Model.*;

/**
 * A command to stop the model
 * @author MOD-USER
 */
public class StopCommand implements CommandInterface
{
    private final MainWindowBandit view;
    private final Model model;
    
  /**
   * Constructor for the stop command
   * @param viewInp The view instance the command attaches to
   * @param modelInp The model to be started by the command
   */
  public StopCommand(MainWindowBandit viewInp, Model modelInp)
    {
        view = viewInp;
        model = modelInp;
    }
    
  /**
   * Executes the stop command
   */
  @Override
    public void execute() {
        view.getBtnStart().setEnabled(true);
        view.getBtnStop().setEnabled(false);
        
        model.stop();
    }
    
}
