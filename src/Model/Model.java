/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
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
  
/*  private Thread thrd1;
  private Thread thrd2;
  private Thread thrd3;*/
  
  //private boolean threadRunning = false;
  
  
  public Model()
  {
    runningThread0 = new ModelThreads(0);
    runningThread1 = new ModelThreads(1);
    runningThread2 = new ModelThreads(2);
  }
  
  public void start()
  {
    /*if(threadRunning == false)
    {
    thrd1 = new Thread(runningThread1);
    thrd1.start();
    
    thrd2 = new Thread(runningThread2);
    thrd2.start();
    
    thrd3 = new Thread(runningThread0);
    thrd3.start();
    
    
    runningThread1.start();
    runningThread2.start();
    runningThread0.start();
    threadRunning = true;
    }
    else{ */   
    runningThread1.start();
    runningThread2.start();
    runningThread0.start();
      //thd.notify();
    //}
  }
    public void stop()
  {
    runningThread1.stop();
    runningThread2.stop();
    runningThread0.stop();

  }
  public void addValueObserver(Flow.Subscriber<BanditData> subscriber)
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
  public void onNext(BanditData item)
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
