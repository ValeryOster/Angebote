package de.angebot.main.gathering.penny;

import de.angebot.main.enities.Penny;
import de.angebot.main.gathering.common.Gathering;
import lombok.extern.java.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log
public class PennyOffer implements Gathering {
    private String mainUrl = "https://www.penny.de";

    @Override
    public void startGathering() {
        Document document = getDocument(mainUrl + "/angebote");
        if (document != null) {
            List<String> angebotLinks = getOffersLinks(document);
            List<Penny> pennyList = new ArrayList<>();

            angebotLinks.forEach(angebot -> {
                Penny penny = new Penny();
                Document offer = getDocument(mainUrl + angebot);
                String offerName = offer.select("h1.detail-block__hdln")
                        .first()
                        .html()
                        .replace("*", "");
                String price = offer.select("div.bubble__wrap-inner>span").text();
                System.out.println(offerName + " -- " +price);
                if (price.contains("*")) {
                    System.out.println(offer.select("div.bubble__wrap-inner"));
                }
            });
        } else {
        }
    }

    private List<String> getOffersLinks(Document document) {
        return document.getElementsByClass("tile__link--cover ellipsis")
                .stream()
                .map(element -> element.attr("href"))
                .filter(s -> s.contains("/angebote/"))
                .collect(Collectors.toList());
    }

    private Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url)
                    .get();

            //Utils.saveHtmlToDisk(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}

