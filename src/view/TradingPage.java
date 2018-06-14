package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import util.MyButton;

public class TradingPage extends ATMManage implements MouseListener{

	static TradingPage tradingPage;
	private MyButton deposit,withdraw,transfer,query,balance,change,exit;
	private JLabel welcome,exitLabel;
	public TradingPage() {
		
		//添加转账按钮
		transfer=new MyButton("transfer","gif");
		transfer.setBounds(700,300,170,60);
		panel.add(transfer);
		transfer.addMouseListener(this);
		
		//添加存款按钮
		deposit=new MyButton("deposit","gif");
		deposit.setBounds(700,400,170,60);
		panel.add(deposit);
		deposit.addMouseListener(this);	
		
		//添加取款按钮
		withdraw=new MyButton("withdraw","gif");
		withdraw.setBounds(700,500,170,60);
		panel.add(withdraw);
		withdraw.addMouseListener(this);	
		
		//添加交易记录按钮
		query=new MyButton("query","gif");
		query.setBounds(30,300,170,60);
		panel.add(query);
		query.addMouseListener(this);
		
		//添加余额查询按钮
		balance=new MyButton("balance","gif");
		balance.setBounds(30,400,170,60);
		panel.add(balance);
		balance.addMouseListener(this);
		
		//添加修改密码按钮
		change=new MyButton("change","gif");
		change.setBounds(30,500,170,60);
		panel.add(change);
		change.addMouseListener(this);
		//添加退出按钮
		exit=new MyButton("exit","gif");
		exit.setBounds(700,600,170,60);
		panel.add(exit);
		exit.addMouseListener(this);
		
		welcome=new JLabel("您好，请选择您需要的服务！");
		welcome.setBounds(100,100,700,100);
		welcome.setFont(new Font("黑体", Font.BOLD, 50));
		welcome.setForeground(Color.white);
		panel.add(welcome);
		
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//存款
		if(e.getSource()==deposit) {
			
		}
		//退出
		else if(e.getSource()==exit) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					exitLabel=new JLabel("感谢使用本ATM管理系统！");
					exitLabel.setFont(new Font("宋体",Font.BOLD,40));
					exitLabel.setForeground(Color.RED);
					exitLabel.setBounds(210,300,600,50);
					panel.add(exitLabel);
					paint(getGraphics());
					try {
						Thread.sleep(1500);
						System.exit(0);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
