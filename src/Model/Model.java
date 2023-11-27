/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import OhmLogger.OhmLogger;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.SubmissionPublisher;
import java.util.logging.Logger;
import versuch_7.BanditData;

/**
 *
 * @author Kieran
 */

//add javadoc

  /**
   * Model which handles Threads and Subscription / Publishing
   */
public class Model implements Subscriber <BanditData>
{
  private ModelThreads runningThread1;
  private ModelThreads runningThread2;
  private ModelThreads runningThread0;
  
  private SubmissionPublisher <BanditData> numberPublisher;
  private Flow.Subscription subscription;

  private static Logger logger = OhmLogger.getLogger();
  /**
   * Initializing Threads and Publisher
   */
  public Model()
  {
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
  public void onSubscribe(Flow.Subscription subscription)
  {
    this.subscription = subscription;
    subscription.request(1);
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
    numberPublisher.submit(item);  
    subscription.request(1);
    logger.info("Next item recievd from thread: "+String.valueOf(item.getID()));

    //when update comes from subscription
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
