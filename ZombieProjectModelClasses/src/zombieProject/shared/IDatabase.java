package zombieProject.shared;

public interface IDatabase {
	public User logIn(String username, String password);

	public Score getScore(int ID);

	public void setScore(Score score);

}
