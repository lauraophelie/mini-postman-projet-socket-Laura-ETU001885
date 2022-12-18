package nav;
import javax.swing.*;
import java.util.*;
import javax.swing.text.*;

import listener.ResponseListener;

public class ResponseFrame extends JFrame {

    JButton networkButton;
    JButton saveButton;
    JButton headersButton;
    JButton previewButton;
    JTextPane editorPane;
    JLabel statusLabel;
    JPanel panel;
    JScrollPane scrollPane;
    JSeparator separator;

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

    public void initComponents(String url, Vector<String> body, String status) throws Exception {

        statusLabel = new JLabel();
        separator = new JSeparator();
        panel = new JPanel();
        scrollPane = new JScrollPane();
        editorPane = new JTextPane();
        networkButton = new JButton();
        saveButton = new JButton();
        headersButton = new JButton();
        previewButton = new JButton();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle(url);
        this.setUrl(url);

        statusLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 16));
        statusLabel.setText("Status : " + status);

        panel.setBorder(BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        SimpleAttributeSet styleNormal = new SimpleAttributeSet();
		StyleConstants.setFontFamily(styleNormal, "Trebuchet MS");
        StyleConstants.setBold(styleNormal, true);

        StyledDocument doc = editorPane.getStyledDocument();
        for(int i = 0; i < body.size(); i++) {
            doc.insertString(doc.getLength(), body.get(i) + "\n", styleNormal);
        }

        editorPane.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        scrollPane.setViewportView(editorPane);

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        networkButton.setBackground(new java.awt.Color(102, 102, 255));
        networkButton.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        networkButton.setText("Network");
        networkButton.setBorder(null);
        networkButton.addMouseListener(new ResponseListener(this));

        saveButton.setBackground(new java.awt.Color(102, 255, 102));
        saveButton.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        saveButton.setText("Save");
        saveButton.setBorder(null);

        headersButton.setBackground(new java.awt.Color(102, 102, 255));
        headersButton.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        headersButton.setText("Headers");
        headersButton.setBorder(null);
        headersButton.addMouseListener(new ResponseListener(this));

        previewButton.setBackground(new java.awt.Color(102, 102, 255));
        previewButton.setFont(new java.awt.Font("Trebuchet MS", 0, 14));
        previewButton.setText("Preview");
        previewButton.setBorder(null);
        previewButton.addMouseListener(new ResponseListener(this));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusLabel, GroupLayout.PREFERRED_SIZE, 604, GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(separator, GroupLayout.PREFERRED_SIZE, 758, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(networkButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(42, 42, 42)
                                    .addComponent(previewButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(660, 660, 660)
                            .addComponent(headersButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(networkButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(headersButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(previewButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );

        pack();
    }

    public ResponseFrame() {}
    public ResponseFrame(String url, Vector<String> body, Vector<String> headers, String host, String address, String status) {
        try {
            this.setUrl(url);
            this.initComponents(url, body, status);
            this.setLocationRelativeTo(null);
            this.setAddress(address);
            this.setStatus(status);
            this.setBody(body);
            this.setHeaders(headers);
            this.setHost(host);
            this.setResizable(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
