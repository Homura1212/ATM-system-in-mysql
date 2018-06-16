package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import dao.CardDao;
import util.MyButton;

public class BalancePage extends ATMManage implements MouseListener{

	static BalancePage balancePage;
	private MyButton back;
	private JLabel balanceLabel,tipsLabel,bLabel;
	private float balance;
	public BalancePage(String tips1,String tips2) {
		if(tips1!=null) {
			tipsLabel=new JLabel(tips1);
			tipsLabel.setBounds(300,150,400,60);
			tipsLabel.setFont(new Font("黑体", Font.BOLD, 60));
			tipsLabel.setForeground(Color.orange);
			panel.add(tipsLabel);
		}
		
		balanceLabel=new JLabel(tips2);
		balanceLabel.setBounds(150,300,400,60);
		balanceLabel.setFont(new Font("黑体", Font.BOLD, 50));
		balanceLabel.setForeground(Color.orange);
		panel.add(balanceLabel);
		
		balance=CardDao.executeBalance(LoginPage.CardID);
		bLabel=new JLabel(balance+"");
		bLabel.setBounds(350,400,700,60);
		bLabel.setFont(new Font("黑体", Font.BOLD, 50));
		bLabel.setForeground(Color.orange);
		panel.add(bLabel);
		
		
		//添加返回按钮
		back=new MyButton("back","gif");
		back.setBounds(30,600,170,60);
		panel.add(back);
		back.addMouseListener(this);
		
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==back) {
			balancePage.dispose();
			TradingPage.tradingPage.setVisible(true);
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
