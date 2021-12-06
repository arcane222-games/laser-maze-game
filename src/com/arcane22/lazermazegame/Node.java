package com.arcane22.lazermazegame;

import com.arcane22.lazermazegame.GameToken.TokenType;

public class Node extends GameToken {
	private Node leftChild, rightChild, parent;
	private boolean HitOnTarget;
	

	public Node(GameToken token, Node parent) {
		super(token.GetColumn(), token.GetRow(), token.GetX(), token.GetY(), token.GetTokenSize(), token.GetDirection(), token.GetTokenType());
		this.parent = parent;
	}

	public Node GetLeftChild() 
	{
		return leftChild;
	}
	public void SetLeftChild(Node leftChild) 
	{
		this.leftChild = leftChild;
	}
	
	
	public Node GetRightChild() 
	{
		return rightChild;
	}
	public void SetRightChild(Node rightChild) 
	{
		this.rightChild = rightChild;
	}
	
	
	public Node GetParent() 
	{
		return parent;
	}
	public void SetParent(Node parent) 
	{
		this.parent = parent;
	}
	
	
	public boolean IsHitOnTarget() 
	{
		return HitOnTarget;
	}
	public void SetHitOnTarget(boolean hitOnTarget) 
	{
		HitOnTarget = hitOnTarget;
	}
}
