package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class Principal {

	public static void main(String[] args) throws IOException {
		GUI gui = new GUI();
		Color azul = new Color(37,51,125);
//		Color azul = new Color(255,255,255); //White CIn UFPE
//		Color azul = new Color(219,30,47); RED CIn UFPE
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(500, 700);
		gui.setLocation((
				Toolkit.getDefaultToolkit().getScreenSize().width  - gui.getSize().width) / 2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height - gui.getSize().height) / 2
		);
		gui.setVisible(true);
		gui.setBackground(azul);
		
	}

}