package com.clandaith.wawsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CardServiceImpl.class);

	List<Card> allCards = new ArrayList<>();
	List<Card> availableCards = new ArrayList<>();
	List<Card> usedCards = new ArrayList<>();

	Random random = new Random(new Date().getTime());

	public CardServiceImpl() {
		LOGGER.info("Starting up....");

		parseFile();
	}

	private void parseFile() {
		try (Reader reader = new BufferedReader(
				new InputStreamReader(new ClassPathResource("cards.csv").getInputStream(), StandardCharsets.UTF_8))) {
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
			for (CSVRecord cardRecord : records) {
				Card card = new Card(cardRecord);
				allCards.add(card);
				availableCards.add(card);
			}

			LOGGER.info("Loaded allCards size: {}", allCards.size());
			LOGGER.info("Loaded availableCards size: {}", availableCards.size());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Card getCard(String saType) {
		return drawCard(saType);
	}

	private void reshuffleCards() {
		LOGGER.info("Reshuffling cards...");
		LOGGER.info("Old availableCards size: {}", availableCards.size());
		LOGGER.info("Old usedCards size: {}", usedCards.size());

		availableCards.clear();
		availableCards.addAll(allCards);
		usedCards.clear();

		LOGGER.info("New availableCards size: {}", availableCards.size());
		LOGGER.info("New usedCards size: {}", usedCards.size());
	}

	private Card drawCard(String saType) {
		LOGGER.info("++++++++++++++++++++++++++++++++++++++++");

		if (availableCards.isEmpty())
			reshuffleCards();

		int cardIndex = random.nextInt(availableCards.size());

		LOGGER.info("Card Index: {}", cardIndex);
		Card card = availableCards.get(cardIndex);

		usedCards.add(card);
		availableCards.remove(cardIndex);

		LOGGER.info("Current availableCards size: {}", availableCards.size());
		LOGGER.info("Current usedCards size: {}", usedCards.size());

		if (!saType.equals("") && !card.getType().equalsIgnoreCase("")) {
			LOGGER.info("Card type looking for: {} \t this card type is: {}", saType, card.getType());

			if (!card.getType().equalsIgnoreCase(saType)) {
				LOGGER.info("Drawing again...");
				card = drawCard(saType);
			}
		}

		return card;
	}
}
