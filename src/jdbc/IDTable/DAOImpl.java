package jdbc.IDTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.DBconn.DBConn;



public class DAOImpl implements DAO {

	private DBConn DB;
	
	public DAOImpl(){
		DB = DBConn.getInstance();
	}
	@Override
	public void insert(Character m) {
		// TODO Auto-generated method stub
		String sql = "insert into IDTable values(?,?,?,?,?,?,?,?,?,?,?) ";
											//ID,PW,Class,LV,EXP,HP,MP,Money,BP,RP,BOOM
		Connection conn = DB.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getID());
			pstmt.setString(2, m.getPW());
			pstmt.setString(3, m.getCLS());
			pstmt.setInt(4, m.getStat().getLV());
			pstmt.setInt(5, m.getStat().getExp());
			pstmt.setInt(6, m.getStat().getHP());
			pstmt.setInt(7, m.getStat().getMP());
			pstmt.setInt(8, m.getInven().getMoney());
			pstmt.setInt(9, m.getInven().getBluePotion());
			pstmt.setInt(10, m.getInven().getRedPotion());
			pstmt.setInt(11, m.getInven().getBoom());
			
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
	public Character select(String ID) {
		// TODO Auto-generated method stub
		String sql = "select * from IDTable where ID=?";
		Character character ;
		Connection conn = DB.getConnect();
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String PW = rs.getString(2);
				String Class = rs.getString(3);
				int LV = rs.getInt(4);
				int EXP = rs.getInt(5);
				int HP = rs.getInt(6);
				int MP = rs.getInt(7);
				int Money = rs.getInt(8);
				int BP = rs.getInt(9);
				int RP = rs.getInt(10);
				int Boom = rs.getInt(11);
				
				character = new Character(ID,PW,Class,new Inventory(Money,BP,RP,Boom), new Status(LV,EXP,HP,MP));
				
				return character;
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
	public void update(Character character) {//ID,PW,Class,LV,EXP,HP,MP,Money,BP,RP,BOOM
		// TODO Auto-generated method stub
		String sql = "update IDTable set LV=?, Exp=?, Hp=?, Mp=?, Money=?, BluePotion=?, RedPotion=?, Boom=? where ID=?";
		Connection conn = DB.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, character.getStat().getLV());
			pstmt.setInt(2, character.getStat().getExp());
			pstmt.setInt(3, character.getStat().getHP());
			pstmt.setInt(4, character.getStat().getMP());
			pstmt.setInt(5, character.getInven().getMoney());
			pstmt.setInt(6, character.getInven().getBluePotion());
			pstmt.setInt(7, character.getInven().getRedPotion());
			pstmt.setInt(8, character.getInven().getBoom());
			pstmt.setString(9, character.getID());
			
			
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
	public void delete(String ID) {
		// TODO Auto-generated method stub
		String sql = "delete IDTable where ID=?";
		Connection conn = DB.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ID);
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
	public ArrayList<Character> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from IDTable order by LV desc, EXP desc";
		ArrayList<Character> list = new ArrayList<Character>();
		ResultSet rs = null;
		
		Connection conn = DB.getConnect();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String ID = rs.getString(1);
				String PW = rs.getString(2);
				String Class = rs.getString(3);
				int LV = rs.getInt(4);
				int EXP = rs.getInt(5);
				int HP = rs.getInt(6);
				int MP = rs.getInt(7);
				int Money = rs.getInt(8);
				int BP = rs.getInt(9);
				int RP = rs.getInt(10);
				int Boom = rs.getInt(11);
				Character m = new Character(ID,PW,Class,new Inventory(Money,BP,RP,Boom), new Status(LV,EXP,HP,MP));
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
	
}
