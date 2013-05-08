package zombieProject.shared;

import java.io.Serializable;

public class Score implements Serializable {
	private static final long serialVersionUID = 1L;

	private int userId;
	private int score;
	
	public Score() {
		
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setScore(int i) {
		this.score = i;
	}
	
	public int getScore() {
		return score;
	}
}
