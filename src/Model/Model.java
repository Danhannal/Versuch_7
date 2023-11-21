/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

/**
 *
 * @author Kieran
 */
public class Model implements Subscriber <Integer>
{
  private ModelThreads runningThread1;
  private ModelThreads runningThread2;
  private ModelThreads runningThread3;
  
  private Thread thrd1;
  private Thread thrd2;
  private Thread thrd3;
  
  private boolean threadRunning = false;
  
  
  public Model()
  {
  
  }
  
  public void start()
  {
    if(threadRunning == false)
    {
    thrd1 = new Thread(runningThread1);
    thrd1.start();
    
    thrd2 = new Thread(runningThread2);
    thrd2.start();
    
    thrd3 = new Thread(runningThread3);
    thrd3.start();
    
    
    runningThread1.start();
    runningThread2.start();
    runningThread3.start();
    threadRunning = true;
    }
    else{    
    runningThread1.start();
    runningThread2.start();
    runningThread3.start();
      //thd.notify();
    }
  }
    public void stop()
  {
    runningThread1.stop();
    runningThread2.stop();
    runningThread3.stop();

  }
  public void addValueObserver(Flow.Subscriber<Integer> subscriber, int ID)
  {
    //runningThread.addValueSubscriber(subscriber);
  }
  @Override
  public void onSubscribe(Flow.Subscription subscription)
  {
    //when this is subscribed to smth
    //getClass to check identity
  }

  @Override
  public void onNext(Integer item)
  {
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
