package SportsMatching;

public class RankingDTO {

	private String UserID;
	private String UserName;
	private String Adress;
	private int UserMmr;
	private String Introduction;
	private int rank;
	
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		this.UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		this.Adress = adress;
	}
	
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		this.Introduction = introduction;
	}
	public int getUserMmr() {
		return UserMmr;
	}
	public void setUserMmr(int userMmr) {
		this.UserMmr = userMmr;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
