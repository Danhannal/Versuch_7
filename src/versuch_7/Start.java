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

/**
 *
 * @author MOD-USER
 */
public class Start {

    public Start()
    {
        var view = new MainWindowBandit();
        var model = new Model();
        var valueObserver = new ValueAdapter(view, model);
        var stateObserver = new StateAdapter(view, model);
        var controller = new CommandController(view, model, valueObserver, stateObserver);
        controller.registerCommands();
        controller.registerEvents();
        view.setTitle("Digitaler Würfel 2");
        view.setVisible(true);
    }
        
    public static void main(String[] args) {
        new Start();
    }
    
}
