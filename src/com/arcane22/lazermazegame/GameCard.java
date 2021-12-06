package com.arcane22.lazermazegame;

import java.util.ArrayList;
import com.arcane22.lazermazegame.GameToken.TokenType;

public class GameCard 
{
	private int cardNum, targetNum;
	private String difficulty;
	private ArrayList<GameToken> tokenOnGridData;
	private ArrayList<GameToken> addToGridData;
	
	public GameCard()
	{
		tokenOnGridData = new ArrayList<GameToken>();
		addToGridData = new ArrayList<GameToken>();
	}
	
	
	public int GetCardNum()
	{
		return cardNum;
	}
	public void SetCardNum(int cardNum)
	{
		this.cardNum = cardNum;
	}
	
	
	public int GetTargetNum()
	{
		return targetNum;
	}
	public void SetTargetNum(int targetNum)
	{
		this.targetNum = targetNum;
	}
	
	
	public String GetDifficulty()
	{
		return difficulty;
	}
	public void SetDifficulty(String difficulty)
	{
		this.difficulty = difficulty;
	}
	
	
	public ArrayList<GameToken> GetAddToGridData()
	{
		return addToGridData;
	}
	public void SetAddToGridData(String data)
	{
		for(int i = 0; i < data.split(",").length; i++)
		{
			String tokenData = data.split(",")[i];
			int column = Integer.parseInt(tokenData.split(" ")[0]);
			TokenType tokenType = null;
			switch(Integer.parseInt(tokenData.split(" ")[1]))
			{
			    case 0:
			    	tokenType = TokenType.RED;
				    break;
			    case 1:
			    	tokenType = TokenType.RED_QMARK;
				    break;
			    case 2:
			    	tokenType =TokenType.YELLOW;
			    	break;
			    case 3:
			    	tokenType =TokenType.YELLOW_QMARK;
			    	break;
			    case 4:
			    	tokenType =TokenType.GREEN;
			    	break;
			    case 5:
			    	tokenType =TokenType.GREEN_QMARK;
			    	break;
			    case 6:
			    	tokenType =TokenType.BLUE;
			    	break;
			    case 7:
			    	tokenType =TokenType.BLUE_QMARK;
			    	break;
			    case 8:
			    	tokenType =TokenType.PURPLE;
			    	break;
			    case 9:
			    	tokenType =TokenType.PURPLE_QMARK;
			    	break;
			    case 10:
			    	tokenType =TokenType.PURPLE2;
			    	break;
			    case 11:
			    	tokenType =TokenType.PURPLE2_QMARK;
			    	break;
			    case 12:
			    	tokenType =TokenType.BLACK;
			    	break;
			}
			addToGridData.add(new GameToken(column, 0, 10 + column * 70, 0, 70, 0, tokenType));
		}
	}
	
	
	public ArrayList<GameToken> GetTokenOnGridData()
	{
		return tokenOnGridData;
	}
	public void SetTokenOnGridData(String data)
	{
		for(int i = 0; i < data.split(",").length; i++)
		{
			String tokenData = data.split(",")[i];
			int column = Integer.parseInt(tokenData.split(" ")[0]);
			int row = Integer.parseInt(tokenData.split(" ")[1]);
			int direction = Integer.parseInt(tokenData.split(" ")[2]);
			TokenType tokenType = null;
			switch(Integer.parseInt(tokenData.split(" ")[3]))
			{
			    case 0:
			    	tokenType =TokenType.RED;
				    break;
			    case 1:
			    	tokenType =TokenType.RED_QMARK;
				    break;
			    case 2:
			    	tokenType =TokenType.YELLOW;
			    	break;
			    case 3:
			    	tokenType =TokenType.YELLOW_QMARK;
			    	break;
			    case 4:
			    	tokenType =TokenType.GREEN;
			    	break;
			    case 5:
			    	tokenType =TokenType.GREEN_QMARK;
			    	break;
			    case 6:
			    	tokenType =TokenType.BLUE;
			    	break;
			    case 7:
			    	tokenType =TokenType.BLUE_QMARK;
			    	break;
			    case 8:
			    	tokenType =TokenType.PURPLE;
			    	break;
			    case 9:
			    	tokenType =TokenType.PURPLE_QMARK;
			    	break;
			    case 10:
			    	tokenType =TokenType.PURPLE2;
			    	break;
			    case 11:
			    	tokenType =TokenType.PURPLE2_QMARK;
			    	break;
			    case 12:
			    	tokenType =TokenType.BLACK;
			    	break;
			}
			tokenOnGridData.add(new GameToken(column, row, 85 + column * 85, 200 + row * 85, 80, direction, tokenType));
		}
	}
}
