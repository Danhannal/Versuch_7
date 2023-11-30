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
 * Connects actions from the view to commands to be executed
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
   * The constructor for the command controller
   * @param viewInp The view the events are attached to
   * @param modelInp The model to execute actions
   * @param valueSubscriberInp The subscriber for new value events from the model
   * @param stateSubscriberInp The subscriber for new state events from the model
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
   * Registers the action listeners and subscribers
   */
  public void registerEvents()
    {
        view.getBtnStart().addActionListener(this);
        view.getBtnStop().addActionListener(this);
        valueSubscriber.subscribe();
        //stateSubscriber.subscribe(); //not working yet
    }
    
  /**
   * Registers the commands that can be executed
   */
  public void registerCommands()
    {
        invoker.addCommand(view.getBtnStart(), new StartCommand(view, model));
        invoker.addCommand(view.getBtnStop(), new StopCommand(view, model));
    }
    
  /**
   * Occurs when a button of the view is pressed
   * @param e The event data
   */
  @Override
    public void actionPerformed(ActionEvent e) {
        var key = (Component)e.getSource();
        invoker.executeCommand(key);
    }
    
}
