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
		getWinner(winner).setSets(getWinner(winner).getSets() + 1);
	}

	private void updateGames(char winner){

	}

	public void updatePoints(char winner){
		List<Integer> points = new ArrayList<Integer>();
		points.add(0); //0
		points.add(1); //1
		points.add(2); //2
		points.add(3); //3
		points.add(4); //4
		points.add(5); //5

		Player win = getWinner(winner);
		Player loos = getLooser(winner);

		if (win.getPoints() - loos.getPoints() >=1 && win.getPoints() >= 4 && win.getPoints()%2 == 0){
			win.setPoints(0);
			loos.setPoints(0);
			//call
		} else {
			win.setPoints(((win.getPoints()) + 1));
		}

		printScore();
	}

	public void printScore(){

		List<String>  points = new ArrayList<String>();
		points.add("0");
		points.add("15");
		points.add("30");
		points.add("40");
		points.add("");
		points.add("Advatage");

//		System.out.print("playerA: " + "  " + String.valueOf(p1.getPoints()>4?p1.getPoints()%2+4:p1.getPoints()));
//		System.out.println(" B: " + " " + String.valueOf(p2.getPoints()>4?p2.getPoints()%2+4:p2.getPoints()));

		System.out.println("player:    " + p1.getId() +"    " + p2.getId());
		System.out.println(String.format("sets:    %3d  %3d",p1.getSets(),p2.getSets()));
		System.out.println(String.format("games:   %3d  %3d",p1.getGames(),p2.getGames()));
		System.out.println(String.format("points:  %3d  %3d",points.get(p1.getPoints()>4?p1.getPoints()%2+4:p1.getPoints()),points.get(p2.getPoints()>4?p2.getPoints()%2+4:p2.getPoints())));

	}

	public static void main (String[] args){
		Tournament t = new Tournament('A', 'B');
		t.updatePoints('A');
		t.updatePoints('B');
		t.updatePoints('A');
		t.updatePoints('B');
		t.updatePoints('A');
		t.updatePoints('B');
		t.updatePoints('A');
		t.updatePoints('B');

		t.updatePoints('A');
		t.updatePoints('B');

		t.updatePoints('A');
		t.updatePoints('B');

		t.updatePoints('A');
		t.updatePoints('B');
//        t.updatePoints('A');



	}

}