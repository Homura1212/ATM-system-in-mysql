package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import util.MyButton;
import util.RandomID;

public class InitialPage extends ATMManage implements MouseListener{

	static InitialPage initialPage;
	MyButton lost,login,register,exit;
	JLabel welcome;
	
	public InitialPage() {
		
		//添加登录按钮
		login=new MyButton("login","gif");
		login.setBounds(700,300,170,60);
		panel.add(login);
		login.addMouseListener(this);
	
		
		//添加注册按钮
		register=new MyButton("register","gif");
		register.setBounds(700,400,170,60);
		panel.add(register);
		register.addMouseListener(this);	
		
		//添加挂失按钮
		lost=new MyButton("lost","gif");
		lost.setBounds(700,500,170,60);
		panel.add(lost);
		lost.addMouseListener(this);	
		
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
	
	public static void main(String[] args) {
		initialPage=new InitialPage();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==login) {
			setVisible(false);
			LoginPage.loginPage=new LoginPage();
		}
		else if(e.getSource()==register) {
			initialPage.setVisible(false);
			RegisterPage1.registerPage1=new RegisterPage1();
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
