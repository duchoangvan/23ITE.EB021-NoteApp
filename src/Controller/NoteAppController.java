package Controller;

import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import Model.NoteAppModel;
import View.NoteAppView;

public class NoteAppController implements ActionListener{
	NoteAppView noteAppView;
	NoteAppModel noteAppModel;
	JFileChooser fileChoose = new JFileChooser();
	
	public NoteAppController(NoteAppView noteAppView) {
		this.noteAppView = noteAppView;
		this.noteAppModel = new NoteAppModel(noteAppView);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		if(command.equals("Open")) {
		        int returnVal = fc.showOpenDialog(this.noteAppView);
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            String fileName = file.getName();
		            this.noteAppView.displayLabel.setText(file.getAbsolutePath());
		            if(fileName.endsWith(".txt"));
		            	try {
		            		List<String> allText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		            		String result = "";
		            		for (String line : allText) {
		            			result+=line;
		            			result+="\n";
		            		}
		            		this.noteAppView.textArea.setText(result);
		            	} catch (Exception e1) {
		            		e1.printStackTrace();
		            	}
		        } else {
		           
		        }
		}else if(command.equals("Save")) {
			noteAppModel.saveFile();
		}else if(command.equals("New")) {
			
		}
	}

}
