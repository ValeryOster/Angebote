package de.angebot.main.gathering.penny;

import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;


class PennyOfferTest {

    @Test
    public void testPennyDoku() throws URISyntaxException {
        PennyOffer pennyOffer = new PennyOffer();
        pennyOffer.setMainUrl("https://www.penny.de");
        pennyOffer.setMontag("angebotszeitraum-ab-montag");
        pennyOffer.setDonnerstag("angebotszeitraum-ab-donnerstag");
        pennyOffer.setFreitag("angebotszeitraum-ab-freitag");
        pennyOffer.startGathering();

    }
}
