/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanditController;

import BanditAdapter.*;
import BanditController.Commands.StartCommand;
import BanditController.Commands.StopCommand;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainWindowBandit;
import Model.*;

/**
 *
 * @author MOD-USER
 */
public class CommandController implements ActionListener
{
    MainWindowBandit view;
    Model model;
    ValueAdapter valueSubscriber;
    StateAdapter stateSubscriber;
    CommandInvoker invoker;
    
  /**
   *
   * @param viewInp
   * @param modelInp
   * @param valueSubscriberInp
   * @param stateSubscriberInp
   */
  public CommandController(MainWindowBandit viewInp, Model modelInp, ValueAdapter valueSubscriberInp, StateAdapter stateSubscriberInp)
    {
        view = viewInp;
        model = modelInp;
        valueSubscriber = valueSubscriberInp;
        stateSubscriber = stateSubscriberInp;
        invoker = new CommandInvoker();
    }
    
  /**
   *
   */
  public void registerEvents()
    {
        view.getBtnStart().addActionListener(this);
        view.getBtnStop().addActionListener(this);
        valueSubscriber.subscribe();
        //stateSubscriber.subscribe(); //not working yet
    }
    
  /**
   *
   */
  public void registerCommands()
    {
        invoker.addCommand(view.getBtnStart(), new StartCommand(view, model));
        invoker.addCommand(view.getBtnStop(), new StopCommand(view, model));
    }
    
  /**
   *
   * @param e
   */
  @Override
    public void actionPerformed(ActionEvent e) {
        var key = (Component)e.getSource();
        invoker.executeCommand(key);
    }
    
}
