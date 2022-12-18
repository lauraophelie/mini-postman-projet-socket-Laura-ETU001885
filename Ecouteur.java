package listener;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

import traitement.*;
import nav.*;
import socket.*;

public class Ecouteur implements MouseListener {

    Navigateur navigateur;

    public Ecouteur() {}
    public Ecouteur(Navigateur navigateur) {
        this.navigateur = navigateur;
    }

    public void mouseClicked(MouseEvent e) {

        JButton button = (JButton) e.getSource();
        String url = this.navigateur.getUrlSearch().getText();
        String method = this.navigateur.getMethodList().getItemAt(this.navigateur.getMethodList().getSelectedIndex());

        if(button.getText() == "Send") {
            try {
                LinkURL linkURL = new LinkURL(url);
                try {
                    ClientSocket clientSocket = new ClientSocket(linkURL, method);
                    
                    Vector<String> body = clientSocket.getBody();
                    Vector<String> headers = clientSocket.getHeaders();
                    String host = linkURL.getHost();
                    String status = clientSocket.getStatus();
                    String address = linkURL.getAddress();

                    ResponseFrame responseFrame = new ResponseFrame(url, body, headers, host, address, status);
                    responseFrame.setVisible(true);

                } catch(Exception e2) {
                    this.navigateur.getError().setText(e2.getMessage());
                }
            } catch(Exception e1) {
                this.navigateur.getError().setText(e1.getMessage());
            }
        }
    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }

}
