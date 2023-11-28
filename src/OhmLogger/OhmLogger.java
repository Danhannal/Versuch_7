  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package OhmLogger;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.*;
/**
 *
 * @author Kieran
 */
public class OhmLogger 
{
  private static Logger logger = null;
  private static FileHandler fh;
  /**
   * Set File Handler Path
   */
  public OhmLogger()
  {
    try{
    fh = new FileHandler("C:/temp/JAVA/TEAM-PROJEKT/INF3_2_V5/Versuch_7/MyLogFile.log");  
    //C:\tmp\JAVA\TEAM-PROJEKT\INF3_2_V5\Versuch_7
    }
    catch (SecurityException e) {  
        e.printStackTrace();  
    } catch (IOException e) {  
        e.printStackTrace();  
    }  
  }
  
  /**
   * 
   * @return logger
   */
  public static Logger getLogger()
  {
    if (logger == null)
    {
      logger = Logger.getLogger("OhmLogger");
      
      initLogger();
    }
    return logger;
  }
    /**
   * 
   * initialize Logger 
   * set Formatting and add File Handler
   */
  private static void initLogger()
  {
    ConsoleHandler consoleHandler = new ConsoleHandler();
    fh.setFormatter(new OhmFormatter());
    logger.addHandler(fh);
  }
}

class OhmFormatter extends SimpleFormatter
{
    /**
   * Set the Formatting Rules
   * @return formatted Log
   */
  @Override
  public String format(LogRecord record)
  {
    String logline = "";
    //| Zeitstempel | Level | Klasse (= Quelle der Meldung) | Meldung|

    LocalDateTime dateTime = LocalDateTime.now();
    logline += dateTime.toString();
    logline += ";" + record.getMessage();
    logline += "\n";
    
    return logline;
  }
}
