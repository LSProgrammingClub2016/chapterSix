package panel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PanelListener extends MouseAdapter
{
	Circle _selectedCircle = null;
	Circle _c1 = null;
	Circle _c2 = null;
	
	int _x = 0;
	int _y = 0;
	
	ColorPanel _owningPanel = null;

	public PanelListener (JPanel panel)
	{
		_owningPanel = (ColorPanel) panel;
		_c1 = _owningPanel.getCircleOne();
		_c2 = _owningPanel.getCircleTwo();
	}
	
	public void mousePressed(MouseEvent e)
	{
		// Select a circle if it contains the mouse coordinates
		_x = e.getX();
		_y = e.getY();
		
		_owningPanel.setMouseCoordinates(_x, _y);
		
		if (_c1.containsPoint(_x, _y))
		{
			_selectedCircle = _c1;
			 _owningPanel.setSelectedCircle (_c1);
			
		}
		else if (_c2.containsPoint(_x, _y))
		{
			_selectedCircle = _c2;
			 _owningPanel.setSelectedCircle (_c2);
		}
	}
	
	
	public void mouseReleased(MouseEvent e)
	{
	// Deselect the selected circle
		_selectedCircle = null;
		_owningPanel.setSelectedCircle (null);
	}
}//PanelListener
