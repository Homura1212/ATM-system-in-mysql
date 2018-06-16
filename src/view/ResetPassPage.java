package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import util.MyButton;

public class ResetPassPage extends ATMManage implements MouseListener{

	static ResetPassPage resetPassPage;
	private MyButton back,confirm;
	private JLabel oldPassLabel,newPassLabel,newPassLabel2,welcome;
	private JPasswordField oldPass,newPass,newPass2;
	private JLabel[] wrongLabel4=new JLabel[3];
	private JLabel[] rightLabel4=new JLabel[3];
	
	public ResetPassPage() {
		
		welcome=new JLabel("修改密码");
		welcome.setBounds(100,100,700,100);
		welcome.setFont(new Font("黑体", Font.BOLD, 50));
		welcome.setForeground(Color.orange);
		panel.add(welcome);
		
		oldPassLabel=new JLabel("原密码：");
		oldPassLabel.setBounds(150,230,180,50);
		oldPassLabel.setFont(new Font("宋体",Font.PLAIN,35));
		oldPassLabel.setForeground(Color.white);
		panel.add(oldPassLabel);
		oldPass =new JPasswordField();
		oldPass.setBounds(330,230,300,50);
		oldPass.setFont(new Font("宋体",Font.BOLD,35));
		panel.add(oldPass);
		
		newPassLabel=new JLabel("新密码：");
		newPassLabel.setBounds(150,330,180,50);
		newPassLabel.setFont(new Font("宋体",Font.PLAIN,35));
		newPassLabel.setForeground(Color.white);
		panel.add(newPassLabel);
		newPass =new JPasswordField();
		newPass.setBounds(330,330,300,50);
		newPass.setFont(new Font("宋体",Font.BOLD,35));
		panel.add(newPass);
		
		newPassLabel2=new JLabel("确认密码：");
		newPassLabel2.setBounds(150,430,180,50);
		newPassLabel2.setFont(new Font("宋体",Font.PLAIN,35));
		newPassLabel2.setForeground(Color.white);
		panel.add(newPassLabel2);
		newPass2 =new JPasswordField();
		newPass2.setBounds(330,430,300,50);
		newPass2.setFont(new Font("宋体",Font.BOLD,35));
		panel.add(newPass2);
		
		
		//添加确认按钮
		confirm=new MyButton("confirm","gif");
		confirm.setBounds(700,600,170,60);
		panel.add(confirm);
		confirm.addMouseListener(this);
		
		//添加返回按钮
		back=new MyButton("back","gif");
		back.setBounds(30,600,170,60);
		panel.add(back);
		back.addMouseListener(this);
		
		setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==confirm) {
			if(isRight()) {
				JOptionPane.showMessageDialog(resetPassPage, "修改成功！");
				resetPassPage.dispose();
				TradingPage.tradingPage.setVisible(true);
			}
		}
		else if(e.getSource()==back) {
			resetPassPage.dispose();
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
	
	public boolean isRight() {
		int flag=0;
		//卡号不存在
		if(false) {
			wrongLabel4[0]=new JLabel("卡号不存在");
			wrongLabel4[0].setFont(new Font("宋体",Font.BOLD,15));
			wrongLabel4[0].setForeground(Color.RED);
			wrongLabel4[0].setBounds(200,270,100,50);
			panel.add(wrongLabel4[0]);
			repaint();
			flag=1;
		}
		else {
			rightLabel4[0]=new JLabel("√");
			rightLabel4[0].setFont(new Font("宋体",Font.BOLD,15));
			rightLabel4[0].setForeground(Color.green);
			rightLabel4[0].setBounds(450,230,100,50);
			panel.add(rightLabel4[0]);
			repaint();
		}
		if(false) {
			wrongLabel4[1]=new JLabel("密码错误");
			wrongLabel4[1].setFont(new Font("宋体",Font.BOLD,15));
			wrongLabel4[1].setForeground(Color.RED);
			wrongLabel4[1].setBounds(200,370,100,50);
			panel.add(wrongLabel4[1]);
			repaint();
			flag=1;
		}
		else {
			rightLabel4[1]=new JLabel("√");
			rightLabel4[1].setFont(new Font("宋体",Font.BOLD,15));
			rightLabel4[1].setForeground(Color.green);
			rightLabel4[1].setBounds(450,330,100,50);
			panel.add(rightLabel4[1]);
			repaint();
		}
		if(flag==1) return false;
		return true;
	}
	public void removeLabel() {
		for(int i=0;i<3;i++) {
			try{
				panel.remove(wrongLabel4[i]);
				panel.remove(rightLabel4[i]);
			}
			catch (Exception e) {
			}finally {
			}
		}
	}
}
