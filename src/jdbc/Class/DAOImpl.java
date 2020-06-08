package jdbc.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.DBconn.DBConn;
import jdbc.IDTable.Character;
import jdbc.IDTable.Inventory;
import jdbc.IDTable.Status;

public class DAOImpl implements DAO {
	private DBConn DB;
	
	public DAOImpl(){
		DB = DBConn.getInstance();
	}
	@Override
	public void insert(Class m) {
		// TODO Auto-generated method stub
		String sql = "insert into ClassName values(?,?,?,?,?,?,?,?,?,?,?) ";
											//ID,PW,Class,LV,EXP,HP,MP,Money,BP,RP,BOOM
		Connection conn = DB.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getClassCode());
			pstmt.setString(2, m.getClassName());
			pstmt.setInt(3, m.getInitMaxHP());
			pstmt.setInt(4, m.getIncMaxHP());
			pstmt.setInt(5, m.getInitMaxMP());
			pstmt.setInt(6, m.getIncMaxMP());
			pstmt.setInt(7, m.getInitMaxEXP());
			pstmt.setInt(8, m.getIncMaxEXP());
			
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Class select(String code) {
		// TODO Auto-generated method stub
		String sql = "select * from ClassName where ClassCode =?";
		Class clas ;
		Connection conn = DB.getConnect();
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String ClassName = rs.getString(2);
				int InitMaxHP	 = rs.getInt(3);
				int IncMaxHP	 = rs.getInt(4);
				int InitMaxMP	 = rs.getInt(5);
				int IncMaxMP	 = rs.getInt(6);
				int InitMaxEXP	 = rs.getInt(7);
				int IncMaxEXP	 = rs.getInt(8);
				
				
				clas = new Class(code,ClassName,InitMaxHP,IncMaxHP,InitMaxMP,IncMaxMP,InitMaxEXP,IncMaxEXP );
				
				return clas;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}

	@Override
	public ArrayList<Class> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from ClassName order by ClassCode";
		ArrayList<Class> list = new ArrayList<Class>();
		ResultSet rs = null;
		
		Connection conn = DB.getConnect();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String code 		 = rs.getString(1);
				String ClassName = rs.getString(2);
				int InitMaxHP	 = rs.getInt(3);
				int IncMaxHP	 = rs.getInt(4);
				int InitMaxMP	 = rs.getInt(5);
				int IncMaxMP	 = rs.getInt(6);
				int InitMaxEXP	 = rs.getInt(7);
				int IncMaxEXP	 = rs.getInt(8);
				Class m = new Class(code,ClassName,InitMaxHP,IncMaxHP,InitMaxMP,IncMaxMP,InitMaxEXP,IncMaxEXP );
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
		
	}

	@Override
	public void update(Class m) {//ID,PW,Class,LV,EXP,HP,MP,Money,BP,RP,BOOM
		// TODO Auto-generated method stub
		String sql = "update ClassName set "
				+ "ClassName	=?, "
				+ "InitMaxHP	=?, "
				+ "IncMaxHP		=?, "
				+ "InitMaxMP	=?, "
				+ "IncMaxMP		=?, "
				+ "InitMaxEXP	=?, "
				+ "IncMaxEXP	=? "
				+ "where ClassCode =?";
		Connection conn = DB.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, m.getClassCode());
			pstmt.setString(1, m.getClassName());
			pstmt.setInt(2, m.getInitMaxHP());
			pstmt.setInt(3, m.getIncMaxHP());
			pstmt.setInt(4, m.getInitMaxMP());
			pstmt.setInt(5, m.getIncMaxMP());
			pstmt.setInt(6, m.getInitMaxEXP());
			pstmt.setInt(7, m.getIncMaxEXP());
			pstmt.setString(8, m.getClassCode());
			
			
			pstmt.executeUpdate();//갱신되 줄 수 반환
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void delete(int code) {
		// TODO Auto-generated method stub
		String sql = "delete ClassName where ClassCode=?";
		Connection conn = DB.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
