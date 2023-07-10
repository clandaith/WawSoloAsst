package com.clandaith.wawsa;

public class Card {

	private final int id;

	private final int die1;
	private final int die2;

	private final String primary1;
	private final String primary2;
	private final String primary3;

	private final String secondary1;
	private final String secondary2;
	private final String secondary3;
	private final String secondary4;

	private final String type;

	private final int reshuffle;

	public Card(int id, int die1, int die2, String p1, String p2, String p3, String s1, String s2, String s3, String s4,
			String type, String reshuffle) {
		this.id = id;

		this.die1 = die1;
		this.die2 = die2;

		this.primary1 = p1;
		this.primary2 = p2;
		this.primary3 = p3;

		this.secondary1 = s1;
		this.secondary2 = s2;
		this.secondary3 = s3;
		this.secondary4 = s4;

		this.type = type;

		this.reshuffle = reshuffle.isEmpty() ? 0 : Integer.parseInt(reshuffle);
	}

	public int getId() {
		return id;
	}

	public int getDie1() {
		return die1;
	}

	public int getDie2() {
		return die2;
	}

	public String getPrimary1() {
		return primary1;
	}

	public String getPrimary2() {
		return primary2;
	}

	public String getPrimary3() {
		return primary3;
	}

	public String getSecondary1() {
		return secondary1;
	}

	public String getSecondary2() {
		return secondary2;
	}

	public String getSecondary3() {
		return secondary3;
	}

	public String getSecondary4() {
		return secondary4;
	}

	public String getType() {
		return type;
	}

	public int getReshuffle() {
		return reshuffle;
	}

}
