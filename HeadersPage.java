package nav;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;

public class HeadersPage extends JFrame {

    // JScrollPane scrollPane;
    // JPanel [] panels;
    // JLabel [] titles;
    // JPanel jPanel1;

    // public HeadersPage(Vector<String> headers) {
    //     this.initComponents(headers);
    //     this.setLocationRelativeTo(null);
    //     this.setTitle("Headers");
    //     this.setResizable(false);
    // }

    // public void initComponents(Vector<String> headers) {

    //     String [] head = new String[headers.size()];

    //     scrollPane = new JScrollPane();
    //     panels = new JPanel[headers.size()];
    //     titles = new JLabel[headers.size()];

    //     jPanel1 = new JPanel();
    //     jPanel1.setLayout(new GridLayout(headers.size(), 1));

    //     for(int i = 0; i < headers.size(); i++) {
    //         panels[i] = new JPanel();
    //         titles[i] = new JLabel();
    //         if(headers.get(i)!= null) {
    //             head[i] = headers.get(i);
    //             panels[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
    //             titles[i].setFont(new java.awt.Font("Trebuchet MS", 0, 14));
    //             titles[i].setText("H : " + head[i]);

    //             GroupLayout jPanel2Layout = new GroupLayout(panels[i]);
    //             panels[i].setLayout(jPanel2Layout);
    //             jPanel2Layout.setHorizontalGroup(
    //             jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    //             .addGroup(jPanel2Layout.createSequentialGroup()
    //                 .addContainerGap()
    //                     .addComponent(titles[i])
    //                         .addContainerGap(607, Short.MAX_VALUE))
    //             );
    //             jPanel2Layout.setVerticalGroup(
    //             jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    //             .addGroup(jPanel2Layout.createSequentialGroup()
    //                 .addContainerGap()
    //                     .addComponent(titles[i])
    //                         .addContainerGap(12, Short.MAX_VALUE))
    //             );
    //             jPanel1.add(panels[i]);
    //         } else if(headers.get(i) == null || headers.get(i) == "") {
    //             head[i] = headers.get(i);
    //             panels[i].setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

    //             titles[i].setFont(new java.awt.Font("Trebuchet MS", 0, 14));
    //             titles[i].setText(". . .");

    //             GroupLayout jPanel2Layout = new GroupLayout(panels[i]);
    //             panels[i].setLayout(jPanel2Layout);
    //             jPanel2Layout.setHorizontalGroup(
    //             jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    //             .addGroup(jPanel2Layout.createSequentialGroup()
    //                 .addContainerGap()
    //                     .addComponent(titles[i])
    //                         .addContainerGap(607, Short.MAX_VALUE))
    //             );
    //             jPanel2Layout.setVerticalGroup(
    //             jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    //             .addGroup(jPanel2Layout.createSequentialGroup()
    //                 .addContainerGap()
    //                     .addComponent(titles[i])
    //                         .addContainerGap(12, Short.MAX_VALUE))
    //             );
    //             jPanel1.add(panels[i]);
    //         }
    //     }
    //     scrollPane.setViewportView(jPanel1);

    //     GroupLayout layout = new GroupLayout(getContentPane());
    //     getContentPane().setLayout(layout);
    //     layout.setHorizontalGroup(
    //         layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    //         .addComponent(scrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
    //     );
    //     layout.setVerticalGroup(
    //         layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    //         .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
    //     );

    //     pack();
    // }
}
