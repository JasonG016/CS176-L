package fanGraphScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FanGraphScraper {
    public static void main(String[] args) {
        List<Map<String, String>> leaders2023 = scrapeData("https://www.fangraphs.com/leaders/major-league?pos=all&stats=bat&lg=all&qual=y&type=0&month=0&ind=0&startdate=&enddate=&season1=2021&season=2023");
        List<Map<String, String>> leaders2022 = scrapeData("https://www.fangraphs.com/leaders/major-league?pos=all&stats=bat&lg=all&qual=y&type=0&month=0&ind=0&startdate=&enddate=&season1=2021&season=2022");
        List<Map<String, String>> leaders2021 = scrapeData("https://www.fangraphs.com/leaders/major-league?pos=all&stats=bat&lg=all&qual=y&type=0&month=0&ind=0&startdate=&enddate=&season1=2020&season=2021");

        Map<String, Map<String, Integer>> playerRanks = new HashMap<>();

        for (List<Map<String, String>> leaders : List.of(leaders2023, leaders2022, leaders2021)) {
            for (int i = 0; i < leaders.size(); i++) {
                Map<String, String> player = leaders.get(i);
                String playerName = player.get("Player");

                playerRanks.putIfAbsent(playerName, new HashMap<>());
                playerRanks.get(playerName).put(player.get("Year"), i + 1);
            }
        }

        List<PlayerInfo> playerInfos = new ArrayList<>();

        for (String playerName : playerRanks.keySet()) {
            if (playerRanks.get(playerName).size() == 3) {
                int rank2023 = playerRanks.get(playerName).get("2023");
                int rank2022 = playerRanks.get(playerName).get("2022");
                int rank2021 = playerRanks.get(playerName).get("2021");

                double averageRank = (rank2023 + rank2022 + rank2021) / 3.0;

                playerInfos.add(new PlayerInfo(playerName, rank2023, rank2022, rank2021, averageRank));
            }
        }

        playerInfos.sort((p1, p2) -> Double.compare(p1.averageRank, p2.averageRank));

        System.out.println("3yr Rank\tPlayer\t2023 rank\t2022 rank\t2021 rank\tAverage rank");
        for (int i = 0; i < Math.min(playerInfos.size(), 20); i++) {
            PlayerInfo playerInfo = playerInfos.get(i);
            System.out.println((i + 1) + "\t" + playerInfo);
        }
    }

 // //Having trouble with this section scraping the info from Fangraph website. Tried all sorts of things

    private static List<Map<String, String>> scrapeData(String url) {
        List<Map<String, String>> leaders = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            Elements rows = doc.select("table#LeaderBoard1_dg1_ctl00 tbody tr");

            for (Element row : rows) {
                Elements columns = row.select("td");

               
                if (columns.size() >= 22) {
                    String playerName = columns.get(2).text(); 
                    String avg = columns.get(21).text();

                    Map<String, String> player = new HashMap<>();
                    player.put("Player", playerName);
                    player.put("Year", url.contains("2023") ? "2023" : (url.contains("2022") ? "2022" : "2021"));
                    player.put("AVG", avg);

                    leaders.add(player);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return leaders;
    }

    //


    private static class PlayerInfo {
        private final String name;
        private final int rank2023;
        private final int rank2022;
        private final int rank2021;
        private final double averageRank;

        public PlayerInfo(String name, int rank2023, int rank2022, int rank2021, double averageRank) {
            this.name = name;
            this.rank2023 = rank2023;
            this.rank2022 = rank2022;
            this.rank2021 = rank2021;
            this.averageRank = averageRank;
        }

        @Override
        public String toString() {
            return name + "\t" + rank2023 + "\t" + rank2022 + "\t" + rank2021 + "\t" + averageRank;
        }
    }
}
