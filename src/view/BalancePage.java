package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

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
			tipsLabel.setFont(new Font("����", Font.BOLD, 60));
			tipsLabel.setForeground(Color.orange);
			panel.add(tipsLabel);
		}
		
		balanceLabel=new JLabel(tips2);
		balanceLabel.setBounds(150,300,400,60);
		balanceLabel.setFont(new Font("����", Font.BOLD, 50));
		balanceLabel.setForeground(Color.orange);
		panel.add(balanceLabel);
		
		bLabel=new JLabel(balance+"");
		bLabel.setBounds(350,400,700,60);
		bLabel.setFont(new Font("����", Font.BOLD, 50));
		bLabel.setForeground(Color.orange);
		panel.add(bLabel);
		
		
		//���ӷ��ذ�ť
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