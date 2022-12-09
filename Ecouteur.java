package listener;
import nav.*;
import java.awt.event.*;
import javax.swing.*;
import traitement.*;
import socket.*;

public class Ecouteur implements MouseListener {

    Navigateur navigateur;

    public Navigateur getNavigateur() {
        return this.navigateur;
    }

    public Ecouteur() {}
    public Ecouteur(Navigateur navigateur) {
        this.navigateur = navigateur;
    }

    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String url = this.navigateur.getSearchBar().getText();
        String method = this.navigateur.getMenuMethod().getItemAt(this.navigateur.getMenuMethod().getSelectedIndex());
        if(button.getText().equals("Send")) {
            try {
                TraitementURL traitementURL = new TraitementURL(url);
                ClientSocket clientSocket = new ClientSocket(traitementURL, method);
                ResponseFrame responseFrame = new ResponseFrame(url, clientSocket.getLines(), clientSocket.getHeaders(), traitementURL.getHost(), traitementURL.getAddress());
                responseFrame.setVisible(true);
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
}