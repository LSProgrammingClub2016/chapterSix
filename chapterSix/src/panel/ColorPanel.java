package panel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //For the mouse events


// Note that this class was modified from the chapter example such that
// the event handler, PanelListener, could be made into a public class, 
// rather than a  private, embedded class as shown by the author.   This 
// then requires that public Accessors to ColorPanel be made available.
// these are used by the event handler.
// When the PanelListener is a private contained class, it is able to access
// the private circle data directly - poor OO practice.
public class ColorPanel extends JPanel
{
	private Circle _c1; 
	private Circle _c2;
	private Circle _selectedCircle; // Used to track selected shape
	private int _x, _y; // Used to track mouse coordinates

	public ColorPanel(Color backColor, JFrame parent)
	{

		setBackground(backColor);
		_c1 = new Circle(200, 100, 25, Color.red);
		_c2 = new Circle(100, 100, 50, Color.blue);
		
		
		int [] panelCoordinates = new int[2];
		panelCoordinates [0] = 0;
		panelCoordinates [1] = 0;
		
		boolean result  = checkNeededPanelSize (panelCoordinates);
		if (result)
		{
			parent.setSize (panelCoordinates[0], panelCoordinates[1]);
		}
		else
		{
			parent.setSize(300,300);
		}
		
		_selectedCircle = null;
		
		// event handlers
		addMouseListener(new PanelListener());
		addMouseMotionListener(new PanelMotionListener());
	}

    private boolean checkNeededPanelSize (int[] coordinates)
    {
    	// do some calculation; use the circle sizes for
    	// _c1 and _c2
    	coordinates[0] = 600;
    	coordinates[1] = 400;
    	
    	
    	return true;
    }
    
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // in JComponent
		_c1.fill(g);
		_c2.draw(g);
	}
	
	//accessors added so that the PanelListener can be a public class
	public Circle getCircleOne ()
	{
		return _c1;
	}
	
	public Circle getCircleTwo ()
	{
		return _c2;
	}
	
	public void setSelectedCircle (Circle selection)
	{
		_selectedCircle = selection;
	}
	
	public void setMouseCoordinates (int xCoord, int yCoord)
	{
		_x = xCoord;
		_y = yCoord;
	}
	
	
	
	private class PanelListener extends MouseAdapter
	{
	
		public void mousePressed(MouseEvent e)
		{
			// Select a circle if it contains the mouse coordinates
		    // save the coordinates for dragging
			_x = e.getX();
			_y = e.getY();
			
			if (_c1.containsPoint(_x, _y))
			{
				_selectedCircle = _c1;
			}
			else if (_c2.containsPoint(_x, _y))
			{
				_selectedCircle = _c2;
			}
		}
		
		
		public void mouseReleased(MouseEvent e)
		{
		// Deselect the selected circle
			_selectedCircle = null;
		}
	}//PanelListener
	

	private class PanelMotionListener extends MouseMotionAdapter
	{
		public void mouseDragged(MouseEvent e)
		{
			if (_selectedCircle != null)
			{
				// Compute the distance and move the selected circle
				int newX = e.getX();
				int newY = e.getY();
				int dx = newX - _x;
				int dy = newY - _y;
				_selectedCircle.move(dx, dy);
				_x = newX;
				_y = newY;
				
				repaint();
			}
		}
	}
		
}//ColorPanel


