package lab1_threading.ex5;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class NotepadSimulation extends JFrame {
	private JTextArea textArea;
	private JFileChooser fileChooser;

	public NotepadSimulation() {
		super("Notepad Simulation");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		createGUI();
	}

	private void createGUI() {
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);

		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu fileJMenu = new JMenu("File");
		JMenu editJMenu = new JMenu("Edit");
		JMenu helpJMenu = new JMenu("Help");
		menuBar.add(fileJMenu);
		menuBar.add(editJMenu);
		menuBar.add(helpJMenu);

		JMenuItem newItem = new JMenuItem("Tạo tập tin mới");
		JMenuItem openItem = new JMenuItem("Mở tập tin");
		JMenuItem saveItem = new JMenuItem("Lưu tập tin");
		JMenuItem printItem = new JMenuItem("In ra máy in");
		JMenuItem exitItem = new JMenuItem("Thoát");
		fileJMenu.add(newItem);
		fileJMenu.add(openItem);
		fileJMenu.add(saveItem);
		fileJMenu.add(printItem);
		fileJMenu.add(exitItem);
		newItem.addActionListener(e -> newFile());
		openItem.addActionListener(e -> openFile());
		saveItem.addActionListener(e -> saveFile());
		printItem.addActionListener(e -> printFile());
		exitItem.addActionListener(e -> exit());
	}

	private void newFile() {
		textArea.setText("");
	}

	private void openFile() {
		int result = fileChooser.showSaveDialog(this);
		if(result == fileChooser.APPROVE_OPTION) {
			Path filePath = Paths.get(fileChooser.getSelectedFile().getAbsolutePath());
			
			ExecutorService executorService = Executors.newFixedThreadPool(1);
			executorService.submit(() -> {
				try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))){
					StringBuilder content = new StringBuilder();
					String line;
					while((line = reader.readLine()) != null) {
						content.append(line).append("\n");
					}
					
					SwingUtilities.invokeLater(() -> {
						textArea.setText(content.toString());
						executorService.shutdown();
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
	}

	private void saveFile() {
		int result = fileChooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			if (fileChooser.getSelectedFile() != null) {
				Path filePath = Paths.get(fileChooser.getSelectedFile().getAbsolutePath());
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
					writer.write(textArea.getText());
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy file này");
			}

		}
	}

	private void printFile() {
		JOptionPane.showMessageDialog(this, "Chưa có chức năng này");
	}

	private void exit() {
		System.exit(0);
	}

	public static void main(String[] args) {
		new NotepadSimulation().setVisible(true);
	}
}
