package com.arcane22.lazermazegame;

public class GameToken 
{
	public enum TokenType
	{
		EMPTY, RED, RED_QMARK, YELLOW, YELLOW_QMARK, GREEN, GREEN_QMARK, 
		BLUE, BLUE_QMARK, PURPLE, PURPLE_QMARK, PURPLE2, PURPLE2_QMARK, BLACK
	}
	
	private TokenType tokenType;
	private int row, column, xPos, yPos, tokenSize, direction;
	private boolean canRotate, canMove, onRotate;
	private double angle;
	
	public GameToken(int column, int row , int xPos, int yPos, int tokenSize, int direction, TokenType tokenType)
	{
		this.column = column;
		this.row = row;
		this.xPos = xPos;
		this.yPos = yPos;
		this.tokenSize = tokenSize;
		this.angle = this.direction = direction;
		this.tokenType = tokenType;
		this.canRotate = this.canMove = false;
	}
	
	
	/* Get, Set Token Type ex)TokenType.RED */
	public TokenType GetTokenType()
	{
		return this.tokenType;
	}
	public void SetTokenType(TokenType tokenType)
	{
		this.tokenType = tokenType;
	}
	
	
	/* Get, Set Token's Row and Column*/
	public int GetRow()
	{
		return row;
	}
	public void SetRow(int row)
	{
		this.row = row;
	}
	public int GetColumn()
	{
		return column;
	}
	public void SetColumn(int column)
	{
		this.column = column;
	}
	
	
	/*Get, Set Token's X and Y position on Panel*/
	public int GetX()
	{
		return xPos;
	}
	public void SetX(int xPos)
	{
		this.xPos = xPos;
	}
	public int GetY()
	{
		return yPos;
	}
	public void SetY(int yPos)
	{
		this.yPos = yPos;
	}
	
	
	/* Get, Set Token Size */
	public int GetTokenSize()
	{
		return tokenSize;
	}
	public void SetTokenSize(int tokenSize)
	{
		this.tokenSize = tokenSize;
	}
	

	/*Get, Set Token's Direction(Integer) and Angle(Double) */
	public int GetDirection()
	{
		return direction;
	}
	public void SetDirection(int direction)
	{
		this.angle = direction;
		this.direction = direction;
	}	
	public double GetAngle()
	{
		return angle;
	}
	public void SetAngle(double angle)
	{
		this.angle = angle;
	}
	
	
	/* Get, Set Token's Rotation Toggle value*/
	public boolean GetCanRotate()
	{
		return canRotate;
	}
	public void SetCanRotate(boolean canRotate)
	{
		this.canRotate = canRotate;
	}
	public boolean GetOnRotate()
	{
		return onRotate;
	}
	public void SetOnRotate(boolean onRotate)
	{
		this.onRotate = onRotate;
	}
	
	
	public boolean GetCanMove()
	{
		return canMove;
	}
	public void SetCanMove(boolean canMove)
	{
		this.canMove = canMove;
	}
}
