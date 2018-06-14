package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.UserInfo;

public class UserDao extends BaseDao{

	static Connection conn;
	
	//���UserInfo
	public static boolean executeInsert(UserInfo user) {
		conn=getConn();
		int state=0;
		String sql="insert into userinfo(customerID,customerName,PID,telephone,address) values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.setInt(1,user.getCustomerID());
			pStatement.setString(2, user.getCustomerName());
			pStatement.setString(3, user.getPID());
			pStatement.setString(4, user.getTelephone());
			pStatement.setString(5, user.getAddress());
			
			state=pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(state!=1)return false;
		return true;
	}
	
	//�����û�ID��ɾ����UserInfo
	public static boolean executeDelete(int customerID) {
		conn=getConn();
		int state=0;
		String sql="delete from userinfo where customerID=?";
		try {
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.setInt(1,customerID);
			state=pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(state!=1)return false;
		return true;
	}
	
	//��ѯ�˱��������û�ID���Թ��ṩ��ע���û�ID
	public static int executeQueryMaxID() {
		conn=getConn();
		int state=0;
		ResultSet rs;
		String sql="select max(customerID) from userinfo";
		try {
			Statement statement=conn.createStatement();
			rs=statement.executeQuery(sql);
			while(rs.next()) {
				state=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return state;
	}	
	
}
