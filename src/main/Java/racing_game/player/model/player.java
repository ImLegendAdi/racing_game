package racing_game.player.model;

public class player {
	
	private int player_id;
	private String player_name;
	private int score;
	private int level;
	
	public player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public player(int player_id, String player_name, int score, int level) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
		this.score = score;
		this.level = level;

	}
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	
	}
	public static void add(player player) {
		// TODO Auto-generated method stub
	}
	
}
