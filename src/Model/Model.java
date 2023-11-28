/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import OhmLogger.OhmLogger;
import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Logger;
import versuch_7.BanditData;

/**
 *
 * @author Kieran
 */


  /**
   * Model which handles Threads and Subscription / Publishing
   */
public class Model implements Subscriber <BanditData>
{
  private ModelThreads runningThread1;
  private ModelThreads runningThread2;
  private ModelThreads runningThread0;
  
  private SubmissionPublisher <BanditData> numberPublisher;
  
  private Flow.Subscription subscription0;
  private Flow.Subscription subscription1;
  private Flow.Subscription subscription2;

  private ArrayList<Flow.Subscription> subscriptions;
  
  private static Logger logger = OhmLogger.getLogger();
  /**
   * Initializing Threads and Publisher
   */
  public Model()
  {
    subscriptions = new ArrayList<>();
    runningThread0 = new ModelThreads(0);
    runningThread1 = new ModelThreads(1);
    runningThread2 = new ModelThreads(2);
    
    runningThread0.addValueSubscriber(this);
    runningThread1.addValueSubscriber(this);
    runningThread2.addValueSubscriber(this);
    
    numberPublisher = new SubmissionPublisher<>();

  }
  
  /**
   * Call start Methods of the Threads
   */
  public void start()
  {
    runningThread1.start();
    runningThread2.start();
    runningThread0.start();
  }

  /**
   * Call stop Methods of the Threads
   */
  public void stop()
  {
    runningThread1.stop();
    runningThread2.stop();
    runningThread0.stop();
    
  }

  /**
   * Add a Subscriber to the Model
   * @param subscriber Subscriber to the Model
   */
  public void addValueObserver(Flow.Subscriber<BanditData> subscriber)
  {
    numberPublisher.subscribe(subscriber);
    /*runningThread1.addValueSubscriber(subscriber);
    runningThread2.addValueSubscriber(subscriber);*/
  }
  
  /**
   * Subscribe Model to Object, and request first Object
   * @param subscription Flow.Subscription of Object this is Subscribed to
   */
  @Override
  public synchronized void onSubscribe(Flow.Subscription subscription)
  {
    subscriptions.add(subscription);
    //logger.info(subscriptions.size().valueOf());
    //create subscription arraylist 
    //subscription0 = subscription;
    logger.info("Subscription from Class" + subscription.getClass()+"\n");
    logger.info("Subscription from Class" + subscription.toString()+"\n");
    subscription.request(1);
    //this.numberPublisher.
    logger.info("Subscribed");

    //when this is subscribed to smth
    //getClass to check identity
  }

  /**
   * Publish Bandit Data when it is recieved from the Models Subscription
   * @param item Data class
   */
  @Override
  public void onNext(BanditData item)
  {
    subscriptions.get(item.getID()).request(1);
    numberPublisher.submit(item);  
    /*+
    //request from source again 
    if(item.getID()==0)
    {
        numberPublisher.submit(item);  
        subscriptions.get(item.getID()).request(1);
    }
    else if(item.getID()==1)
    {
        numberPublisher.submit(item);  
        subscription1.request(1);
    }
    else if(item.getID()==2)
    {
        numberPublisher.submit(item);  
        subscription2.request(1);
    }*/
    logger.info("Next item recievd from thread: "+String.valueOf(item.getID())+"\n");

    //when update comes from subscription0
  }

  /**
   * Log Error that is thrown
   * @param throwable Error that relates to Subscription / Publishing
   */
  @Override
  public void onError(Throwable throwable)
  {
    logger.severe(String.valueOf(throwable));
  }

  /**
   *Unused Method
   */
  @Override
  public void onComplete()
  {
  }
}
