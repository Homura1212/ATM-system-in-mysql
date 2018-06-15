package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import util.MyButton;

public class LostPage extends ATMManage implements MouseListener,KeyListener{

	static LostPage lostPage;
	private MyButton confirm,back;
	private JLabel cardIDLabel,nameLabel,IDLabel,telephoneLabel,tips;
	private JTextField cardID,name,ID,telephone;
	public LostPage() {
		
		tips=new JLabel("请填写挂失银行卡的信息：");
		tips.setBounds(50,30,640,50);
		tips.setFont(new Font("宋体",Font.BOLD,25));
		tips.setForeground(Color.orange);
		panel.add(tips);
		
		cardIDLabel = new JLabel("挂失卡号：");
		cardIDLabel.setBounds(150,130,180,50);
		cardIDLabel.setFont(new Font("宋体",Font.PLAIN,35));
		cardIDLabel.setForeground(Color.white);
		panel.add(cardIDLabel);
		cardID =new JTextField();
		cardID.setBounds(330,130,300,50);
		panel.add(cardID);
		cardID.addKeyListener(this);
		
		nameLabel = new JLabel("开户名  ：");
		nameLabel.setBounds(150,230,180,50);
		nameLabel.setFont(new Font("宋体",Font.PLAIN,35));
		nameLabel.setForeground(Color.white);
		panel.add(nameLabel);
		name =new JTextField();
		name.setBounds(330,230,300,50);
		panel.add(name);

		IDLabel = new JLabel("身份证号：");
		IDLabel.setBounds(150,330,180,50);
		IDLabel.setFont(new Font("宋体",Font.PLAIN,35));
		IDLabel.setForeground(Color.white);
		panel.add(IDLabel);
		ID =new JTextField();
		ID.setBounds(330,330,300,50);
		panel.add(ID);
		ID.addKeyListener(this);
		
		telephoneLabel = new JLabel("联系电话：");
		telephoneLabel.setBounds(150,430,180,50);
		telephoneLabel.setFont(new Font("宋体",Font.PLAIN,35));
		telephoneLabel.setForeground(Color.white);
		panel.add(telephoneLabel);
		telephone =new JTextField();
		telephone.setBounds(330,430,300,50);
		panel.add(telephone);
		telephone.addKeyListener(this);
		
		
		
		
		
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
	public void keyTyped(KeyEvent e) {
		int keyChar = e.getKeyChar();                 
        if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
              
        }else{  
            e.consume(); //关键，屏蔽掉非法输入  
        }  
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==back) {
			lostPage.dispose();
			InitialPage.initialPage.setVisible(true);
		}
		else if(e.getSource()==confirm) {
			
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
