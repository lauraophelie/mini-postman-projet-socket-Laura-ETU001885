package nav;
import javax.swing.*;
import java.awt.*;
import listener.*;

public class Navigateur extends JFrame {

    JButton search;


    JComboBox<String> menuMethod;

    public JComboBox<String> getMenuMethod() {
        return this.menuMethod;
    }
    public void setMenuMethod(JComboBox<String> menuMethod) {
        this.menuMethod = menuMethod;
    }

    JTextField searchBar;

    public JTextField getSearchBar() {
        return this.searchBar;
    }
    public void setSearchBar(JTextField searchBar) {
        this.searchBar = searchBar;
    }

    public Navigateur() {
        initComponents();
        this.setTitle("Navigateur");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
    }

    public void initComponents() {

        String [] methodOptions = {"GET", "POST", "PUT"};

        menuMethod = new JComboBox<>();
        searchBar = new JTextField();
        search = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Navigateur ");
        setBackground(new Color(113, 147, 200));

        menuMethod.setFont(new Font("Trebuchet MS", 0, 14)); // NOI18N
        menuMethod.setModel(new DefaultComboBoxModel<>(methodOptions));
        menuMethod.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        searchBar.setFont(new Font("Trebuchet MS", 0, 14)); // NOI18N
        searchBar.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));

        search.setBackground(new Color(116, 193, 131));
        search.setFont(new Font("Trebuchet MS", 0, 14)); // NOI18N
        search.setText("Send");
        search.addMouseListener(new Ecouteur(this));
        search.setBorder(null);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(search, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(menuMethod, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(searchBar, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuMethod, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(searchBar))
                .addGap(26, 26, 26)
                .addComponent(search, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }
}
