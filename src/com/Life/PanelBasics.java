package com.Life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelBasics 
{
	//Declarations
	private static JPanel[][] Panel;
	static JFrame frame = new JFrame();
	static JButton button = new JButton();
	private static int pre[][] = null;
    public static Scanner scanner = new Scanner(System.in); 
	
    //Main Function
    public static void main(String[] args) {
		Life life = new Life();
    	System.out.println("Enter the square length");
        int n = scanner.nextInt();
		
        Panel = initializePanel(Panel,n);
		
		pre = life.initializeArray(pre,n);
		
		rowsToColumn(pre);
		
		paintFrame(pre,Panel);
		
		startFrame(Panel);
		
	}
	
    //Set Panel Array for Painting it
	public static void paintFrame(int pre[][],JPanel Panel[] []) 
	{	
		int temp[][] = new int[pre.length][pre.length];
		temp = pre;
		temp = rowsToColumn(temp);
		for(int i=0;i<temp.length;i++)
		{
			for(int j=0;j<temp.length;j++)
			{
				if(temp[i][j] == 0)
				{
					Panel[i][j].setBackground(Color.red);
				}
				else
				{
					Panel[i][j].setBackground(Color.blue);
				}
			}
		}
	}
	
	//Sets all the elements on the Frame
	public static void startFrame(JPanel Panel[][]) 
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setSize(750,750);
		int x = (int) ((frame.getWidth()) / 2);
	    int y = (int) ((frame.getHeight()) / 2);
	    System.out.println(frame.getWidth()+"  : Some Values :"+frame.getWidth());
	    
		for(int i=0;i<Panel.length;i++)
		{
			for(int j=0;j<Panel.length;j++)
			{
				frame.add(Panel[i][j]);
			}
		}		
	    System.out.println("X is : "+ x +" Y is"+y);
		button.setBounds(x,y,100,50);
		button.setText("See Next Generation");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				paintNextGeneration(pre,Panel);
			}			
		});
		frame.add(button);
	}
	
	//Calculate next state of array and send it to paintFrame function for setting Panel Array
	public static void paintNextGeneration(int[][] pre, JPanel[][] panel) 
	{
		Life l = new Life();
		
		pre = l.calculateMapping(pre);
		
		paintFrame(pre,Panel);
	}
	
	//Initializes the JPanel array
	public static JPanel[][] initializePanel(JPanel Panel[][],int n) {
		Panel = new JPanel[n][n];
		int x = (int) ((frame.getWidth()) / 2);
	    for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				Panel[i][j] = new JPanel();
				Panel[i][j].setBounds((x+i*50), j*50, 50, 50);
			}
		}
		return Panel;
	}
	
	//Changes the Rows of an Array to the Columns and returns it
	public static int[][] rowsToColumn(int ArrayToBeConverted[][]){
		int ArrayToBeReturned[][] = new int[ArrayToBeConverted.length][ArrayToBeConverted.length];
		for(int i=0;i<ArrayToBeConverted.length;i++)
		{
			for(int j=0;j<ArrayToBeConverted.length;j++)
			{
				ArrayToBeReturned[j][i] = ArrayToBeConverted[i][j];
			}
		}
		return ArrayToBeReturned;		
	}

}
