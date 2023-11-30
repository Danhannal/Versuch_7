/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package versuch_7;

import BanditAdapter.*;
import BanditController.CommandController;
import Model.Model;
import view.MainWindowBandit;
import Model.*;
import OhmLogger.OhmLogger;

/**
 * The class handling and creating the app
 * @author MOD-USER
 */
public class Start {

  /**
   * The constructor to create the application
   */
  public Start()
    {
        OhmLogger logger = new OhmLogger();
        var view = new MainWindowBandit();
        var model = new Model();
        var valueObserver = new ValueAdapter(view, model);
        var stateObserver = new StateAdapter(view, model);
        var controller = new CommandController(view, model, valueObserver, stateObserver);
        controller.registerCommands();
        controller.registerEvents();
        view.setTitle("Einarmiger Bandit");
        view.setVisible(true);
    }
        
  /**
   * The function which will be called by the OS to run the application
   * @param args The arguments
   */
  public static void main(String[] args) {
        new Start();
    }
    
}
