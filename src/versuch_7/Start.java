/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package versuch_7;

import BanditAdapter.*;
import BanditController.CommandController;
import view.MainWindowBandit;
import versuch_6.WuerfelModel;

/**
 *
 * @author MOD-USER
 */
public class Start {

    public Start()
    {
        var view = new MainWindowBandit();
        var model = new WuerfelModel();
        var valueObserver = new ValueAdapter(view.getLblNumber2(), model);
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
