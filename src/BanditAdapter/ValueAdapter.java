/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BanditAdapter;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import javax.swing.JLabel;
import view.MainWindowBandit;
import versuch_7.*;
import Model.*;
import java.util.ArrayList;

/**
 * 
 * @author MOD-USER
 */
public class ValueAdapter implements Subscriber<BanditData>
{
    private Flow.Subscription subscription;
    private ArrayList<JLabel> labels;
    private final Model model;
    
  /**
   * The standard constructor
   * @param view The view changes will be performed to
   * @param modelInp The model to subscribe to
   */
  public ValueAdapter(MainWindowBandit view, Model modelInp)
    {
        labels = new ArrayList();
        model = modelInp;
        labels.add(view.getLblNumber0());
        labels.add(view.getLblNumber1());
        labels.add(view.getLblNumber2());
    }

  /**
   * Subscribe to the model
   */
  public void subscribe()
    {
        model.addValueObserver(this);
    }
    
  /**
   * Occurs when the class subscribed to a publisher
   * @param subscription A new subscription
   */
  @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

  /**
   * Invoked with the publishers next item
   * @param item the new BanditData item
   */
  @Override
    public void onNext(BanditData item) {
        var templabel = labels.get(item.getID());
        templabel.setText(String.valueOf(item.getValue()));
        subscription.request(1);
    }

  /**
   * Invoked when an errour occured
   * @param throwable
   */
  @Override
    public void onError(Throwable throwable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  /**
   * Invoked when all publisher invocations occured
   */
  @Override
    public void onComplete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
