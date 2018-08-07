import java.util.ArrayList;
import java.util.List;

class Player{
	private int sets;
	private int games;
	private int points;
	private char id;

	Player(char id){
		this.id = id;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getPoints() {
		return points;
	}

	public String getPointsToString (Player p){
		List <String> points = new ArrayList<String>();
		points.add("0");
		points.add("15");
		points.add("30");
		points.add("40");
		points.add("DisA.");
		points.add("-");
		points.add("Adv.");

		return points.get( this.getPoints()>3 ?
				((this.getPoints()-p.getPoints()) % 2 + 5) :
				this.getPoints());

	}

	public void setPoints(int points) {
		this.points = points;
	}

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}
}

public class Tournament {

	private Player p1;
	private Player p2;

	Tournament(char p1Id,char p2Id){
		p1 = new Player(p1Id);
		p2 = new Player(p2Id);
	}

	private Player getWinner(char winner){
		if (winner == p1.getId()) return p1;
		else return p2;
	}

	private Player getLooser(char winner){
		if (winner != p1.getId()) return p1;
		else return p2;
	}

	private void updateSets(char winner){

		Player winnerPlayer = getWinner(winner);
		winnerPlayer.setSets(winnerPlayer.getSets()+1);
	}

	private void updateGames(char winner){
		Player winnerPlayer = getWinner(winner);
		winnerPlayer.setGames(winnerPlayer.getGames() +1 );

		if( Math.abs(p1.getGames()-p2.getGames()) >= 2 && winnerPlayer.getGames() >= 6 ){
			updateSets( winnerPlayer.getId() );
			p1.setGames(0);
			p2.setGames(0);
		}

	}

	public void updatePoints(char winner){
		List<Integer> points = new ArrayList<Integer>();
		points.add(0); //0
		points.add(15); //1
		points.add(30); //2
		points.add(40); //3
		points.add(50); //4

		Player win = getWinner(winner);
		Player loos = getLooser(winner);

		if (win.getPoints() - loos.getPoints() >=1 && win.getPoints() >= 3){
			win.setPoints(0);
			loos.setPoints(0);
			updateGames(winner);
		} else {
			win.setPoints(((win.getPoints()) + 1));
		}

	}

	public void printScore(){

		System.out.println("player:    " + p1.getId() +"    " + p2.getId());
		System.out.println(String.format("sets:    %3d  %3d",p1.getSets(),p2.getSets()));
		System.out.println(String.format("games:   %3d  %3d",p1.getGames(),p2.getGames()));
		System.out.println(String.format("points:  %3s  %3s",p1.getPointsToString(p2), p2.getPointsToString(p1)));
	}

	public static void main(String args[]){
		String input = "AAA";
		Tournament t = new Tournament('A','B');

		for(int itr = 0; itr < input.length(); itr++){
			t.updatePoints(input.charAt(itr));
		}
		t.printScore();
	}

}

