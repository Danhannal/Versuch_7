/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanditAdapter;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import javax.swing.JLabel;
import view.MainWindowBandit;
import versuch_7.*;
import Model.*;
import view.MainWindow;

/**
 *
 * @author MOD-USER
 */
public class ValueAdapter implements Subscriber<BanditData>
{
    private Flow.Subscription subscription;
    private List<JLabel> labels;
    private final Model model;
    
    public ValueAdapter(MainWindowBandit view, Model modelInp)
    {
        model = modelInp;
        labels.add(view.getLblNumber0());
        labels.add(view.getLblNumber1());
        labels.add(view.getLblNumber2());
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
    public void onNext(BanditData item) {
        var templabel = labels.get(item.getID());
        templabel.setText(String.valueOf(item.getValue()));
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
