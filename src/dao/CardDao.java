package dao;

import java.sql.*;

import model.CardInfo;

public class CardDao extends BaseDao {

	static Connection conn;
	
	//���CardInfo
	public static boolean executeInsert(CardInfo card) {
		conn=getConn();
		int state=0;
		String sql="INSERT INTO cardinfo(cardID,curType,savingType,openDate,openMoney,balance,"
				+ "pass,IsReportLoss,customerID) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.setString(1,card.getCardID());
			pStatement.setString(2, card.getCurType());
			pStatement.setString(3, card.getSavingType());
			pStatement.setDate(4, (Date) card.getOpenDate());
			pStatement.setFloat(5, card.getOpenMoney());
			pStatement.setFloat(6, card.getBalance());
			pStatement.setString(7, card.getPass());
			pStatement.setString(8, card.isIsReportLoss()?"��":"��");
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
	
	//���ݿ�����ɾ����CardInfo
	public static boolean executeDelete(String cardID) {
		conn=getConn();
		int state=0;
		String sql="DELETE FROM cardinfo WHERE cardID=?";
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

	public static int executeLogin(String cardID,String pass) {
		conn=getConn();
		int state=1;//0Ϊ�ɹ���1Ϊ���޴˿���2Ϊ�������
		String sql="SELECT cardID FROM cardinfo WHERE cardID=?";
		try {
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.setString(1,cardID);
			ResultSet rs=pStatement.executeQuery();
			if(rs.next()){
				//Retrieve by column name
				String cardIDForLogin  = rs.getString("cardID");
				//System.out.print("ID: " + id);
				state=0;
            }
            else{
                state=1;
            }
            rs.close();
            //��֤�Ƿ���ڸÿ�������stateΪ0��������Ϊ1
            if(state==0){
                sql = "SELECT pass FROM cardinfo WHERE cardID=?";
                pStatement=conn.prepareStatement(sql);
                pStatement.setString(1,cardID);
                rs=pStatement.executeQuery();
                if(rs.next()){
                    String cardPassForLogin = rs.getString("pass");
                    if(cardPassForLogin.equals(pass)){
                        state=0;
                    }
                    else {
                        state=2;
                    }
                }
                rs.close();
                //��֤�����Ƿ���ȷ����ȷ����0�����󷵻�2
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
