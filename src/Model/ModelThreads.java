/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import versuch_7.BanditData;

/**
 *
 * @author Kieran
 */
public class ModelThreads implements Runnable
{
  private int runFrom = 1;
  private int runTo = 6;
  private BanditData currentNumber;
  
  public volatile boolean running;
  
  private ExecutorService eService;
  private SubmissionPublisher <BanditData> numberPublisher;
  //public SubmissionPublisher <Boolean> statusPublisher;
  
  public ModelThreads(int ID)
  {
    //add constructor with reference number
    currentNumber = new BanditData(runFrom,ID);
    
    eService = Executors.newSingleThreadExecutor();
    numberPublisher = new SubmissionPublisher<>();
    //statusPublisher = new SubmissionPublisher<>();
  }
  public void addValueSubscriber(Flow.Subscriber<BanditData> subscriber)
  {
    numberPublisher.subscribe();
  }
  public synchronized void stop()
  {
     running = false;
     //set var that causes this.wait in run that uses while

   }
   public synchronized void start()
   {
     running = true;
     //add executeer service
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
