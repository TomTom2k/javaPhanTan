package lab1_threading.ex4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class FileCopyApplication extends JFrame {
	JTextField fromTxt;
	JTextField toTxt;
	JButton submitBtn;
	JProgressBar progress;

	public FileCopyApplication() {
		super("Copy file");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);

		createGUI();

		submitBtn.addActionListener(e -> {
			try {
				copyFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

	private void copyFile() throws IOException {
		String fromPath = fromTxt.getText().trim();
		String toPath = toTxt.getText().trim();

		if (fromPath.isEmpty() || toPath.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đường dẫn nguồn và đích");
			return;
		}

		File sourceLocation = new File(fromPath);
		File destinationLocation = new File(toPath, sourceLocation.getName());
		
		
		InputStream inputStream = new FileInputStream(sourceLocation);
		OutputStream outputStream = new FileOutputStream(destinationLocation);
		
		byte[] buffet = new byte[1024];
		int len;
		long fileSize = sourceLocation.length();
	    long totalBytesCopied = 0;
	    
		while((len = inputStream.read(buffet)) > 0) {
			outputStream.write(buffet, 0, len);
			totalBytesCopied += len;
			

	        int progressValue = (int) ((totalBytesCopied * 100) / fileSize);
	        progress.setValue(progressValue);
	        
	        try {
	            Thread.sleep(500); // 50 milliseconds delay, adjust as needed
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		inputStream.close();
		outputStream.close();
	}

	private void createGUI() {
		int num = 35;
		fromTxt = new JTextField(num);
		toTxt = new JTextField(num);
		submitBtn = new JButton("Copy file");
		progress = new JProgressBar(0, 100);

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2, 1));

		JPanel fromPanel = new JPanel();
		fromPanel.setBorder(BorderFactory.createTitledBorder("From"));
		fromPanel.add(fromTxt);
		inputPanel.add(fromPanel);

		JPanel toPanel = new JPanel();
		toPanel.setBorder(BorderFactory.createTitledBorder("To"));
		toPanel.add(toTxt);
		inputPanel.add(toPanel);

		JPanel btnPanel = new JPanel();
		btnPanel.add(submitBtn);

		progress.setStringPainted(true);

		add(inputPanel, BorderLayout.NORTH);
		add(btnPanel, BorderLayout.CENTER);
		add(progress, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		new FileCopyApplication().setVisible(true);
	}
}
