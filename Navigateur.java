package nav;
import javax.swing.*;

import listener.Ecouteur;

import java.awt.*;

public class Navigateur extends JFrame {

    JButton sendButton;

    JComboBox<String> methodList;

    public JComboBox<String> getMethodList() {
        return this.methodList;
    }
    public void setMethodList(JComboBox<String> methodList) {
        this.methodList = methodList;
    }

    JLabel error;

    public JLabel getError() {
        return this.error;
    }
    public void setError(JLabel error) {
        this.error = error;
    }

    JPanel errorPanel;

    public JPanel getErrorPanel() {
        return this.errorPanel;
    }
    public void setErrorPanel(JPanel errorPanel) {
        this.errorPanel = errorPanel;
    }

    JTextField urlSearch;

    public JTextField getUrlSearch() {
        return this.urlSearch;
    }
    public void setUrlSearch(JTextField urlSearch) {
        this.urlSearch = urlSearch;
    }
    public void initComponents() {

        methodList = new JComboBox<>();
        urlSearch = new JTextField();
        sendButton = new JButton();
        errorPanel = new JPanel();
        error = new JLabel();

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Mini - Postman");

        methodList.setBackground(new Color(204, 204, 255));
        methodList.setFont(new Font("Trebuchet MS", 0, 14)); // NOI18N
        methodList.setModel(new DefaultComboBoxModel<>(new String[] { "GET", "POST", "PUT", "DELETE" }));

        urlSearch.setFont(new Font("Trebuchet MS", 0, 14)); // NOI18N
        urlSearch.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        sendButton.setBackground(new Color(0, 102, 255));
        sendButton.setFont(new Font("Trebuchet MS", 0, 14)); // NOI18N
        sendButton.setText("Send");
        sendButton.setBorder(null);
        sendButton.addMouseListener(new Ecouteur(this));

        errorPanel.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        error.setFont(new Font("Trebuchet MS", 0, 14)); // NOI18N

        GroupLayout errorPanelLayout = new GroupLayout(errorPanel);
        errorPanel.setLayout(errorPanelLayout);
        errorPanelLayout.setHorizontalGroup(
            errorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(errorPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(error, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        errorPanelLayout.setVerticalGroup(
            errorPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(errorPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(error, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(errorPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(methodList, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(urlSearch, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(methodList, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(urlSearch)
                    .addComponent(sendButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(errorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }

    public Navigateur() {
        this.initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }
}
