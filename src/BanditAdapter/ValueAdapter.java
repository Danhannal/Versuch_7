/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanditAdapter;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import javax.swing.JLabel;
import view.MainWindowBandit;
import versuch_6.*;

/**
 *
 * @author MOD-USER
 */
public class ValueAdapter implements Subscriber<Integer>
{
    private Flow.Subscription subscription;
    private final JLabel label;
    private final WuerfelModel model;
    
    public ValueAdapter(JLabel labelInp, WuerfelModel modelInp)
    {
        label = labelInp;
        model = modelInp;
    }

    public void subscribe()
    {
        model.addObserver(this);
    }
    
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(Integer item) {
        label.setText(String.valueOf(item));
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
