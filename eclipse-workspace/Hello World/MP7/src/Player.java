public class Player {

	private String representation = "^";
	private String name = "";
	public  Player(String a) {
		this.name = a;
	}
	public void setRep(String Rep) {
		this.representation = Rep;
	}
	public String getRep() {
		return representation;
	}
	public String getName() {
		return name;
	}
}