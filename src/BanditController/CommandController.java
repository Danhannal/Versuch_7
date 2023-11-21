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
import versuch_6.*;

/**
 *
 * @author MOD-USER
 */
public class CommandController implements ActionListener
{
    MainWindowBandit view;
    WuerfelModel model;
    ValueAdapter value0Subscriber;
    ValueAdapter value1Subscriber;
    ValueAdapter value2Subscriber;
    StateAdapter stateSubscriber;
    CommandInvoker invoker;
    
    public CommandController(MainWindowBandit viewInp, WuerfelModel modelInp, ValueAdapter value0SubscriberInp, ValueAdapter value1SubscriberInp, ValueAdapter value2SubscriberInp, StateAdapter stateSubscriberInp)
    {
        view = viewInp;
        model = modelInp;
        value0Subscriber = value0SubscriberInp;
        value1Subscriber = value1SubscriberInp;
        value2Subscriber = value2SubscriberInp;
        stateSubscriber = stateSubscriberInp;
        invoker = new CommandInvoker();
    }
    
    public void registerEvents()
    {
        view.getBtnStart().addActionListener(this);
        view.getBtnStop().addActionListener(this);
        value2Subscriber.subscribe();
        //stateSubscriber.subscribe(); //not working yet
    }
    
    public void registerCommands()
    {
        invoker.addCommand(view.getBtnStart(), new StartCommand(view, model));
        invoker.addCommand(view.getBtnStop(), new StopCommand(view, model));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        var key = (Component)e.getSource();
        invoker.executeCommand(key);
    }
    
}
