package dao;

import java.sql.*;

import model.TransInfo;

import static dao.BaseDao.getConn;

public class TransDao {
    static Connection conn;
    public static TransInfo[] executeGetAllRecords(String cardID) {
        conn=getConn();
        TransInfo[] results=new TransInfo[65535];
        ResultSet rs;
        String sql="SELECT * FROM transinfo WHERE cardID=?";
        try {
            PreparedStatement pStatement=conn.prepareStatement(sql);
            pStatement.setString(1,cardID);
            rs=pStatement.executeQuery();
            int cnt=0;
            while(rs.next()) {
                results[cnt].setCardID(rs.getString("cardID"));
                results[cnt].setOtherCardID(rs.getString("otherCardID"));//不知道是不是这个变量名且不知道null会不会报错
                results[cnt].setTransMoney(rs.getFloat("transMoney"));
                results[cnt].setTransDate(rs.getDate("transDate"));
                results[cnt].setTransType(rs.getString("transType"));
                results[cnt].setRemark(rs.getString("remark"));
                cnt++;
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
        return results;
    }
}
