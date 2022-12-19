package listener;
import nav.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;


public class ResponseListener implements MouseListener {

    ResponseFrame responseFrame;

    public ResponseFrame getResponseFrame() {
        return this.responseFrame;
    }
    public void setResponseFrame(ResponseFrame responseFrame) {
        this.responseFrame = responseFrame;
    }

    public ResponseListener() {}
    public ResponseListener(ResponseFrame responseFrame) {
        this.setResponseFrame(responseFrame);
    }

    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String url = this.responseFrame.getUrl();
        if(button.getText().equals("Preview")) {
            PageWeb pageWeb = new PageWeb(this.responseFrame.getUrl());
            pageWeb.setVisible(true);
        } 
        if(button.getText().equals("Headers")) {
            HeadersPage headersPage = new HeadersPage(this.responseFrame.getHeaders());
            headersPage.setVisible(true);
        }
        if(button.getText().equals("Network")) {
            NetworkPage networkPage = new NetworkPage(this.responseFrame.getHost(), this.responseFrame.getAddress());
            networkPage.setVisible(true);
        }
    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
}
