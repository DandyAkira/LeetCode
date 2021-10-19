import java.util.*;

interface HtmlParser {
    // 返回给定 url 对应的页面中的全部 url 。
    List<String> getUrls(String url);
}

class WebCrawler {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Queue<String> bfsQ = new ArrayDeque<>();
        Set<String> urlVisited = new HashSet<String>();
        urlVisited.add(startUrl);
        bfsQ.add(startUrl);
        while (!bfsQ.isEmpty()) {
            String currentUrl = bfsQ.poll();
            List<String> nextUrls = htmlParser.getUrls(currentUrl);
            for (String nextUrl : nextUrls) {
                if (!urlVisited.contains(nextUrl) && getHostName(nextUrl).equals(getHostName(currentUrl))) {
                    urlVisited.add(nextUrl);
                    bfsQ.add(nextUrl);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        String startHostName = getHostName(startUrl);
        for (String url : urlVisited) {
            if (startHostName.equals(getHostName(url))) {
                ans.add(url);
            }
        }

        return ans;
    }
    private String getHostName(String url) {
        url = url.substring(7);
        String[] urlhostname = url.split("/");
        return urlhostname[0];
    }
}
