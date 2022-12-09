package traitement;
import java.net.*;
import javax.net.ssl.*;

public class TraitementURL {

    URL url;

    public URL getUrl() {
        return this.url;
    }
    public void setUrl(URL url) {
        this.setUrl(url);
    }

    String urlLink;

    public String getUrlLink() {
        return this.urlLink;
    }
    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    String method;

    public String getMethod() {
        return this.method;
    }
    public void setMethod(String method) {
        this.method = method;
    }

    int port;

    public int getPort() {
        return this.port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    String address;

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    String host;

    public String getHost() {
        return this.host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    String uriLink;

    public String getUriLink() {
        return this.uriLink;
    }
    public void setUriLink(String uriLink) {
        this.uriLink = uriLink;
    }

    int protocolPort;

    public int getProtocolPort() {
        return this.protocolPort;
    }
    public void setProtocolPort(int protocolPort) {
        this.protocolPort = protocolPort;
    }

    URLConnection connection;

    public URLConnection getConnection() {
        return this.connection;
    }
    public void setConnection(URLConnection connection) {
        this.connection = connection;
    }

    String link;

    public String getLink() {
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public void initProperties(String urlLink) throws Exception {
        try {
            this.url = new URL(urlLink);
            this.setUrlLink(urlLink);
            try {
                String host = this.url.getHost();
                InetAddress inetAddress = InetAddress.getByName(host);
                String addr = inetAddress.getHostAddress();
                String path = this.url.getPath();
                String link = host + ":" + String.valueOf(port);


                System.out.println(host);
                System.out.println(port);
                System.out.println(addr);
                System.out.println(path);
                System.out.println(inetAddress);

                if(this.url.getHost().equals("localhost")) {
                    if(this.url.getPort() != -1) {
                        HttpURLConnection connect = (HttpURLConnection) this.url.openConnection();
                        this.setConnection(connect);
                        this.setProtocolPort(80);
                        this.setPort(this.url.getPort());
                    } else {
                        HttpURLConnection connect = (HttpURLConnection) this.url.openConnection();
                        this.setConnection(connect);
                        this.setProtocolPort(80);
                        this.setPort(80);
                    }
                } else {
                    if(this.url.getProtocol().equals("http")) {
                        HttpURLConnection connect = (HttpURLConnection) this.url.openConnection();
                        this.setConnection(connect);
                        this.setProtocolPort(80);
                        this.setPort(80);
                    } 
                    if(this.url.getProtocol().equals("https")) {
                        HttpsURLConnection connect = (HttpsURLConnection) this.url.openConnection();
                        this.setConnection(connect);
                        this.setProtocolPort(80);
                        this.setPort(80);
                    }
                }
                this.setLink(link);
                this.setHost(host);
                this.setPort(port);
                this.setAddress(addr);
                this.setUriLink(path);
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        } catch(Exception e) {
            throw new Exception("Invalid URL, please try again");
        }
    }

    public TraitementURL() {}
    public TraitementURL(String urlLink) throws Exception {
        this.initProperties(urlLink);
    }

    public static String getRequest(String method, String uriLink, String httpVersion) {
        String request = "";
        if(method == "POST") {
            request += method +" "+uriLink+" "+httpVersion;
        }
        if(method == "GET") {
            request += method +" "+uriLink+" "+httpVersion;
        }
        if(method == "PUT") {
            request += method +" "+uriLink+" "+httpVersion;
        }
        System.out.println(request);
        return request;
    }
}