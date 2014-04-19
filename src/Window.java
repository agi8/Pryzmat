import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;


public class Window extends JFrame {

	JList listGlass;
	
	public Window() throws HeadlessException {
		/**MOJE OKIENKO*/
		//Tytul okienka
		super("Pryzmat");
		
		//Zamykanie okienka
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Rozmiar i pozycja okienka
		setSize(900,650);
		setLocation(100, 100);
		
		//Blokowanie rozmiaru okienka
		setResizable(false);
		
		//Layout okna
		setLayout(new BorderLayout());
		
		//Panele menu wykresy i pryzmat
		JPanel canvas = new JPanel();
		canvas.setBackground(Color.WHITE);
	
		JPanel settings = new JPanel(new GridLayout(10, 1));
		settings.setBackground(Color.GRAY);
		
		JPanel diagrams = new JPanel();
		diagrams.setBackground(Color.BLACK);
		
		add (canvas, BorderLayout.CENTER);
		add (settings, BorderLayout.LINE_END);
		add (diagrams, BorderLayout.PAGE_END);
		
		//Wybor szkla
		settings.add(new JLabel("Wybierz szk³o: "));
		DefaultListModel modelGlass = new DefaultListModel();//Elementy listy
		modelGlass.addElement("FS");
		modelGlass.addElement("AMTIR-3");
		modelGlass.addElement("LaSF");
				
		listGlass = new JList(modelGlass);//Lista
		settings.add(listGlass);
		listGlass.setSelectedIndex(0);
				
		//Dlugosc fali
		settings.add(new JLabel("Wybierz d³ugoœæ fali: "));
				
	    JSlider waveLength =   new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
	    waveLength.setMajorTickSpacing(48);
	    waveLength.setMinorTickSpacing(16);
	    waveLength.setPaintTicks(true);
		settings.add(waveLength);
		
		//Kat lamiacy
		settings.add(new JLabel("Wybierz k¹t ³ami¹cy: "));
		
	    JSlider apexAngle =   new JSlider(JSlider.HORIZONTAL, 0, 90, 45);
	    apexAngle.setMajorTickSpacing(48);
	    apexAngle.setMinorTickSpacing(16);
	    apexAngle.setPaintTicks(true);
		settings.add(apexAngle);
	}

	

	public static void main(String[] args) {
		Window window = new Window();
		window.setVisible(true);

	}

}
