package nav;
import javax.swing.*;
import java.awt.*;
import javax.swing.text.*;

import listener.Ecouteur;
import listener.ResponseListener;

import java.util.*;

public class ResponseFrame extends JFrame {

    JButton jButton1;
    JButton jButton2;
    JButton jButton3;
    JButton jButton4;
    JLabel title;
    JPanel jPanel1;
    JScrollPane scrollPane;
    JSeparator separator;
    JTextPane textPane;

    String url;

    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    Vector<String> body;

    public Vector<String> getBody() {
        return this.body;
    }
    public void setBody(Vector<String> body) {
        this.body = body;
    }

    Vector<String> headers;

    public Vector<String> getHeaders() {
        return this.headers;
    }
    public void setHeaders(Vector<String> headers) {
        this.headers = headers;
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
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    String status;

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public ResponseFrame(String url, Vector<String> body, Vector<String> headers, String host, String address, String status) {
        try {
            this.initComponents(url, body, status);
            this.setLocationRelativeTo(null);
            this.setBody(body);
            this.setHeaders(headers);
            this.setTitle(url);
            this.setResizable(false);
            this.setUrl(url);
            this.setHost(host);
            this.setAddress(address);
            this.setStatus(status);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void initComponents(String url, Vector<String> body, String status) throws Exception {

        title = new JLabel();
        separator = new JSeparator();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jPanel1 = new JPanel();
        scrollPane = new JScrollPane();
        textPane = new JTextPane();

        this.setTitle(url);

        title.setFont(new Font("Trebuchet MS", 0, 14));
        title.setText(status);

        jButton1.setBackground(new Color(255, 204, 153));
        jButton1.setFont(new Font("Trebuchet MS", 0, 14));
        jButton1.setText("Save");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new ResponseListener(this));

        jButton2.setBackground(new Color(204, 204, 255));
        jButton2.setFont(new Font("Trebuchet MS", 0, 14));
        jButton2.setText("Preview");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new ResponseListener(this));

        jButton3.setBackground(new Color(204, 255, 204));
        jButton3.setFont(new Font("Trebuchet MS", 0, 14));
        jButton3.setText("Network");
        jButton3.setBorder(null);
        jButton3.addMouseListener(new ResponseListener(this));

        jButton4.setBackground(new Color(255, 204, 255));
        jButton4.setFont(new Font("Trebuchet MS", 0, 14));
        jButton4.setText("Headers");
        jButton4.setBorder(null);
        jButton4.addMouseListener(new ResponseListener(this));

        jPanel1.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        SimpleAttributeSet styleNormal = new SimpleAttributeSet();
		StyleConstants.setFontFamily(styleNormal, "Trebuchet MS");
        StyleConstants.setBold(styleNormal, true);

        StyledDocument doc = textPane.getStyledDocument();
        for(int i = 0; i < body.size(); i++) {
            doc.insertString(doc.getLength(), body.get(i), styleNormal);
        }

        scrollPane.setViewportView(textPane);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(separator, GroupLayout.PREFERRED_SIZE, 607, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(147, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jButton3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jButton4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jButton1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        pack();
    }
}
