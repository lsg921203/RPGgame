package jdbc.Monster;

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
	public void insert(Monster m) {
		// TODO Auto-generated method stub
		String sql = "insert into MonsterTable values(?,?,?,?,?,?,?) ";
		//code,name,reclv,hp,power,exp,money
		Connection conn = DB.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getMonsterNumber());
			pstmt.setString(2, m.getMonsterName());
			pstmt.setString(3, m.getRecomLV());
			pstmt.setInt(4, m.getMonsterHP());
			pstmt.setInt(5, m.getMonsterPower());
			pstmt.setInt(6, m.getRewardEXP());
			pstmt.setInt(7, m.getRewardMoney());
			

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
	public Monster select(int MonsterCode) {
		// TODO Auto-generated method stub
		String sql = "select * from MonsterTable where ID=?";
		Monster m ;
		Connection conn = DB.getConnect();
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, MonsterCode);
			rs = pstmt.executeQuery();
			
			while(rs.next()){//code,name,reclv,hp,power,exp,money
				String name = rs.getString(2);
				String RECLV = rs.getString(3);
				int HP = rs.getInt(4);
				int Power = rs.getInt(5);
				int Exp = rs.getInt(6);
				int Money = rs.getInt(7);
				
				
				m = new Monster(MonsterCode,name,RECLV,HP,Power,Exp,Money);
				
				return m;
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
	public ArrayList<Monster> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from MonsterTable order by MonsterCode";
		ArrayList<Monster> list = new ArrayList<Monster>();
		Monster m;
		ResultSet rs = null;
		
		Connection conn = DB.getConnect();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int MonsterCode = rs.getInt(1);
				String name = rs.getString(2);
				String RECLV = rs.getString(3);
				int HP = rs.getInt(4);
				int Power = rs.getInt(5);
				int Exp = rs.getInt(6);
				int Money = rs.getInt(7);
				 m = new Monster(MonsterCode,name,RECLV,HP,Power,Exp,Money);
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
	public void update(Monster m) {//ID,PW,Class,LV,EXP,HP,MP,Money,BP,RP,BOOM
		// TODO Auto-generated method stub
		String sql = "update MonsterTable set "
				+ "MonsterName		=?, "
				+ "RecommandLevel	=?, "
				+ "MonsterHP		=?, "
				+ "MonsterPower		=?, "
				+ "RewardExp		=?, "
				+ "RewardMoney		=? "
				+ "where MonsterCode=?  ";
		
		
		Connection conn = DB.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMonsterName());
			pstmt.setString(2, m.getRecomLV());
			pstmt.setInt(3, m.getMonsterHP());
			pstmt.setInt(4, m.getMonsterPower());
			pstmt.setInt(5, m.getRewardEXP());
			pstmt.setInt(6, m.getRewardMoney());
			pstmt.setInt(7, m.getMonsterNumber());
			
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
	public void delete(int MonsterCode) {
		// TODO Auto-generated method stub
		String sql = "delete MonsterTable where MonsterCode=?";
		Connection conn = DB.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, MonsterCode);
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
