package traitement;
import java.net.*;
import javax.net.ssl.*;

public class LinkURL {

    URL url;

    public URL getUrl() {
        return this.url;
    }
    public void setURL(URL url) {
        this.url = url;
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
        if(method == "" || method == null) {
            method = "GET";
        }
        this.method = method;
    }

    int port;

    public int getPort() {
        return this.port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    String host;

    public String getHost() {
        return this.host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    String address;

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    String uri;

    public String getUri() {
        return this.uri;
    }
    public void setUri(String uri) {
        this.uri = uri;
    }

    URLConnection connection;

    public URLConnection getConnection() {
        return this.connection;
    }
    public void setConnection(URLConnection connection) {
        this.connection = connection;
    }

    String error;

    public String getError() {
        return this.error;
    }
    public void setError(String error) {
        this.error = error;
    }

    public String setRequest(String method, String uri, String httpVersion) {
        if(httpVersion == "" || httpVersion == null) {
            httpVersion = "HTTP/1.1";
        }
        if(method == "" || method == null) {
            method = "GET";
        }

        String request = "";
        if(method == "GET") {
            request += method + " " + uri + " " + httpVersion;
        }
        if(method == "POST") {
            request += method + " " + uri + " " + httpVersion;
        }
        if(method == "PUT") {
            request += method + " " + uri + " " + httpVersion;
        }
        System.out.println("Request : " + request);
        this.setMethod(method);
        return request;
    }
    public void initProperties(String urlLink) throws Exception {
        if(urlLink == null || urlLink == "") {
            throw new Exception("The field cannot be empty, please enter an URL");
        } else {
            try {
                this.url = new URL(urlLink);
                this.setUrlLink(urlLink);
                try {
                    String host = this.url.getHost();
                    InetAddress inetAddress = Inet4Address.getByName(host);
                    String address = inetAddress.getHostAddress();
                    String uri = this.url.getPath();
    
                    if(this.url.getHost().equals("localhost")) {
    
                        HttpURLConnection connect = (HttpURLConnection) this.url.openConnection();
    
                        if(this.url.getPort() != -1) {
                            this.setPort(this.url.getPort());
                        } else {
                            this.setPort(80);
                        }
    
                        this.setConnection(connect);
                    } else {
                        if(this.url.getPort() == -1) {
                            if(this.url.getProtocol().equals("http")) {
                                HttpURLConnection connect = (HttpURLConnection) this.url.openConnection();
                                this.setConnection(connect);
                                this.setPort(80);
                            } else if(this.url.getProtocol().equals("https")) {
                                HttpsURLConnection connect = (HttpsURLConnection) this.url.openConnection();
                                this.setConnection(connect);
                                this.setPort(80);
                            }
                        } else if(this.url.getPort() != -1) {
                            if(this.url.getProtocol().equals("http")) {
                                HttpURLConnection connect = (HttpURLConnection) this.url.openConnection();
                                this.setConnection(connect);
                                this.setPort(this.url.getPort());
                            } else if(this.url.getProtocol().equals("https")) {
                                HttpsURLConnection connect = (HttpsURLConnection) this.url.openConnection();
                                this.setConnection(connect);
                                this.setPort(this.url.getPort());
                            }
                        }
                    }
    
                    this.setHost(host);
                    this.setAddress(address);
                    this.setUri(uri);
    
                } catch (Exception e1) {
                    throw new Exception(e1.getMessage());
                }
            } catch (Exception e) {
                throw new Exception("Invalid URL, please try again and type a valid url");
            }
        }
    }

    public void displayProperties() {
        System.out.println("URL : " + this.getUrlLink());
        System.out.println("URI : " + this.getUri());
        System.out.println("IP : " + this.getAddress());
        System.out.println("Host : " + this.getHost());
        System.out.println("Port : " + this.getPort());
    }

    public LinkURL() {}
    public LinkURL(String urlLink) throws Exception {
        this.initProperties(urlLink);
        this.displayProperties();
    }

}