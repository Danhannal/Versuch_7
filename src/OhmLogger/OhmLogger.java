  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package OhmLogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.logging.*;
/**
 *
 * @author Kieran
 */
public class OhmLogger 
{
  private static final String LOGGER_NAME = "OhmLogger";
  private static Logger logger = null;
  private static FileHandler fh;
  /**
   * Set File Handler Path
   */
  public OhmLogger()
  {

  }
 
  /**
   * 
   * @return logger
   */
  public static Logger getLogger()
  {
    if (logger == null)
    {
      logger = Logger.getLogger(LOGGER_NAME);
      
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
  
    try (InputStream configFile = new FileInputStream("C:\\tmp\\JAVA\\TEAM-PROJEKT\\INF3_2_V5\\Versuch_7\\src\\OhmLogger\\config.properties"))
    {
      if (configFile != null)
      {
        try{
        Properties properties = new Properties();
        properties.load(configFile);
        java.util.logging.Level classLogLevel = java.util.logging.Level.parse(properties.getProperty("log.level"));
        
        logger.setLevel(classLogLevel);
        

        fh = new FileHandler(properties.getProperty("LOG_FILE"));  
                }
        catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
                
        ConsoleHandler consoleHandler = new ConsoleHandler();
        fh.setFormatter(new OhmFormatter());
        logger.setUseParentHandlers(false);
        logger.getHandlers();
        logger.addHandler(fh);
      }
      else
      {
        System.err.println("Unable to load config file. Ohm Logger is now Using standard settings...");
      }
    }
    catch(IOException | SecurityException e)
    {
      System.err.println("Error while Initializing OhmLogger: " + e.getMessage());
    }

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
    String logline = "| ";
    //| Zeitstempel | Level | Klasse (= Quelle der Meldung) | Meldung|

    LocalDateTime dateTime = LocalDateTime.now();
    logline += dateTime.toString();
    logline += " | " + record.getLevel();
    logline += " | " + record.getSourceClassName();
    logline += " | " + record.getMessage();
    logline += " |\n";
    
    return logline;
  }
}
