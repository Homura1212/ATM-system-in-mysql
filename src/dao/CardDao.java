package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.CardInfo;

public class CardDao extends BaseDao {

	static Connection conn;
	
	//添加CardInfo
	public static boolean executeInsert(CardInfo card) {
		conn=getConn();
		int state=0;
		String sql="insert into cardinfo(cardID,curType,savingType,openDate,openMoney,balance,"
				+ "pass,IsReportLoss,customerID) values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.setString(1,card.getCardID());
			pStatement.setString(2, card.getCurType());
			pStatement.setString(3, card.getSavingType());
			pStatement.setDate(4, (Date) card.getOpenDate());
			pStatement.setFloat(5, card.getOpenMoney());
			pStatement.setFloat(6, card.getBalance());
			pStatement.setString(7, card.getPass());
			pStatement.setString(8, card.isIsReportLoss()?"是":"否");
			pStatement.setInt(9, card.getCustomerID());
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
	
	//根据用户ID来删除该UserInfo
	public static boolean executeDelete(String cardID) {
		conn=getConn();
		int state=0;
		String sql="delete from cardinfo where cardID=?";
		try {
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.setString(1,cardID);
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
}
