package Model;

import View.NoteAppView;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

public class NoteAppModel {
    private String fileName;
    private String content;
    private NoteAppView noteAppView;
    private JFileChooser fileChooser;

    public NoteAppModel(NoteAppView noteAppView) {
        this.fileName = "";
        this.content = "";
        this.noteAppView = noteAppView;
        this.fileChooser = new JFileChooser();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void saveFile() {
        int returnValue = fileChooser.showSaveDialog(noteAppView);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                java.io.File file = fileChooser.getSelectedFile();
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(fileWriter);
                writer.write(noteAppView.getText());
                writer.close();
                fileWriter.close();
                System.out.println("File saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
