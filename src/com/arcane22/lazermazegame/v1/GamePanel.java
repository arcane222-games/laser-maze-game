package com.arcane22.lazermazegame.v1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.arcane22.lazermazegame.v1.GameToken.TokenType;

public class GamePanel extends JPanel {

	class PanelMouseEvent extends MouseAdapter {
		int rowTmp, columnTmp;
		@Override
		public void mousePressed(MouseEvent e) {
			super.mousePressed(e);
			columnTmp = -1;
			rowTmp = -1;
			
			if(e.getButton() == 1) {
				if((e.getX() >= 85 && e.getX() <= 485) && (e.getY() >= 200 && e.getY() <= 620)) {
					doubleClickCount++;
					columnTmp = (e.getX() - 85) / 85;
					rowTmp = (e.getY() - 200) / 85;
					GameToken token = gameManager.GetTokenOnGrid()[rowTmp][columnTmp];
					if(doubleClickCount == 2) {
						if(token.GetTokenType() != TokenType.EMPTY && token.GetCanRotate())
							token.SetOnRotate(true);
					}
					else {
						switch(token.GetTokenType()) {
						    case RED_QMARK:
						    	token.SetTokenType(TokenType.RED);
						    	token.SetCanRotate(true);
							    break;
						    case YELLOW_QMARK:
						    	token.SetTokenType(TokenType.YELLOW);
						    	token.SetCanRotate(true);
							    break;
						    case GREEN_QMARK:
						    	token.SetTokenType(TokenType.GREEN);
						    	token.SetCanRotate(true);
							    break;
						    case BLUE_QMARK:
						    	token.SetTokenType(TokenType.BLUE);
						    	token.SetCanRotate(true);
							    break;
						    case PURPLE_QMARK:
						    	token.SetTokenType(TokenType.PURPLE);
						    	token.SetCanRotate(true);
							    break;
						    case PURPLE2_QMARK:
						    	token.SetTokenType(TokenType.PURPLE2);
						    	token.SetCanRotate(true);
							    break;
						    default:
							    break;
						}
					}
				}
			}
			else if(e.getButton() == 2) {
				if((e.getX() >= 85 && e.getX() <= 485) && (e.getY() >= 200 && e.getY() <= 620)) {
					columnTmp = (e.getX() - 85) / 85;
					rowTmp = (e.getY() - 200) / 85;
					GameToken token = gameManager.GetTokenOnGrid()[rowTmp][columnTmp];

					if(token.GetTokenType() == TokenType.RED) {
				    	int result = JOptionPane.showConfirmDialog(null, "�������");

				    	if(result == 0) {
				    		if(gameManager.IsAddToGridEmpty() && gameManager.IsTokenAllOpened()) gameManager.CastRay(token);
				    		else JOptionPane.showMessageDialog(null, "��ū�� ���� ��ġ/���� ���ּ���");
				    	}
					}
				}
			}
			else {
				onMouseRightBtnClicked = true;
				if((e.getX() >= 10 && e.getX() <= 360) && (e.getY() >= 100 && e.getY() <= 170)) {
					columnTmp = (e.getX() - 10) / 70;
					GameToken token = gameManager.GetAddToGridList().get(columnTmp);
					if(token.GetTokenType() != TokenType.EMPTY && token.GetCanMove()) {
						tokenOnHolding = new GameToken(0, 0, e.getX() - 40, e.getY() - 40, 80, token.GetDirection(), token.GetTokenType());
						token.SetDirection(0);
						token.SetTokenType(TokenType.EMPTY);
					}
					else JOptionPane.showMessageDialog(null, "������ �� ���� ��ū�Դϴ�.");
				}

				if((e.getX() >= 85 && e.getX() <= 485) && (e.getY() >= 200 && e.getY() <= 620)) {
					columnTmp = (e.getX() - 85) / 85;
					rowTmp = (e.getY() - 200) / 85;
					GameToken token = gameManager.GetTokenOnGrid()[rowTmp][columnTmp];

					if(token.GetTokenType() != TokenType.EMPTY && token.GetCanMove()) {
						tokenOnHolding = new GameToken(0, 0, e.getX() - 40, e.getY() - 40, 80, token.GetDirection(), token.GetTokenType());
						token.SetDirection(0);
						token.SetTokenType(TokenType.EMPTY);
					}
					else JOptionPane.showMessageDialog(null, "������ �� ���� ��ū�Դϴ�.");
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			super.mouseReleased(e);
			if(e.getButton() == 3 && tokenOnHolding != null) {
				if(columnTmp >= 0) {
					if(rowTmp == -1) {
						if((e.getX() >= 85 && e.getX() <= 485) && (e.getY() >= 200 && e.getY() <= 620) && 
								gameManager.GetTokenOnGrid()[(e.getY() - 200) / 85][(e.getX() - 85) / 85].GetTokenType() == TokenType.EMPTY) {
							gameManager.GetTokenOnGrid()[(e.getY() - 200) / 85][(e.getX() - 85) / 85].SetTokenType(tokenOnHolding.GetTokenType());
							gameManager.GetTokenOnGrid()[(e.getY() - 200) / 85][(e.getX() - 85) / 85].SetDirection(tokenOnHolding.GetDirection());
							tokenOnHolding = null;
						}
						else {
							gameManager.GetAddToGridList().get(columnTmp).SetTokenType(tokenOnHolding.GetTokenType());
							gameManager.GetAddToGridList().get(columnTmp).SetDirection(tokenOnHolding.GetDirection());
							tokenOnHolding = null;
						}
					}
					else {
						if((e.getX() >= 85 && e.getX() <= 485) && (e.getY() >= 200 && e.getY() <= 620) &&
								gameManager.GetTokenOnGrid()[(e.getY() - 200) / 85][(e.getX() - 85) / 85].GetTokenType() == TokenType.EMPTY) {
							gameManager.GetTokenOnGrid()[(e.getY() - 200) / 85][(e.getX() - 85) / 85].SetTokenType(tokenOnHolding.GetTokenType());
							gameManager.GetTokenOnGrid()[(e.getY() - 200) / 85][(e.getX() - 85) / 85].SetDirection(tokenOnHolding.GetDirection());
							gameManager.GetTokenOnGrid()[(e.getY() - 200) / 85][(e.getX() - 85) / 85].SetCanRotate(true);
							tokenOnHolding = null;
						} else {
							gameManager.GetTokenOnGrid()[rowTmp][columnTmp].SetTokenType(tokenOnHolding.GetTokenType());
							gameManager.GetTokenOnGrid()[rowTmp][columnTmp].SetDirection(tokenOnHolding.GetDirection());
							tokenOnHolding = null;
						}
					}
				}
				onMouseRightBtnClicked = false;
			}
		}
	}
	class PanelMouseMotionEvent extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			super.mouseDragged(e);

			if(tokenOnHolding != null && onMouseRightBtnClicked) {
				tokenOnHolding.SetX(e.getX() - tokenOnHolding.GetTokenSize() / 2);
				tokenOnHolding.SetY(e.getY() - tokenOnHolding.GetTokenSize() / 2);
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) 
		{
			super.mouseMoved(e);
		}
		
	}

	class ButtonEventListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(((JButton)e.getSource()).getText() == "<=====") {
				if(gameManager.GetStageNum() == 1) gameManager.SetStageNum(17);
				else gameManager.SetStageNum(gameManager.GetStageNum() - 1);
			}
			else if(((JButton)e.getSource()).getText() == "=====>") {
				if(gameManager.GetStageNum() == 17) gameManager.SetStageNum(1);
				else gameManager.SetStageNum(gameManager.GetStageNum() + 1);
			}
			else if(((JButton)e.getSource()).getText() == "SELECT") {
				String cardInfoStr;
				GameCard card = gameManager.GetCardList().get(gameManager.GetStageNum() - 1);
				cardInfoStr = "[ About the selected stage ]" + "\n"
						       + "- CardNumber : " + card.GetCardNum() + "\n" 
				               + "- Difficulty : " + card.GetDifficulty() + "\n"
				               + "- TargetNumber : " + card.GetTargetNum();

				int result = JOptionPane.showConfirmDialog(null, cardInfoStr);
				if(result == 0) {
					leftBtn.setVisible(false);
					rightBtn.setVisible(false);
					selectBtn.setVisible(false);
					
					backBtn.setVisible(true);
					initBtn.setVisible(true);
					solutionBtn.setVisible(true);
					
					gameManager.SetUpStage();
					sceneNum = 1;
				}
			}
			else if(((JButton)e.getSource()).getText() == "<=BACK=") {
				int result = JOptionPane.showConfirmDialog(null, "ī�弱��â���� �ǵ��ư���");
				if(result == 0) {
					leftBtn.setVisible(true);
					rightBtn.setVisible(true);
					selectBtn.setVisible(true);
					
					backBtn.setVisible(false);
					initBtn.setVisible(false);
					solutionBtn.setVisible(false);
					sceneNum = 0;
				}
			}
			else if(((JButton)e.getSource()).getText() == "Initialize") {
				int result = JOptionPane.showConfirmDialog(null, "�������� �ʱ�ȭ");
				if(result == 0) gameManager.SetUpStage();
			}
			else if(((JButton)e.getSource()).getText() == "Solution") {
				int result = JOptionPane.showConfirmDialog(null, "�ַ�� ����");
				if(result == 0) gameManager.SetUpSolution();

			}
		}
	}
	
	private GameToken tokenOnHolding;
	private GameManager gameManager;
	private int sceneNum, doubleClickCount, doubleClickTimer;
	private boolean onMouseRightBtnClicked;
	
	private JButton leftBtn, rightBtn, selectBtn, backBtn, initBtn, solutionBtn;
	
	public GamePanel(int width, int height) {
		setLayout(null);
		setBounds(0, 0, width, height);
		SetUpButton();
		sceneNum = 0;
		this.addMouseListener(new PanelMouseEvent());
		this.addMouseMotionListener(new PanelMouseMotionEvent());
	}
	
	public void SetGameManager(GameManager gameManager)
	{
		this.gameManager = gameManager;
	}
	
	
	public int GetDoubleClickCount()
	{
		return doubleClickCount;
	}
	public void SetDoubleClickCount(int doubleClickCount)
	{
		this.doubleClickCount = doubleClickCount;
	}
	
	
	public int GetDoubleClickTimer()
	{
		return doubleClickTimer;
	}
	public void SetDoubleClickTimer(int doubleClickTimer)
	{
		this.doubleClickTimer = doubleClickTimer;
	}
	
	public void SetUpButton() {
		leftBtn = new JButton("<=====");
		rightBtn = new JButton("=====>");
		selectBtn = new JButton("SELECT");
		backBtn = new JButton("<=BACK=");
		initBtn = new JButton("Initialize");
		solutionBtn = new JButton("Solution");
		
		leftBtn.setBounds(100, 700, 100, 50);
		rightBtn.setBounds(400, 700, 100, 50);
		selectBtn.setBounds(250, 700, 100, 50);
		backBtn.setBounds(0, 660, 100, 50);
		initBtn.setBounds(250, 660, 100, 50);
		solutionBtn.setBounds(490, 660, 100, 50);
		
		leftBtn.addActionListener(new ButtonEventListener());
		rightBtn.addActionListener(new ButtonEventListener());
		selectBtn.addActionListener(new ButtonEventListener());
		backBtn.addActionListener(new ButtonEventListener());
		initBtn.addActionListener(new ButtonEventListener());
		solutionBtn.addActionListener(new ButtonEventListener());
		
		add(leftBtn);
		add(rightBtn);
		add(selectBtn);
		add(backBtn);
		add(initBtn);
		add(solutionBtn);
		
		backBtn.setVisible(false);
		initBtn.setVisible(false);
		solutionBtn.setVisible(false);
	}
	
	public void DrawToken(Graphics2D g2d, GameToken token) {
		BufferedImage tokenImg = null;
		switch(token.GetTokenType()) {
	        case RED:
	    	    tokenImg = gameManager.GetTokenImgList().get(0);
		        break;
	        case RED_QMARK:
	    	    tokenImg = gameManager.GetTokenImgList().get(1);
	    	    break;
	        case YELLOW:
	    	    tokenImg = gameManager.GetTokenImgList().get(2);
		        break;
	        case YELLOW_QMARK:
	    	    tokenImg = gameManager.GetTokenImgList().get(3);
	    	    break;
	        case GREEN:
	    	    tokenImg = gameManager.GetTokenImgList().get(4);
		        break;
	        case GREEN_QMARK:
	    	    tokenImg = gameManager.GetTokenImgList().get(5);
	    	    break;
	        case BLUE:
	    	    tokenImg = gameManager.GetTokenImgList().get(6);
		        break;
	        case BLUE_QMARK:
	    	    tokenImg = gameManager.GetTokenImgList().get(7);
	    	    break;
	        case PURPLE:
	    	    tokenImg = gameManager.GetTokenImgList().get(8);
	    	    break;
	        case PURPLE_QMARK:
	    	    tokenImg = gameManager.GetTokenImgList().get(9);
	    	    break;
	        case PURPLE2:
	    	    tokenImg = gameManager.GetTokenImgList().get(10);
	    	    break;
	        case PURPLE2_QMARK:
	    	    tokenImg = gameManager.GetTokenImgList().get(11);
	    	    break;
	        case BLACK:
	    	    tokenImg = gameManager.GetTokenImgList().get(12);
	    	    break;
		    default:
			    break;
		}
		g2d.rotate(Math.PI * token.GetAngle() / 2, token.GetX() + token.GetTokenSize() / 2 , token.GetY() + token.GetTokenSize() / 2);
    	g2d.drawImage(tokenImg, token.GetX(), token.GetY(), token.GetTokenSize(), token.GetTokenSize(), null);
		g2d.rotate(-Math.PI * token.GetAngle() / 2, token.GetX() + token.GetTokenSize() / 2 , token.GetY() + token.GetTokenSize() / 2);
	}
	
	public void DrawString(Graphics2D g2d, String str, Font font, Color color, int x, int y) {
		g2d.setFont(font);
		g2d.setColor(color);
		g2d.drawString(str, x, y);
	}
	
	public void DrawGridAndToken(Graphics2D g2d) {
		for(int i = 0; i < gameManager.GetGridMaxRow(); i++) {
			for(int j = 0; j < gameManager.GetGridMaxColumn(); j++) {
				GameToken token = gameManager.GetTokenOnGrid()[i][j];
				g2d.drawRect(85 + j * 85, 200 + i * 85, token.GetTokenSize(), token.GetTokenSize());
				DrawToken(g2d, token);
			}
		}
	}
	public void DrawAddToGrid(Graphics2D g2d) {
		for(int i = 0; i < gameManager.GetAddToGridList().size(); i++) {
			if(gameManager.GetAddToGridList().get(i).GetTokenType() != TokenType.EMPTY) {
				GameToken token = gameManager.GetAddToGridList().get(i);
				DrawToken(g2d, token);
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		switch(sceneNum) {
		    case 0:
				DrawString(g2d, "LAZER MAZE", new Font("Arial", Font.ITALIC, 50), Color.RED, 140, 75);
				DrawString(g2d, "SELECT THE CARD", new Font("Arial", Font.BOLD, 20), Color.BLACK, 210, 120);
		    	g2d.drawImage(gameManager.GetCardImgList().get(gameManager.GetStageNum() - 1), 125, 150, 350, 500, null);
			    break;
			    
		    case 1:
				DrawString(g2d, "LAZER MAZE", new Font("Arial", Font.ITALIC, 50), Color.RED, 140, 50);
				DrawString(g2d, "ADD TO GRID", new Font("Arial", Font.BOLD, 20), Color.BLACK, 15, 90);
				DrawString(g2d, "TARGETS OF # [ " + gameManager.GetCardList().get(gameManager.GetStageNum() - 1).GetTargetNum() + " ] ", new Font("Arial", Font.BOLD, 20), Color.BLACK, 400, 150);
				g2d.setStroke(new BasicStroke(3));
				
				g2d.drawLine(0, 180, this.getWidth(), 180);
				g2d.drawLine(0, 650, this.getWidth(), 650);
				g2d.drawString(" [ " + gameManager.GetCardList().get(gameManager.GetStageNum() - 1).GetDifficulty() + " ] ", 0, 750);
				g2d.drawString(" [ Card : " + gameManager.GetCardList().get(gameManager.GetStageNum() - 1).GetCardNum() + " ] ", 470, 750);
				
				DrawGridAndToken(g2d);
				DrawAddToGrid(g2d);
				if(tokenOnHolding != null) {
					DrawToken(g2d, tokenOnHolding);
				}
				g2d.setColor(Color.red);
				if(gameManager.GetPathList().size() > 0) {
					for(int i = 0; i < gameManager.GetPathList().size(); i++) {
						Node node = gameManager.GetPathList().get(i);
						Node leftChild = gameManager.GetPathList().get(i).GetLeftChild();
						Node rightChild = gameManager.GetPathList().get(i).GetRightChild();
						if(leftChild != null) {
							g2d.drawLine(node.GetX() + 40, node.GetY() + 40, leftChild.GetX() + 40, leftChild.GetY() + 40);
						}
						if(rightChild != null) {
							g2d.drawLine(node.GetX() + 40, node.GetY() + 40, rightChild.GetX() + 40, rightChild.GetY() + 40);
						}
					}
				}
		 	    break;
		}
	}
}
