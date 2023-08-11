package mx.conversor.archivos;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Temperatura extends JFrame {

	private JPanel contentPane;
	private JTextField txtTemp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatura frame = new Temperatura();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Temperatura() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 214, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(250, 214, 235));
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				inicio();
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Temperatura.class.getResource("/img/flecha (1).png")));
		btnNewButton.setBounds(10, 11, 40, 43);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Conversor de temperatura");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Elije las temperaturas a convertir ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 40, 414, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboTemperaturas = new JComboBox();
		comboTemperaturas.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		comboTemperaturas.setModel(new DefaultComboBoxModel(new String[] {"", "°C a °F", "°F a °C", "K a °C", "°C a K", "°F a K", "K a °F"}));
		comboTemperaturas.setBounds(172, 65, 84, 22);
		contentPane.add(comboTemperaturas);
		
		JLabel lblNewLabel_2 = new JLabel("Ingresa la temperatura");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 110, 414, 14);
		contentPane.add(lblNewLabel_2);
		
		txtTemp = new JTextField();
		txtTemp.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		txtTemp.setBounds(170, 135, 86, 20);
		contentPane.add(txtTemp);
		txtTemp.setColumns(10);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(10, 214, 414, 14);
		contentPane.add(lblResultado);
		
		JButton btnNewButton_1 = new JButton("Convertir");
		btnNewButton_1.setBackground(new Color(164, 92, 185));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double resultado =0; 
				double tempe = Double.parseDouble(txtTemp.getText());
				String sResul;
				String op = comboTemperaturas.getSelectedItem().toString();
				switch(op) {
				case "°C a °F": resultado=tempe * 1.8 +32;
				break;
				case "°F a °C": resultado = (tempe-32)*5/9;
				break;
				case "K a °C": resultado = tempe -273.15;
				break; 
				case "°C a K": resultado = tempe +273.15;
				break;
				case "°F a K": resultado = (tempe-32)*5/9+273.15;
				break;
				case "K a °F": resultado = 1.8*(tempe-273.15)+32;
				break;
				}
				
				 sResul = String.valueOf(resultado);
				lblResultado.setText(sResul);
				
			}
		});
		btnNewButton_1.setBorder(new RoundedBorder(20));
		btnNewButton_1.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		btnNewButton_1.setBounds(142, 166, 157, 23);
		contentPane.add(btnNewButton_1);
	}
	
	void inicio() {
		Inicio ini = new Inicio();
		ini.setVisible(true);
		ini.setLocationRelativeTo(null);
		this.setVisible(false);
	}
}
