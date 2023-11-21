/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanditAdapter;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import view.MainWindowBandit;
import versuch_6.*;

/**
 *
 * @author MOD-USER
 */
public class StateAdapter implements Subscriber<Boolean>
{
    private Flow.Subscription subscription;
    private final MainWindowBandit view;
    private final WuerfelModel model;
    
    public StateAdapter(MainWindowBandit viewInp, WuerfelModel modelInp)
    {
        view = viewInp;
        model = modelInp;
    }
    
    public void subscribe()
    {
        //model.addStateObserver(this);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Boolean item) {
        view.getBtnStart().setEnabled(item);
        view.getBtnStop().setEnabled(!item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void onComplete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
