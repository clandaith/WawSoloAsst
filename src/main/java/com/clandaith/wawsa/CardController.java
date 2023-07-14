package com.clandaith.wawsa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

	@Autowired
	CardService cardService;

	@CrossOrigin
	@GetMapping("/api/card")
	public Card card(@RequestParam(value = "saType", defaultValue = "") String saType) {
		return cardService.getCard(saType);
	}
}
