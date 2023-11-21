/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 *
 * @author Kieran
 */
public class ModelThreads implements Runnable
{
  private int runFrom = 1;
  private int runTo = 6;
  private int currentNumber;
  
  public volatile boolean running;
  
  private ExecutorService eService;
  private SubmissionPublisher <Integer> numberPublisher;
  //public SubmissionPublisher <Boolean> statusPublisher;
  
  public ModelThreads()
  {
    //add constructor with reference number
    eService = Executors.newSingleThreadExecutor();
    numberPublisher = new SubmissionPublisher<>();
    //statusPublisher = new SubmissionPublisher<>();
  }
  public void addValueSubscriber(Flow.Subscriber<Integer> subscriber)
  {
    numberPublisher.subscribe(subscriber);
  }
  public synchronized void stop()
  {
     running = false;
     //set var that causes this.wait in run that uses while

   }
   public synchronized void start()
   {
     running = true;
     this.notify();
   }

  @Override
  public void run()
  {
  while(true)
    {
      while(!running)
      {
        try{synchronized(this){this.wait();}}
        catch(InterruptedException e){e.printStackTrace();}
      }
      try
      {
        Thread.sleep(20);
      }
      catch(InterruptedException exception)
      {
        //Logger.getLogger(WuerfelModel.class.getName().severe(exception.toString()));
      }
      if(currentNumber >= runTo){currentNumber = runFrom;}
      else{currentNumber +=1;}
      //publish new number

      numberPublisher.submit(currentNumber);  
      //submit an object with ID
    }
  }
  
}
