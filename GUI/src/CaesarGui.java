//David Evander
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CaesarGui extends JPanel{
	private JTextField txtKey;
	private JTextArea txtOut;
	private JTextArea txtIn;
	private static String input;
	private static int key;
	
	public String inToOut (char de){
		String out="";
		//txtOut.setText("");
		for (int i=0; i<input.length(); i++){
			char u=input.charAt(i);
			if (u>='A' && u<='Z'){
				if (de==('d')){
					u+=key;
					if (u>'Z')
						u-=26;
				}
				else{
					u-=key;
					if (u<'A')
						u+=26;
				}	
			}
			
			if (u>='a' && u<='z'){
				if (de==('d')){
					u+=key;
					if (u>'z')
						u-=26;
				}
				else{
					u-=key;
					if (u<'a')
						u+=26;
				}
			}
			
			/*if (u>='0' && u<='9'){
				if (de==('d')){
					u+=key;
					if (u>'Z')
						u-=10;
				}
				else{
					u-=key;
					if (u<'A')
						u+=10;
				}
			}*/
			
			out+=u;	
		}
		return out;
	}
	
	public CaesarGui() {
		setLayout(null);
		
		txtIn = new JTextArea();
		txtIn.setBounds(10, 36, 430, 92);
		add(txtIn);
		
		JLabel lblInput = new JLabel("INPUT");
		lblInput.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInput.setHorizontalAlignment(SwingConstants.CENTER);
		lblInput.setBounds(200, 25, 46, 14);
		add(lblInput);
		
		JLabel lblKey = new JLabel("KEY");
		lblKey.setHorizontalAlignment(SwingConstants.CENTER);
		lblKey.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKey.setBounds(200, 139, 46, 14);
		add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(200, 154, 46, 23);
		add(txtKey);
		txtKey.setColumns(3);
		
		JButton btnEncode = new JButton("ENCODE");
		btnEncode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				input=txtIn.getText();
				String tempKey=txtKey.getText();
				key=Integer.parseInt(tempKey);
				txtOut.setText(inToOut('e'));
			}
		});
		btnEncode.setBounds(101, 154, 89, 23);
		add(btnEncode);
		
		JButton btnDecode = new JButton("DECODE");
		btnDecode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input=txtIn.getText();
				String tempKey=txtKey.getText();
				key=Integer.parseInt(tempKey);
				txtOut.setText(inToOut('d'));
			}
		});
		btnDecode.setBounds(256, 154, 89, 23);
		add(btnDecode);
		
		txtOut = new JTextArea();
		txtOut.setBounds(10, 208, 430, 92);
		add(txtOut);
		
		JLabel lblOutput = new JLabel("OUTPUT");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOutput.setBounds(200, 197, 46, 14);
		add(lblOutput);
		
		JLabel lblCaesarCipherEncoderdecoder = new JLabel("Caesar Cipher Encoder/Decoder");
		lblCaesarCipherEncoderdecoder.setFont(new Font("High Tower Text", Font.BOLD, 15));
		lblCaesarCipherEncoderdecoder.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaesarCipherEncoderdecoder.setBounds(101, 0, 244, 14);
		add(lblCaesarCipherEncoderdecoder);
		
		setPreferredSize(new Dimension(450,320));
		
		JButton btnCopy = new JButton("COPY");
		btnCopy.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCopy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtOut.selectAll();
				txtOut.copy();
				JOptionPane.showMessageDialog(btnCopy, "COPIED TO CLIPBOARD", "", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnCopy.setBounds(372, 306, 68, 14);
		add(btnCopy);
	}

	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame ("David's Caesar Cipher Tool");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new CaesarGui());
		
		frame.pack();
		frame.setVisible(true);
		
	}
}
