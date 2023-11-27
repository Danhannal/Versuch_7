/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package versuch_7;

import BanditAdapter.*;
import BanditController.CommandController;
import Model.Model;
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
        var model = new Model();
        var value0Observer = new ValueAdapter(view.getLblNumber2(), model);
        var value1Observer = new ValueAdapter(view.getLblNumber1(), model);
        var value2Observer = new ValueAdapter(view.getLblNumber2(), model);
        var stateObserver = new StateAdapter(view, model);
        var controller = new CommandController(view, model, value0Observer, value1Observer, value0Observer, stateObserver);
        controller.registerCommands();
        controller.registerEvents();
        view.setTitle("Digitaler Würfel 2");
        view.setVisible(true);
    }
        
    public static void main(String[] args) {
        new Start();
    }
    
}
