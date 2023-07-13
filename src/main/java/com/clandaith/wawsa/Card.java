package com.clandaith.wawsa;

import org.apache.commons.csv.CSVRecord;

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

	public Card(CSVRecord cardRecord) {
		this.id = Integer.parseInt(cardRecord.get(0));

		this.die1 = Integer.parseInt(cardRecord.get(1));
		this.die2 = Integer.parseInt(cardRecord.get(2));

		this.primary1 = cardRecord.get(3);
		this.primary2 = cardRecord.get(4);
		this.primary3 = cardRecord.get(5);

		this.secondary1 = cardRecord.get(6);
		this.secondary2 = cardRecord.get(7);
		this.secondary3 = cardRecord.get(8);
		this.secondary4 = cardRecord.get(9);

		this.type = cardRecord.get(10);

		this.reshuffle = cardRecord.get(11).isEmpty() ? 0 : Integer.parseInt(cardRecord.get(11));
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
