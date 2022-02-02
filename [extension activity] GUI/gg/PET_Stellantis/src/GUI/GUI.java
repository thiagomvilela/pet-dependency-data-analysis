package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.Normalizer.Form;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	public GUI() throws IOException {
		super("Dependency Finder");
		guiMain();
	}
	Color azul = new Color(37,51,125);
	int select = 0;
	String localDir = System.getProperty("user.dir");
	BufferedImage logo = ImageIO.read(new File(localDir + "/resources/Logo-Stellantis.png"));
	int resizer = 2;
	Image logoR = logo.getScaledInstance(logo.getWidth()/resizer, logo.getHeight()/resizer, Image.SCALE_DEFAULT);	

	Border margin = new EmptyBorder(20,10,20,10);

	int fontSize = 14;

	Font f = new Font("Arial", Font.BOLD, fontSize);
	
	public JButton newBtn(String name){
		JButton btn;
		Color azul = new Color(37,51,125);
		btn = new JButton(name);	
		btn.setBackground(azul);
		btn.setForeground(Color.WHITE);
		btn.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 3));
		btn.setSize(getPreferredSize());
		btn.setPreferredSize(new Dimension(200, 30));
		btn.setFocusable(false);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setFont(f);
		
		return btn;
	}
	
	public JLabel getLogo() {
		JLabel logo = new JLabel(new ImageIcon(logoR));
		Border border = logo.getBorder();
		Border marginL = new EmptyBorder(10,10,10,10);
		logo.setBorder(new CompoundBorder(border, marginL));
		return logo;
	}
	
	public JPanel getBigPanel(int rows) {
		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new GridLayout(rows,1));
		bigPanel.setBackground(azul);
		
		Border borderP = bigPanel.getBorder();
		Border marginP = new EmptyBorder(20,10,30,10);
		bigPanel.setBorder(new CompoundBorder(borderP, marginP));
		
		return bigPanel;
	}
	
	public void varDirectory() throws IOException{
		setLayout(new BorderLayout());
		setTitle("Variable Directory");
		
		JPanel panel = new JPanel();
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		panel.setBackground(azul);		
		Border borderPanel = panel.getBorder();
		panel.setBorder(new CompoundBorder(borderPanel, margin));
		
		JLabel var = new JLabel("Enter Variable Name");
		var.setForeground(Color.white);
		var.setFont(f);
		JTextField varField = new JTextField(30);
		varField.setFont(f);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		panelBotoes.setBackground(azul);
		
		Border borderBtns = panelBotoes.getBorder();
		panelBotoes.setBorder(new CompoundBorder(borderBtns, margin));
		
		JButton botaoVoltar = newBtn("Back to Menu");
		
		panelBotoes.add(botaoVoltar);
		
		JButton botaoBuscar = newBtn("Find Variable Address");
		
		panelBotoes.add(botaoBuscar);
		
		
		JLabel logolabel = getLogo();	
		
		JPanel bigPanel = getBigPanel(3);
		panel.add(var);
		panel.add(varField);
		logoPanel.add(logolabel);
		
		add(bigPanel, BorderLayout.CENTER);
		
		bigPanel.add(logoPanel, BorderLayout.NORTH);
		bigPanel.add(panel,BorderLayout.CENTER);
		bigPanel.add(panelBotoes, BorderLayout.SOUTH);
		
		botaoVoltar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					remove(bigPanel);
					guiMain();
					invalidate();
					validate();
					repaint();
					
				} catch (IOException e1) {
					System.out.println("F no chat");
					e1.printStackTrace();
				}
		    }
		
		});
		
	}
	
	
	private void depFinderInput() throws IOException {
		setLayout(new BorderLayout());
		setTitle("DepFinder");
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		
		JPanel panelInput = new JPanel();
		panelInput.setLayout(new FlowLayout());
		panelInput.setBackground(azul);
		panelInput.setFont(f);
		
		JLabel var = new JLabel("Enter Variable Name");
		var.setForeground(Color.white);
		var.setFont(f);
		JTextField varField = new JTextField(30);
		varField.setFont(f);
		
		JLabel diretorio = new JLabel("Enter Variable Folder");
		diretorio.setFont(f);
		diretorio.setForeground(Color.white);

		JTextField dirField = new JTextField(30);
		dirField.setFont(f);
		JLabel logolabel = getLogo();
		
		panelInput.add(var);
		panelInput.add(varField);
		panelInput.add(diretorio);
		panelInput.add(dirField);
		logoPanel.add(logolabel);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		panelBotoes.setBackground(azul);
		
		Border borderBtns = panelBotoes.getBorder();
		panelBotoes.setBorder(new CompoundBorder(borderBtns, margin));
		
		JButton botaoVoltar = newBtn("Back to Menu");
		
		panelBotoes.add(botaoVoltar);
		
		JButton botaoBuscar = newBtn("Generate Report");
		
		panelBotoes.add(botaoBuscar);
		
		JPanel bigPanel = getBigPanel(3);
		
		add(bigPanel, BorderLayout.CENTER);
		
		bigPanel.add(logoPanel, BorderLayout.NORTH);
		bigPanel.add(panelInput, BorderLayout.CENTER);
		bigPanel.add(panelBotoes, BorderLayout.SOUTH);	
		
		botaoVoltar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					remove(bigPanel);
					guiMain();
					invalidate();
					validate();
					repaint();
					
				} catch (IOException e1) {
					System.out.println("F no chat");
					e1.printStackTrace();
				}
		    }
		
		});
		
	}
	
	public void guiMain() throws IOException{
		setTitle("Dependency Finder");
		
		setLayout(new BorderLayout());
		JPanel panelBotoes = new JPanel();
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(azul);
		panelBotoes.setBackground(azul);
		JButton botaoVarDir = newBtn("Variable Directory");
		JButton botaoDepFinder = newBtn("DepFinder");
		
		JLabel logolabel = getLogo();	
		logoPanel.add(logolabel);
		
		panelBotoes.add(botaoDepFinder);
		panelBotoes.add(botaoVarDir);
		
		JPanel bigPanel = getBigPanel(2);
		
		add(bigPanel, BorderLayout.CENTER);
		
		
		bigPanel.add(logoPanel, BorderLayout.NORTH);
		bigPanel.add(panelBotoes, BorderLayout.CENTER);
		
		botaoVarDir.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	try {
					remove(bigPanel);
					varDirectory();
					invalidate();
					validate();
					repaint();
					
				} catch (IOException e1) {
					System.out.println("F no chat");
					e1.printStackTrace();
				}
		    }
		
		});
		botaoDepFinder.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        try {
					remove(bigPanel);
					depFinderInput();
					invalidate();
					validate();
					repaint();
					
				} catch (IOException e1) {
					System.out.println("F no chat");
					e1.printStackTrace();
				}
		    }
		
		});
		
		
	}
}
