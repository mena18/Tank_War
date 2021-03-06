package display;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;


public class Display {
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width,height;
	
	
	
	public Display(String title,int width,int height){
		this.title = title;
		this.width=width;
		this.height=height;
		
		createDisplay();
		
	}
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width,height); // set width,height
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when close do jframe.exit_on_close
		frame.setResizable(false); // make it not resizable
		frame.setLocationRelativeTo(null); // make the window centered
		frame.setVisible(true); // make it visible (default = false)
	
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		frame.add(canvas);

		frame.pack();
		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
