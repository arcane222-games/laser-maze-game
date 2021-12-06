package com.arcane22.lazermazegame;

import java.awt.Component;
import java.math.BigDecimal;

public class GameThread extends Thread
{
	private GameManager gameManager;
	private GameFrame gameFrame;
	private GamePanel gamePanel;
	
	public GameThread()
	{
		gameManager = new GameManager();
		gameFrame = new GameFrame();
		gamePanel = new GamePanel(gameFrame.getWidth(), gameFrame.getHeight());
		
		gamePanel.SetGameManager(gameManager);
		gameFrame.add(gamePanel);
	}
	
	public void MouseDoubleClickEvent()
	{
	    if(gamePanel.GetDoubleClickCount() >= 1)
	    {
	    	gamePanel.SetDoubleClickTimer(gamePanel.GetDoubleClickTimer() + 1);
	    }
	    if(gamePanel.GetDoubleClickTimer() >= 15)
	    {
	    	gamePanel.SetDoubleClickCount(0);
	    	gamePanel.SetDoubleClickTimer(0);
	    }
	}
	
	public void TokenRotation()
	{
		for(int i = 0; i < gameManager.GetGridMaxRow(); i++)
		{
			for(int j = 0; j < gameManager.GetGridMaxColumn(); j++)
			{
				GameToken token = gameManager.GetTokenOnGrid()[i][j];
				if(token.GetOnRotate())
				{
					BigDecimal bigDecimal = new BigDecimal(Double.toString(token.GetAngle()));
					double newAngle = bigDecimal.add(new BigDecimal("0.1")).doubleValue();
					
					if(newAngle == 4.0)
					{
						newAngle = 0;
					}
					token.SetAngle(newAngle);
					if(token.GetAngle() == 0 || token.GetAngle() == 1.0 || token.GetAngle() == 2.0 || token.GetAngle() == 3.0)
					{
						token.SetDirection((int)token.GetAngle());
						token.SetOnRotate(false);
					}
				}
			}
		}
	}
	
	@Override
	public void run() {
		super.run();
		while(true){
		    try {
			    Thread.sleep(20);
		    }
		    catch(InterruptedException e) {
			    e.printStackTrace();
		    }
		    TokenRotation();
		    MouseDoubleClickEvent();
		    gameFrame.repaint();
		}
	}
}
