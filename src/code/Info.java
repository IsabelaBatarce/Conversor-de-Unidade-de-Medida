package code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Classe responsavel pelas informações do projeto
 */
public final class Info {
    public static final String author = "Group A9";
    public static final String sysName = "Units of Measure Converter";
    public static final String copyRight = "Copyright \u00A9 2020. " + author + ". All rights reserved.";
    public static final String mission = "Units of Measure Converter using java";
    public static final String date = "November, 2020";
    public static final String version = "Ver. 1.0";

    private static final String ResFolder = "/resources/";
    private static final String HelpFile = "Document_Help.txt";
    private static final String DisclaimerFile = "Document_Disclaimer.txt";
    private static final String logoFile = "Unicamp_logo.jpg";
    private static Image logoImage = null;

    /**
     * @return String metodo responsavel por buscar as informações do arquivo
     *         referente a unidade selecionada
     */
    public static String getAboutText() {
        StringBuilder finalText = new StringBuilder();

        finalText.append("\n");
        finalText.append(sysName + "\n");
        finalText.append(version + " - ");
        finalText.append(date + "\n");
        finalText.append("\n");
        finalText.append(mission + "\n");
        finalText.append("\n");
        finalText.append(author + "\n");
        finalText.append("\n");
        finalText.append("\n");
        finalText.append(copyRight + "\n");

        return (finalText.toString());
    }

    /**
     * @return String Pegar o texto do Disclaimer
     */
    public static String getDisclaimerText() {
        return (getTextFromResourceFile(ResFolder + DisclaimerFile));
    }

    /**
     * @return String Pegar o arquivo do Help
     */
    public static String getHelpText() {
        return (getTextFromResourceFile(ResFolder + HelpFile));
    }

    /**
     * @return Image Pegar a Logo
     */
    public static Image getLogoImage() {
        if (logoImage == null) {
            try {
                final URL auxURL = Info.class.getResource(ResFolder + Info.logoFile);
                logoImage = ImageIO.read(auxURL);
            } catch (final IOException e) {
                System.out.println(Info.getLongVersion() + "\nLogo image not found. " + e.getMessage());
            } catch (Exception e) {
                System.out.println(Info.getLongVersion() + "\nError in loading logo image. " + e.getMessage());
            }
        }
        return (logoImage);
    }

    /**
     * @return String
     */
    public static String getLongVersion() {
        return (sysName + " - " + version + " - " + date);
    }

    /**
     * @return String
     */
    public static String getShortVersion() {
        return (version + " - " + date);
    }

    /**
     * @param fileName
     * @return String
     */
    private static String getTextFromResourceFile(String fileName) {
        StringBuilder finalText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Info.class.getResourceAsStream(fileName)))) {
            String buffer;

            while ((buffer = reader.readLine()) != null) {
                finalText.append(buffer + "\n");
            }
        } catch (NullPointerException e) {
            System.out.println(Info.getLongVersion() + "\nError in loading file " + fileName + "\n" + e.getMessage());
        } catch (IOException e) {
            System.out.println(Info.getLongVersion() + "\nError in loading file " + fileName + "\n" + e.getMessage());
        }

        return (finalText.toString());
    }
}
