import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }


    public static void main(String[] unused) {
        String str = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int count = 0;
        String[] strarray1 = str.split("\n");
        for (int i = 0; i < strarray1.length; i++) {
            for (int j = 0; j < strarray1[i].length(); j++) {
                if (strarray1[i].charAt(j) == ' ' || strarray1[i].charAt(j) == ',') {
                    count++;
                }
            }
        }
        System.out.println(count);
        String str2 = urlToString("https://www.bls.gov/tus/charts/chart9.txt");
        int count2 = 0;
        String[] strarray2 = str2.split("\n");
        for (int i = 0; i < strarray2.length; i++) {
            for (int j = 0; j < strarray2[i].length(); j++) {
                if (strarray2[i].charAt(j) == ' ' || strarray2[i].charAt(j) == ',') {
                    count2++;
                }
            }
        }
        System.out.println(count2);
        String str3 = urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt");
        int count3 = 0;
        String[] strarray3 = str3.split("\n");
        for (int i = 0; i < strarray3.length; i++) {
            for (int j = 0; j < strarray3[i].length(); j++) {
                if (strarray3[i].charAt(j) == ' ' || strarray3[i].charAt(j) == ',') {
                    count3++;
                }
            }
        }
        System.out.println(count3);
        // moving on to find a specific word count in an array
        String specific = "leisure";
        String[] wordcount = str.split(specific);
        System.out.println("number of times " + specific + " appeared in 1st website is " + wordcount.length);
        String[] wordcount2 = str2.split(specific);
        System.out.println("number of times " + specific + " appeared in 2nd website is " + wordcount2.length);
        String[] wordcount3 = str3.split(specific);
        System.out.println("number of times " + specific + " appeared in 3rd website is " + wordcount3.length);
    }
}