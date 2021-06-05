package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblDataLabel;

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
		setTitle("Conest-sistema de estoque");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/Icones/pc.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnProduto = new JButton("");
		btnProduto.setToolTipText("entrada");
		btnProduto.addActionListener(new ActionListener() {
			//Botão produtos
			public void actionPerformed(ActionEvent e) {
				TelaProduto produto = new TelaProduto();
				produto.setVisible(true);
			}
		});
		btnProduto.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icones/entrada.png")));
		btnProduto.setBounds(93, 57, 128, 128);
		contentPane.add(btnProduto);

		JButton btnConsulta = new JButton("");
		btnConsulta.setToolTipText("consulta");
		btnConsulta.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icones/consulta.png")));
		btnConsulta.setBounds(307, 57, 128, 128);
		contentPane.add(btnConsulta);

		JButton btnSaida = new JButton("");
		btnSaida.setToolTipText("saida");
		btnSaida.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icones/saida.png")));
		btnSaida.setBounds(513, 57, 128, 128);
		contentPane.add(btnSaida);

		JButton btnFornecedores = new JButton("");
		btnFornecedores.setToolTipText("fornecedores");
		btnFornecedores.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icones/fornecedor.png")));
		btnFornecedores.setBounds(93, 275, 128, 128);
		contentPane.add(btnFornecedores);

		JButton btnRelatorio = new JButton("");
		btnRelatorio.setToolTipText("relatorios");
		btnRelatorio.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icones/report.png")));
		btnRelatorio.setBounds(307, 275, 128, 128);
		contentPane.add(btnRelatorio);

		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Evento clicar no botão sobre
				TelaSobre sobre = new TelaSobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/Icones/about.png")));
		btnSobre.setBounds(513, 275, 128, 128);
		contentPane.add(btnSobre);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 515, 794, 56);
		contentPane.add(panel);
		panel.setLayout(null);
	} // Fim
	DAO dao = new DAO();
	private void status() {
		try {
			Connection con = dao.conectar();
			System.out.println(con);
			if (con != null) {
				//lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dbon.png")));

			} else {
				//lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dboff.png")));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		// Modificar a label do rodapé para a Data atual
		/*
		Date datalabel = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblDataLabel.setText(formatador.format(datalabel));
		*/
	}
}
