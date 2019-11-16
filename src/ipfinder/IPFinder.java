package ipfinder;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

/**
 *
 * @author Alpha
 */
public class IPFinder extends JFrame implements ActionListener{

    JTextField t;
    JButton b1,b2;
    JLabel l1;
    
    public IPFinder()
    {
        super("IP Finder");
		t = new JTextField(); 	
		t.setBounds(100,100,200,20);
        //t.setFont(new Font("Arial",Font.BOLD,16));
	
		b1 = new JButton("Search IP");
		b1.setBounds(100,200,100,30);
	
		b2 = new JButton("Exit");
		b2.setBounds(220,200,80,30);
	
		l1 = new JLabel("IP FINDER");
		l1.setBounds(120,40,300,20);
        l1.setFont(new Font("Courier New",Font.BOLD,28));
	
		b1.addActionListener(this);
		b2.addActionListener(this);
	
		add(t);
		add(b1); add(b2);
		add(l1);
	
		setSize(430,400);
		setLayout(null);
		setVisible(true);
        setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String str = e.getActionCommand();
	
	if(str.equals("Search IP"))
	{
           try{
                    String url = t.getText();
                    InetAddress inet = InetAddress.getByName(url);
                    String ip = inet.getHostAddress();
                    JOptionPane.showMessageDialog(this,ip);  
                }
                catch(UnknownHostException ex){
                    JOptionPane.showMessageDialog(this,"Enter A Valid URL !","Alert",JOptionPane.WARNING_MESSAGE);  
                }
        }
	else if(str.equals("Exit"))
		dispose();
	
	repaint();
    }
    
    public static void main(String[] args) {
        new IPFinder();   
    }
}
