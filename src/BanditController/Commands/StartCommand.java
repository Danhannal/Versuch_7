/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanditController.Commands;

import BanditController.CommandInterface;
import view.MainWindowBandit;
import versuch_6.*;

/**
 *
 * @author MOD-USER
 */
public class StartCommand implements CommandInterface
{
    private final MainWindowBandit view;
    private final WuerfelModel model;
    
    public StartCommand(MainWindowBandit viewInp, WuerfelModel modelInp)
    {
        view = viewInp;
        model = modelInp;
    }
    
    @Override
    public void execute() {
        view.getBtnStart().setEnabled(false);
        view.getBtnStop().setEnabled(true);
        
        model.start();
    }
    
}
