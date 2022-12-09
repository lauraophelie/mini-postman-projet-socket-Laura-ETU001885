package nav;
import javax.swing.*;

public class PageWeb extends JFrame {

    JEditorPane editorPane;
    JScrollPane scrollPane;

    public PageWeb(String urlPage) {
        try {
            this.initComponents(urlPage);
            this.setLocationRelativeTo(null);
        } catch (Exception e) {
            throw new Exception("La page n'a pas pu se charger");
        }
    }
    public void initComponents(String urlPage) throws Exception {

        scrollPane = new JScrollPane();
        editorPane = new JEditorPane();

        editorPane.setPage(urlPage);
        scrollPane.setViewportView(editorPane);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
}
