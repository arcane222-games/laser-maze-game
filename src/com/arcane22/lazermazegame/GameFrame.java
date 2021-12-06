package com.arcane22.lazermazegame;
import javax.swing.JFrame;

public class GameFrame extends JFrame
{
	private final int SCREEN_WIDTH = 600, SCREEN_HEIGHT = 800;
	
	public GameFrame()
	{
		setTitle("LazerMazeGame (v1.0.0)");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setVisible(true);
	}
	
	public int GetScreenWidth() 
	{
		return SCREEN_WIDTH;
	}
	public int GetScreenHeight() 
	{
		return SCREEN_HEIGHT;
	}
}
