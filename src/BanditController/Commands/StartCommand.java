/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanditController.Commands;

import BanditController.CommandInterface;
import view.MainWindowBandit;
import Model.*;

/**
 * A command to start the model
 * @author MOD-USER
 */
public class StartCommand implements CommandInterface
{
    private final MainWindowBandit view;
    private final Model model;
    
  /**
   * Constructor for the start command
   * @param viewInp The view instance the command attaches to
   * @param modelInp The model to be started by the command
   */
  public StartCommand(MainWindowBandit viewInp, Model modelInp)
    {
        view = viewInp;
        model = modelInp;
    }
    
  /**
   * Executes the start command
   */
  @Override
    public void execute() {
        view.getBtnStart().setEnabled(false);
        view.getBtnStop().setEnabled(true);
        
        model.start();
    }
    
}
