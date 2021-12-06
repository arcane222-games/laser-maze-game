package com.arcane22.lazermazegame;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.arcane22.lazermazegame.GameToken.TokenType;

public class GameManager 
{
	private final int GRID_MAX_ROW = 5, GRID_MAX_COLUMN = 5;
	
	private ArrayList<BufferedImage> tokenImgList, cardImgList, solutionImgList;
	private ArrayList<GameCard> cardList;
	private ArrayList<GameCard> solutionList;
	private ArrayList<GameToken> addToGridList;
	private ArrayList<Node> pathList;
	private GameToken[][] tokenOnGrid;
	
	private int stageNum;
	
	public GameManager()
	{
		InitData();
	}
	
	public int GetGridMaxRow()
	{
		return GRID_MAX_ROW;
	}
	public int GetGridMaxColumn()
	{
		return GRID_MAX_COLUMN;
	}
	
	
	/* Get Image Src List */
	public ArrayList<BufferedImage> GetTokenImgList()
	{
		return tokenImgList;
	}
	public ArrayList<BufferedImage> GetCardImgList()
	{
		return cardImgList;
	}
	public ArrayList<BufferedImage> GetSolutionImgList()
	{
		return solutionImgList;
	}
	
	
	public ArrayList<GameCard> GetCardList()
	{
		return cardList;
	}
	public ArrayList<GameToken> GetAddToGridList()
	{
		return addToGridList;
	}
	public ArrayList<Node> GetPathList()
	{
		return pathList;
	}
	public GameToken[][] GetTokenOnGrid()
	{
		return tokenOnGrid;
	}
	
	
	
	public int GetStageNum()
	{
		return stageNum;
	}
	public void SetStageNum(int stageNum)
	{
		this.stageNum = stageNum;
	}
	
	public void InitData()
	{
		stageNum = 1;
		InitToken();
		ReadImage();
		ReadDataFile();
	}
	
	public void ReadImage() 
	{
		tokenImgList = new ArrayList<>();
		cardImgList = new ArrayList<>();
		solutionImgList = new ArrayList<>();
		
		try
		{
			/* 
			 *  Read Token Image 
			 *  Token Index
			 *  Red: 0, RedQmark: 1, Yellow: 2, YellowQmark: 3, Green: 4, GreenQmark: 5, Blue: 6, BlueQmark: 7
			 *  Purple: 8, PurpleQmark: 9, Purple2: 10, Purple2Qmark: 11, Black: 12
			*/
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenRed.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenRedQmark.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenYellow.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenYellowQmark.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenGreen.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenGreenQmark.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenBlue.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenBlueQmark.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenPurple.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenPurpleQmark.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenPurple2.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenPurple2Qmark.png")));
			tokenImgList.add(ImageIO.read(new File("./img/token/TokenBlack.png")));
			
			/* Read Card Image */
			cardImgList.add(ImageIO.read(new File("./img/map/stage01.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage02.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage03.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage04.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage05.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage06.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage07.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage08.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage09.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage10.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage11.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage12.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage13.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage14.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage15.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage16.png")));
			cardImgList.add(ImageIO.read(new File("./img/map/stage17.png")));
			
			/* Read Solution Image */
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution01.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution02.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution03.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution04.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution05.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution06.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution07.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution08.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution09.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution10.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution11.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution12.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution13.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution14.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution15.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution16.png")));
			solutionImgList.add(ImageIO.read(new File("./img/map/stageSolution17.png")));
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	public void ReadDataFile()
	{
		cardList = new ArrayList<>();
		solutionList = new ArrayList<>();
		BufferedReader reader = null;
		BufferedReader reader2 = null;
		FileReader fileReader = null;
		try
		{
			fileReader = new FileReader(new File("./data/cardInfo.txt"));
			reader = new BufferedReader(fileReader);
			fileReader = new FileReader(new File("./data/solutionInfo.txt"));
			reader2 = new BufferedReader(fileReader);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			System.exit(0);
		}
		try 
		{
			String dataTmp = reader.readLine();
			while(dataTmp != null)
			{
				cardList.add(new GameCard());
				cardList.get(cardList.size() - 1).SetCardNum(Integer.parseInt(dataTmp.split("/")[0]));
				cardList.get(cardList.size() - 1).SetTargetNum(Integer.parseInt(dataTmp.split("/")[1]));
				cardList.get(cardList.size() - 1).SetDifficulty(dataTmp.split("/")[2]);
				cardList.get(cardList.size() - 1).SetAddToGridData(dataTmp.split("/")[3]);
				cardList.get(cardList.size() - 1).SetTokenOnGridData(dataTmp.split("/")[4]);
				dataTmp = reader.readLine();
			}
			
			dataTmp = reader2.readLine();
			while(dataTmp != null)
			{
				solutionList.add(new GameCard());
				solutionList.get(solutionList.size() - 1).SetTokenOnGridData(dataTmp);
				dataTmp = reader2.readLine();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void InitToken()
	{
		addToGridList = new ArrayList<GameToken>();
		tokenOnGrid = new GameToken[GRID_MAX_ROW][GRID_MAX_COLUMN];
		pathList = new ArrayList<Node>();
		for(int i = 0; i < 5; i++)
		{
			addToGridList.add(new GameToken(i, 0, 10 + i * 70, 100, 70, 0, TokenType.EMPTY));
		}
		for(int i = 0; i < GRID_MAX_ROW; i++)
		{
			for(int j = 0; j < GRID_MAX_COLUMN; j++)
			{
				tokenOnGrid[i][j] = new GameToken(j, i, 85 + j * 85, 200 + i * 85, 80, 0, TokenType.EMPTY);
			}
		}
	}
	
	public void SetUpStage()
	{
		pathList.clear();
		GameCard currentCard = cardList.get(stageNum - 1);
		for(int i = 0; i < addToGridList.size(); i++)
		{
			addToGridList.get(i).SetTokenType(TokenType.EMPTY);
			addToGridList.get(i).SetDirection(0);
			addToGridList.get(i).SetCanMove(true);
			
		}
		for(int i = 0; i < GRID_MAX_ROW; i++)
		{
			for(int j = 0; j < GRID_MAX_COLUMN; j++)
			{
				tokenOnGrid[i][j].SetTokenType(TokenType.EMPTY);
				tokenOnGrid[i][j].SetDirection(0);
				tokenOnGrid[i][j].SetCanMove(false);
				tokenOnGrid[i][j].SetCanRotate(false);
			}
		}
		
		for(int i = 0; i < currentCard.GetTokenOnGridData().size(); i++)
		{
			int x =  currentCard.GetTokenOnGridData().get(i).GetColumn();
			int y =  currentCard.GetTokenOnGridData().get(i).GetRow();
			tokenOnGrid[y][x].SetTokenType(currentCard.GetTokenOnGridData().get(i).GetTokenType());
			tokenOnGrid[y][x].SetDirection(currentCard.GetTokenOnGridData().get(i).GetDirection());
		}
		for(int i = 0; i < currentCard.GetAddToGridData().size(); i++)
		{
			addToGridList.get(i).SetTokenType(currentCard.GetAddToGridData().get(i).GetTokenType());
			addToGridList.get(i).SetDirection(currentCard.GetAddToGridData().get(i).GetDirection());
		}
		for(int i = 0; i < GRID_MAX_ROW; i++)
		{
			for(int j = 0; j < GRID_MAX_COLUMN; j++)
			{
				if(tokenOnGrid[i][j].GetTokenType() == TokenType.EMPTY)
				{
					tokenOnGrid[i][j].SetCanMove(true);
				}
			}
		}
	}
	
	public void SetUpSolution()
	{
		pathList.clear();
		GameToken departure = null;
		GameCard currentCard = solutionList.get(stageNum - 1);
		
		for(int i = 0; i < addToGridList.size(); i++)
		{
			addToGridList.get(i).SetTokenType(TokenType.EMPTY);
			addToGridList.get(i).SetDirection(0);
			addToGridList.get(i).SetCanMove(true);
			
		}
		for(int i = 0; i < GRID_MAX_ROW; i++)
		{
			for(int j = 0; j < GRID_MAX_COLUMN; j++)
			{
				tokenOnGrid[i][j].SetTokenType(TokenType.EMPTY);
				tokenOnGrid[i][j].SetDirection(0);
				tokenOnGrid[i][j].SetCanMove(false);
				tokenOnGrid[i][j].SetCanRotate(false);
			}
		}
		
		for(int i = 0; i < currentCard.GetTokenOnGridData().size(); i++)
		{
			int x =  currentCard.GetTokenOnGridData().get(i).GetColumn();
			int y =  currentCard.GetTokenOnGridData().get(i).GetRow();
			tokenOnGrid[y][x].SetTokenType(currentCard.GetTokenOnGridData().get(i).GetTokenType());
			tokenOnGrid[y][x].SetDirection(currentCard.GetTokenOnGridData().get(i).GetDirection());
		}
		for(int i = 0; i < GRID_MAX_ROW; i++)
		{
			for(int j = 0; j < GRID_MAX_COLUMN; j++)
			{
				if(tokenOnGrid[i][j].GetTokenType() == TokenType.EMPTY)
				{
					tokenOnGrid[i][j].SetCanMove(true);
				}
				else if(tokenOnGrid[i][j].GetTokenType() == TokenType.RED)
				{
					departure = tokenOnGrid[i][j];
				}
			}
		}
		FindPath(departure);
	}
	
	public boolean IsAddToGridEmpty()
	{
		for(int i = 0; i < addToGridList.size(); i++)
		{
			if(addToGridList.get(i).GetTokenType() != TokenType.EMPTY) return false;
		}
		return true;
	}
	
	public boolean IsTokenAllOpened()
	{
		for(int i = 0; i < GRID_MAX_ROW; i++)
		{
			for(int j = 0; j < GRID_MAX_COLUMN; j++)
			{
				TokenType type = tokenOnGrid[i][j].GetTokenType();
				if(type == TokenType.RED_QMARK || type == TokenType.YELLOW_QMARK || type == TokenType.GREEN_QMARK || type == TokenType.BLUE_QMARK
						|| type == TokenType.PURPLE_QMARK || type == TokenType.PURPLE2_QMARK)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public Node FindNodeByPosition(int column, int row)
	{
		for(int i = 0; i < pathList.size(); i++)
		{
			if(pathList.get(i).GetColumn() == column && pathList.get(i).GetRow() == row)
			{
				return pathList.get(i);
			}
		}
		return null;
	}
	
	public int TokenTypeCount(GameToken[][] tokenarr, TokenType type)
	{
		int num = 0;
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++) {
				if(tokenarr[j][i].GetTokenType() == type) num++;
			}
		}
		return num;
	}
	
	public void FindPath(GameToken departure)
	{
		int dx = 0, dy = 0;
		int nextX = 0, nextY = 0;
		pathList.clear();
		pathList.add(new Node(departure, null));
		nextX = pathList.get(0).GetColumn();
		nextY = pathList.get(0).GetRow();
		switch(departure.GetDirection())
		{
		case 0:
			nextY--;
			break;
		case 1:
			nextX++;
			break;
		case 2:
			nextY++;
			break;
		case 3:
			nextX--;
			break;
		}
		if((nextX >= 0 && nextX <= GRID_MAX_COLUMN - 1) && (nextY >= 0 && nextY <= GRID_MAX_ROW - 1))
		{
			Node node = new Node(tokenOnGrid[nextY][nextX], pathList.get(0));
			pathList.get(0).SetLeftChild(node);
			pathList.add(node);
		}
		else
			return;
		for(int i = 1;;i++)
		{
			if(i == pathList.size()) return;
			nextX = pathList.get(i).GetColumn();
			nextY = pathList.get(i).GetRow();
			dx = pathList.get(i).GetColumn() - pathList.get(i).GetParent().GetColumn();
			dy = pathList.get(i).GetRow() - pathList.get(i).GetParent().GetRow();
			if(pathList.get(i).GetTokenType() == TokenType.EMPTY || pathList.get(i).GetTokenType() == TokenType.BLACK)
			{
				nextX += dx;
				nextY += dy;
				if((nextX >= 0 && nextX <= GRID_MAX_COLUMN - 1) && (nextY >= 0 && nextY <= GRID_MAX_ROW - 1))
				{
					Node node = new Node(tokenOnGrid[nextY][nextX], pathList.get(i));
					pathList.get(i).SetLeftChild(node);
					pathList.add(node);
				}
				else
					continue;
			}
			else if(pathList.get(i).GetTokenType() == TokenType.YELLOW)
			{
				switch(pathList.get(i).GetDirection() % 2)
				{
				    case 0:
				    	if(dy == 0) continue;
				    	else nextY += dy;
					    break;
				    case 1:
				    	if(dx == 0) continue;
				    	else nextX += dx;
					    break;
				}
				if((nextX >= 0 && nextX <= GRID_MAX_COLUMN - 1) && (nextY >= 0 && nextY <= GRID_MAX_ROW - 1))
				{
					Node node = new Node(tokenOnGrid[nextY][nextX], pathList.get(i));
					pathList.get(i).SetLeftChild(node);
					pathList.add(node);
				}
				else
					continue;
			}
			else if(pathList.get(i).GetTokenType() == TokenType.GREEN)
			{
				int nextX2 = nextX;
				int nextY2 = nextY;
				switch(pathList.get(i).GetDirection() % 2)
				{
				    case 0:
				    	if(dy == 0) {
				    		nextY -= dx;
				    		nextX2 += dx;
				    	}
				    	else {
				    		nextX -= dy;
				    		nextY2 += dy;
				    	}
					    break;
				    case 1:
				    	if(dy == 0) {
				    		nextY += dx;
				    		nextX2 += dx;
				    	}
				    	else {
				    		nextX += dy;
				    		nextY2 += dy;
				    	}
				    	
					    break;
				}
				if((nextX >= 0 && nextX <= GRID_MAX_COLUMN - 1) && (nextY >= 0 && nextY <= GRID_MAX_ROW - 1))
				{
					Node node = new Node(tokenOnGrid[nextY][nextX], pathList.get(i));
					pathList.get(i).SetLeftChild(node);
					pathList.add(node);
				}
				if((nextX2 >= 0 && nextX2 <= GRID_MAX_COLUMN - 1) && (nextY2 >= 0 && nextY2 <= GRID_MAX_ROW - 1))
				{
					Node node = new Node(tokenOnGrid[nextY2][nextX2], pathList.get(i));
					pathList.get(i).SetRightChild(node);
					pathList.add(node);
				}
			}
			else if(pathList.get(i).GetTokenType() == TokenType.BLUE)
			{
				switch(pathList.get(i).GetDirection() % 2)
				{
				    case 0:
				    	if(dx == 0) nextX -= dy;
				    	else nextY -= dx;
					    break;
				    case 1:
				    	if(dx == 0) nextX += dy;
				    	else nextY += dx;
					    break;
				}
				if((nextX >= 0 && nextX <= GRID_MAX_COLUMN - 1) && (nextY >= 0 && nextY <= GRID_MAX_ROW - 1))
				{
					Node node = new Node(tokenOnGrid[nextY][nextX], pathList.get(i));
					pathList.get(i).SetLeftChild(node);
					pathList.add(node);
				}
				else
					continue;
			}
			else if(pathList.get(i).GetTokenType() == TokenType.PURPLE || pathList.get(i).GetTokenType() == TokenType.PURPLE2)
			{
				switch(pathList.get(i).GetDirection())
				{
				    case 0:
				    	if(dx == 1) nextY += dx;
				    	else if(dx == -1) continue;
				    	else if(dy == 1) {
				    		pathList.get(i).SetHitOnTarget(true);
				    		continue;
				    	}
				    	else if(dy == -1) nextX += dy;
					    break;
				    case 1:
				    	if(dx == 1) nextY -= dx;
				    	else if(dx == -1) {
				    		pathList.get(i).SetHitOnTarget(true);
				    		continue;
				    	}
				    	else if(dy == 1) nextX -= dy;
				    	else if(dy == -1) continue;
					    break;
				    case 2:
				    	if(dx == 1) continue;
				    	else if(dx == -1) nextY += dx;
				    	else if(dy == 1) nextX += dy;
				    	else if(dy == -1) {
				    		pathList.get(i).SetHitOnTarget(true);
				    		continue;
				    	}
				    	break;
				    case 3:
				    	if(dx == 1) {
				    		pathList.get(i).SetHitOnTarget(true);
				    		continue;
				    	}
				    	else if(dx == -1) nextY -= dx;
				    	else if(dy == 1) continue;
				    	else if(dy == -1) nextX -= dy; 
				    	break;
				}
				if((nextX >= 0 && nextX <= GRID_MAX_COLUMN - 1) && (nextY >= 0 && nextY <= GRID_MAX_ROW - 1))
				{
					Node node = new Node(tokenOnGrid[nextY][nextX], pathList.get(i));
					pathList.get(i).SetLeftChild(node);
					pathList.add(node);
				}
				else
					continue;
			}
		}
	}
	
	public void CastRay(GameToken departure)
	{
		FindPath(departure);
		GameCard currentCard = cardList.get(stageNum - 1);
		int hitTargetNum = 0;
		int yellowNum = 0;
		for(int i = 0; i < pathList.size(); i++)
		{
			if(pathList.get(i).IsHitOnTarget()) {
				tokenOnGrid[pathList.get(i).GetRow()][pathList.get(i).GetColumn()].SetTokenType(TokenType.PURPLE2);
				hitTargetNum++;
			}
			if(pathList.get(i).GetTokenType() == TokenType.YELLOW) yellowNum++;
		}
		if(this.TokenTypeCount(tokenOnGrid, TokenType.YELLOW) == 0)
		{
			if(currentCard.GetTargetNum() == hitTargetNum) {
				int result = JOptionPane.showConfirmDialog(null, "����! (�������������� �Ѿ��)");
				if(result == 0 ) {
					if(stageNum < 17) stageNum++;
					else stageNum = 1;
					this.SetUpStage();
				}
			}
			else
				JOptionPane.showMessageDialog(null, "���� (�ٽ��غ�����)");
		}
		else {
			if(currentCard.GetTargetNum() == hitTargetNum && yellowNum == this.TokenTypeCount(tokenOnGrid, TokenType.YELLOW))
			{
				int result = JOptionPane.showConfirmDialog(null, "����! (�������������� �Ѿ��)");
				if(result == 0) {
					if(stageNum < 17) stageNum++;
					else stageNum = 1;
					this.SetUpStage();
				}
			}
			else
				JOptionPane.showMessageDialog(null, "���� (�ٽ��غ�����)");
		}
	}
}
