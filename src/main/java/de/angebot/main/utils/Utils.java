package de.angebot.main.utils;

import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static void saveHtmlToDisk(Document document) {
        final File f = new File("c:\\Users\\Valera\\Desktop\\Dokument.html");
        try {
            FileUtils.writeStringToFile(f, document.outerHtml(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
