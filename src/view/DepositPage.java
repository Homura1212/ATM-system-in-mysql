package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import util.MyButton;

public class DepositPage extends ATMManage implements MouseListener{

	static DepositPage depositPage;
	private JLabel welcome;
	private MyButton y100,y500,y1000,y2000,y5000,y10000,confirm,back;
	public DepositPage() {
		//添加100元按钮
		y100=new MyButton("100","gif");
		y100.setBounds(700,300,170,60);
		panel.add(y100);
		y100.addMouseListener(this);
		
		//添加500元按钮
		y500=new MyButton("500","gif");
		y500.setBounds(700,400,170,60);
		panel.add(y500);
		y500.addMouseListener(this);	
		
		//添加1000元按钮
		y1000=new MyButton("1000","gif");
		y1000.setBounds(700,500,170,60);
		panel.add(y1000);
		y1000.addMouseListener(this);	
		
		//添加200元按钮
		y2000=new MyButton("2000","gif");
		y2000.setBounds(30,300,170,60);
		panel.add(y2000);
		y2000.addMouseListener(this);
		
		//添加5000元按钮
		y5000=new MyButton("5000","gif");
		y5000.setBounds(30,400,170,60);
		panel.add(y5000);
		y5000.addMouseListener(this);
		
		//添加10000元按钮
		y10000=new MyButton("10000","gif");
		y10000.setBounds(30,500,170,60);
		panel.add(y10000);
		y10000.addMouseListener(this);
		//添加确认按钮
		confirm=new MyButton("exit","gif");
		confirm.setBounds(700,600,170,60);
		panel.add(confirm);
		confirm.addMouseListener(this);
		
		welcome=new JLabel("请输入存款金额：");
		welcome.setBounds(100,100,700,100);
		welcome.setFont(new Font("黑体", Font.BOLD, 50));
		welcome.setForeground(Color.white);
		panel.add(welcome);
		
		setVisible(true);		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
