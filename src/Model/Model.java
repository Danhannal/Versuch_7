/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

/**
 *
 * @author Kieran
 */
public class Model 
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
    //V1 start publishing thread
    //runningThread.statusPublisher.submit(true);

    //V2 create thread to run in
    //V3 notify to exit wait state of thread
  }
    public void stop()
  {
    //V1 Stop publishing
   
    //runningThread.statusPublisher.submit(false);
    runningThread1.stop();
    runningThread2.stop();
    runningThread3.stop();
    //V2 destroy thread
    //V3 wait thread
  }
}
