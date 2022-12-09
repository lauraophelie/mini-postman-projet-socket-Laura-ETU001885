package socket;
import java.net.*;
import java.io.*;
import traitement.*;
import nav.*;
import java.util.*;

public class ClientSocket {

    Socket socket;
    BufferedReader reader;
    PrintStream out;

    Vector<String> lines;

    public Vector<String> getLines() {
        return this.lines;
    }
    public void setLines(Vector<String> lines) {
        this.lines = lines;
    }

    Vector<String> headers;

    public Vector<String> getHeaders() {
        return this.headers;
    }
    public void setHeaders(Vector<String> headers) {
        this.headers = headers;
    }

    String status;

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public ClientSocket(TraitementURL traitementURL, String method) throws Exception {
        try {
            socket = new Socket(traitementURL.getAddress(), traitementURL.getPort());
            try {
                out = new PrintStream(socket.getOutputStream());

                String firstLine = TraitementURL.getRequest(method, traitementURL.getUriLink(), "HTTP/1.1");
                Vector<String> heads = new Vector<String>();

                System.out.println(traitementURL.getConnection().getHeaderField(0));
                this.setStatus(traitementURL.getConnection().getHeaderField(0));
                out.println(firstLine);
                out.println("User-Agent: Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
                out.println("Host: " + traitementURL.getHost());
                out.println("cache-control: no-cache");
                for(int i = 1; i < 8; i++) {
                    heads.add(traitementURL.getConnection().getHeaderFieldKey(i)+": "+ traitementURL.getConnection().getHeaderField(i));
                    System.out.println(traitementURL.getConnection().getHeaderFieldKey(i)+": "+traitementURL.getConnection().getHeaderField(i));
                }
                out.println();
                out.flush();

                socket.shutdownOutput();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                Vector<String> res = new Vector<String>();

                for(String responses : reader.lines().toList()) {
                    System.out.println(responses);
                    res.add(responses);
                }

                this.setHeaders(heads);
                this.setLines(res);

                socket.close();
            } catch(IOException ie) {
                System.out.println(ie.getMessage());
                ie.printStackTrace();
            }
        } catch(UnknownHostException ue) {
            System.out.println(ue.getMessage());
            ue.printStackTrace();
        }
    }
    public static void main(String [] args) {
        Navigateur navigateur = new Navigateur();
    }
}