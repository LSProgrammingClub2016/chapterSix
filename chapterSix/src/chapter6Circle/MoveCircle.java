package chapter6Circle;

import javax.swing.*;
import java.awt.*;
import panel.*;


public class MoveCircle 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		JFrame theGUI = new JFrame();
		//theGUI.setTitle(“GUI Program”);
		
		theGUI.setSize(300, 300);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		ColorPanel panel = new ColorPanel(Color.black, theGUI);
		Container pane = theGUI.getContentPane();
		pane.add(panel);
		
		theGUI.setVisible(true);
	}

}
