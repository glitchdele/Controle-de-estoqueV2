package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Conest-Sistema de Estoque");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/icones/pc.png")));
		addWindowListener(new WindowAdapter() {
			//@Override
			public void windowActivated(WindowEvent e) {
				// evento que é "disparado" quando a janela do jframe é ativada
				status();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 514, 784, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblDataLabel = new JLabel("");
		lblDataLabel.setForeground(SystemColor.textHighlightText);
		lblDataLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataLabel.setBounds(501, 11, 400, 25);
		panel.add(lblDataLabel);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/dbof.png")));
		lblStatus.setBounds(53, 11, 32, 32);
		panel.add(lblStatus);
		
		JButton btnProduto = new JButton("");
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProduto produto = new TelaProduto();
				produto.setVisible(true);
			}
		});
		btnProduto.setToolTipText("Entrada");
		btnProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/entrada.png")));
		btnProduto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProduto.setBounds(71, 89, 128, 128);
		contentPane.add(btnProduto);
		
		JButton btnSaida = new JButton("");
		btnSaida.setToolTipText("Saida");
		btnSaida.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/saida.png")));
		btnSaida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSaida.setBounds(584, 89, 128, 128);
		contentPane.add(btnSaida);
		
		JButton btnConsulta = new JButton("");
		btnConsulta.setToolTipText("Consulta");
		btnConsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/consulta.png")));
		btnConsulta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsulta.setBounds(334, 89, 128, 128);
		contentPane.add(btnConsulta);
		
		JButton btnFornecedor = new JButton("");
		btnFornecedor.setToolTipText("Fornecedor");
		btnFornecedor.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/fornecedor.png")));
		btnFornecedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedor.setBounds(71, 288, 128, 128);
		contentPane.add(btnFornecedor);
		
		JButton btnRelatorio = new JButton("");
		btnRelatorio.setToolTipText("Relatorio");
		btnRelatorio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/report.png")));
		btnRelatorio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorio.setBounds(334, 288, 128, 128);
		contentPane.add(btnRelatorio);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evento clicar no botão sobre
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/about.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBounds(584, 288, 128, 128);
		contentPane.add(btnSobre);
	} // fim do construtor

// instanciar criar um objeto para acessar a classe DAO
	DAO dao = new DAO();
	private JLabel lblDataLabel;
	private JLabel lblStatus;

	/**
	 * Status da conexão
	 */
	private void status() {
		try {
			// estabelecer uma conexão
			Connection con = dao.conectar();
			//status
			// System.out.println(con);
			// trocando o ícone do banco(status da conexão)
			if (con != null) {
				
				
				lblStatus.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/dbon.png")));
				
			
			} else {
				
				lblStatus.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/dbof.png")));
			}
			// encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		// modificar a label do rodape para a data atual
		Date datalabel = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblDataLabel.setText(formatador.format(datalabel));
	}
}