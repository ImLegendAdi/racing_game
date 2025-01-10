package racing_game.player.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import racing_game.model.player;


public class playerDAO {
	
	private String  jdbcURL="jdbc:mysql://localhost:3306/racing_game";
	private String  jdbcUserName="root";
	private String  jdbcPassword="root";
	
	private static final String INSERT_PLAYER_SQL="INSERT INTO player"+ "( player_id ,player_name, score, level) VALUES "+" (????);";
    private static final String SELECT_PLAYER_BY_player_id= "SELECT * FROM PLAYER WHERE PLAYER_ID=?;";
    private static final String SELECT_ALL_PLAYER_="SELECT * FROM PLAYER ;";
    private static final String Delete_PLAYER_SQL_="DELETE * FROM PLAYER WHERE PLAYER_ID=? ;";
    private static final String UPDATE_PLAYER_SQL_="UPDATE PLAYER SET PLAYER_NAME=?, SCORE=? LEVEL=?,DATE_PLAYED=? where PLAYER_ID=?;";
	
    
    public playerDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    public Connection getConnection()
    
    {
    	Connection  connection=null;
    	
    	try 
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		connection=DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
    		
    	}
    	
    	
    	catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return connection;
	}
    
    public void insertPlayer(player player)
	{
		playerDAO dao=new playerDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_PLAYER_SQL);
			preparedStatement.setInt(1,player.getPlayer_id ());
			preparedStatement.setString(2,player.getPlayer_name());
			preparedStatement.setInt(3,player.getScore());
			preparedStatement.setInt(4,player.getLevel());
		
			
			preparedStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
    public player selectplayerr(int player_id)
	{
		player user=new player();
		playerDAO dao=new playerDAO();

		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_PLAYER_BY_player_id);
			preparedStatement.setInt(1, player_id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
		
				
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
		}
	
	
	public List<player> selectAllplayer()
	{
		List<player> users=new ArrayList<player>();
		playerDAO dao=new playerDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_PLAYER_);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			
			while(resultSet.next())
			{
				int player_id=resultSet.getInt("player_idid");
				String player_name=resultSet.getString("player_name");
				int score=resultSet.getInt("score");
				int level=resultSet.getInt("level");
				
				
				player.add(new player(player_id,player_name,score,level));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
		
		}
	
	public boolean deleteUser(int id)
	{
		boolean status=false;
		playerDAO dao=new playerDAO();
		
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement(Delete_PLAYER_SQL_);
			preparedStatement.setInt(1, id);
			
			status=preparedStatement.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		}
	public List<player> selectAllPlayers() {
        List<player> players = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PLAYERS);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int playerId = rs.getInt("player_id");
                String playerName = rs.getString("player_name");
                int score = rs.getInt("score");
                int level = rs.getInt("level");
                players.add(new player(playerId, playerName, score, level));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    public boolean deletePlayer(int playerId) {
        boolean status = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PLAYER_SQL)) {
            preparedStatement.setInt(1, playerId);
            status = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean updatePlayer(player player) {
        boolean status = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PLAYER_SQL)) {
            preparedStatement.setString(1, player.getPlayer_name());
            preparedStatement.setInt(2, player.getScore());
            preparedStatement.setInt(3, player.getLevel());
      
            preparedStatement.setInt(5, player.getPlayer_id());
            status = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}


