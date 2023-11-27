  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package OhmLogger;

import java.time.LocalDateTime;
import java.util.logging.*;
/**
 *
 * @author Kieran
 */
public class OhmLogger 
{
  private static Logger logger = null;

  /**
   *
   */
  public OhmLogger()
  {
  }
  
  /**
   *
   * @return
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
  
  private static void initLogger()
  {
    ConsoleHandler consoleHandler = new ConsoleHandler();
    consoleHandler.setFormatter(new OhmFormatter());
    logger.addHandler(consoleHandler);
  }
}

class OhmFormatter extends SimpleFormatter
{
  @Override
  public String format(LogRecord record)
  {
    String logline = "";
    
    LocalDateTime dateTime = LocalDateTime.now();
    logline += dateTime.toString();
    logline += ";" + record.getMessage();
    logline += "\n";
    
    return logline;
  }
}
