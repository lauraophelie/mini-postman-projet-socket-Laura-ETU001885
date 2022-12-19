package socket;
import traitement.*;
import java.io.*;
import java.net.*;
import java.util.*;
import nav.*;

public class ClientSocket {
    
    Vector<String> body;

    public Vector<String> getBody() {
        return this.body;
    }
    public void setBody(Vector<String> body) {
        this.body = body;
    }

    String status;

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    Vector<String> headers;

    public Vector<String> getHeaders() {
        return this.headers;
    }
    public void setHeaders(Vector<String> headers, LinkURL linkURL, int n) {
        if(headers == null) {
            headers = new Vector<String>();
        }

        for(int i = 1; i < n; i++) {
            headers.add(linkURL.getConnection().getHeaderFieldKey(i) + ": " + linkURL.getConnection().getHeaderField(i));
            System.out.println(linkURL.getConnection().getHeaderFieldKey(i) + ": " + linkURL.getConnection().getHeaderField(i));
        }
        
        this.setStatus(linkURL.getConnection().getHeaderField(0));
        this.headers = headers;
    }

    Socket socket;

    public Socket getSocket() {
        return this.socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    BufferedReader reader;

    public BufferedReader getReader() {
        return this.reader;
    }
    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    PrintStream printer;

    public PrintStream getPrinter() {
        return this.printer;
    }
    public void setPrinter(PrintStream printer) {
        this.printer = printer;
    }

    public void initSocket(LinkURL linkURL, String method) throws Exception {
        try {
            this.socket = new Socket(linkURL.getAddress(), linkURL.getPort());

            try {
                this.printer = new PrintStream(this.socket.getOutputStream());

                String firstLine = linkURL.setRequest(method, linkURL.getUri(), null);
                Vector<String> headers = new Vector<String>();

                this.setHeaders(headers, linkURL, 7);

                printer.println(firstLine);
                printer.println("Host: " + linkURL.getHost());
                printer.println("cache-control: no-cache");
                printer.println();
                printer.flush();

                this.socket.shutdownOutput();
                this.reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

                Vector<String> body = new Vector<String>();
                for(String responses : this.reader.lines().toList()) {
                    body.add(responses);
                    System.out.println(responses + "\n");
                }

                this.setBody(body);
                this.socket.close();
            } catch(IOException ie) {
                throw new Exception(ie.getMessage());
            }
        } catch (UnknownHostException un) {
            throw new Exception(un.getMessage());
        }
    }

    public ClientSocket() {}
    public ClientSocket(LinkURL linkURL, String method) throws Exception {
        this.initSocket(linkURL, method);
    }

    public static void main(String [] args) {
        try {
            Navigateur navigateur = new Navigateur();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}