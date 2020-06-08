package jdbc.EventTable;

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
	public void insert(Event ev) {
		// TODO Auto-generated method stub
		String sql = "insert into EventTable values(?,?) ";
		//code,name,reclv,hp,power,exp,money
		String state = "0";
		if(ev.isState()){
			state = "1";
		}
		Connection conn = DB.getConnect();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ev.getName());
			pstmt.setString(2, state);
			

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
	public Event select(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from EventTable where EventName =?";
		Event ev ;
		Connection conn = DB.getConnect();
		ResultSet rs = null;
		boolean st=false;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()){//code,name,reclv,hp,power,exp,money
				String state = rs.getString(2);
				if(state.equals("1")){
					st = true;
				}
				
				ev = new Event(name,st);
				
				return ev;
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
	public ArrayList<Event> selectAll() {
		// TODO Auto-generated method stub
		String sql = "select * from EventTable";
		ArrayList<Event> list = new ArrayList<Event>();
		
		Event ev;
		ResultSet rs = null;
		
		Connection conn = DB.getConnect();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String name = rs.getString(1);
				String state = rs.getString(2);
				boolean st =false;
				if(state.equals("1")){
					st = true;
				}
				
				ev = new Event(name,st);
				list.add(ev);
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
	public void update(Event ev) {
		// TODO Auto-generated method stub
		String sql = "update EventTable set "
				+ "EventState =? "
				+ "where EventName =?";
		
		Connection conn = DB.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			String state = "0";
			if(ev.isState()){
				state = "1";
			}
			pstmt.setString(1, state);
			pstmt.setString(2, ev.getName());
			
			
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
	public void delete(String name) {
		// TODO Auto-generated method stub
		String sql = "delete EventTable where EventName = ?";
		Connection conn = DB.getConnect();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
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
