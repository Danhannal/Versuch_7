/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanditController.Commands;

import BanditController.CommandInterface;
import view.MainWindowBandit;
import Model.*;

/**
 *
 * @author MOD-USER
 */
public class StopCommand implements CommandInterface
{
    private final MainWindowBandit view;
    private final Model model;
    
  /**
   *
   * @param viewInp
   * @param modelInp
   */
  public StopCommand(MainWindowBandit viewInp, Model modelInp)
    {
        view = viewInp;
        model = modelInp;
    }
    
  /**
   *
   */
  @Override
    public void execute() {
        view.getBtnStart().setEnabled(true);
        view.getBtnStop().setEnabled(false);
        
        model.stop();
    }
    
}
