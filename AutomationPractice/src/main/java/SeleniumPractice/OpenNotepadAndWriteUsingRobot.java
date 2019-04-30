package SeleniumPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
public class OpenNotepadAndWriteUsingRobot {

public static void main(String[] args) throws IOException, AWTException {
	
      Runtime.getRuntime().exec("notepad");

      Robot robot = new Robot();
      
      robot.keyPress(KeyEvent.VK_M);
      robot.keyRelease(KeyEvent.VK_M);

      robot.keyPress(KeyEvent.VK_A);
      robot.keyRelease(KeyEvent.VK_A);

      robot.keyPress(KeyEvent.VK_H);
      robot.keyRelease(KeyEvent.VK_H);

      robot.keyPress(KeyEvent.VK_E);
      robot.keyRelease(KeyEvent.VK_E);

      robot.keyPress(KeyEvent.VK_S);
      robot.keyRelease(KeyEvent.VK_S);

      robot.keyPress(KeyEvent.VK_H);
      robot.keyRelease(KeyEvent.VK_H);

	}

}
