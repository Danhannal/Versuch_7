/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import versuch_7.BanditData;

/**
 *
 * @author Kieran
 */

//add javadoc


public class Model implements Subscriber <BanditData>
{
  private ModelThreads runningThread1;
  private ModelThreads runningThread2;
  private ModelThreads runningThread0;
  
  private SubmissionPublisher <BanditData> numberPublisher;
  private Flow.Subscription subscription;

  public Model()
  {
    runningThread0 = new ModelThreads(0);
    runningThread1 = new ModelThreads(1);
    runningThread2 = new ModelThreads(2);
    
    
    numberPublisher = new SubmissionPublisher<>();

  }
  
  public void start()
  {
    runningThread1.start();
    runningThread2.start();
    runningThread0.start();
  }
    public void stop()
  {
    runningThread1.stop();
    runningThread2.stop();
    runningThread0.stop();

  }
  public void addValueObserver(Flow.Subscriber<BanditData> subscriber)
  {
    numberPublisher.subscribe(subscriber);
    /*runningThread1.addValueSubscriber(subscriber);
    runningThread2.addValueSubscriber(subscriber);*/
  }
  
  @Override
  public void onSubscribe(Flow.Subscription subscription)
  {
    this.subscription = subscription;
    subscription.request(1);
    //when this is subscribed to smth
    //getClass to check identity
  }

  @Override
  public void onNext(BanditData item)
  {
    numberPublisher.submit(item);  
    subscription.request(1);

    //when update comes from subscription
  }

  @Override
  public void onError(Throwable throwable)
  {
    //add logger
  }

  @Override
  public void onComplete()
  {
  }
}
