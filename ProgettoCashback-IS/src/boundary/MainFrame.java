package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_Bottone1 = new JButton("Richiedi Rimborso");
		btn_Bottone1.setFont(new Font("Galvji", Font.PLAIN, 13));
		btn_Bottone1.setBackground(new Color(0, 102, 0));
		
		FormInserimento f = new FormInserimento();
		
		btn_Bottone1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		f.setVisible(true);
			}
		});
		btn_Bottone1.setForeground(new Color(0, 0, 0));
		btn_Bottone1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_Bottone1.setBounds(123, 119, 190, 43);
		contentPane.add(btn_Bottone1);
		
		JLabel lblNewLabel = new JLabel("Cashback");
		lblNewLabel.setBounds(16, 6, 61, 16);
		contentPane.add(lblNewLabel);
	}
}
