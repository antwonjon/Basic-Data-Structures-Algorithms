/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package phonelist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author yaw
 */
public class PhoneList extends JFrame{
    PhonePanel p;
    //constructor
    public PhoneList() {
        super("Phone List");
        addWindowListener(new WindowAdapter());
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        p = new PhonePanel();
        getContentPane().add(p);
        pack();
        setLocationRelativeTo(null);    //put the gui in the center of the screen
        setVisible(true);
    }
    
    private class WindowAdapter implements WindowListener {

        @Override
        public void windowClosing(WindowEvent e) {
            p.save();
            System.exit(0);
        }

        @Override
        public void windowOpened(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
        }

        @Override
        public void windowClosed(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
        }

        @Override
        public void windowIconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
        }

        @Override
        public void windowActivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); 
        }
    }

    public static void main(String[] args) {
        PhoneList newGame = new PhoneList(); 
    }
}
