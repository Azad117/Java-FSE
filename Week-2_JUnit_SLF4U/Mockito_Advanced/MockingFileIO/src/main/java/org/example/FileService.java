package org.example;

public class FileService {
    private FileReader filereader;
    private FileWriter filewriter;

    public FileService(FileReader filereader, FileWriter filewriter) {
        this.filereader = filereader;
        this.filewriter = filewriter;
    }

    public String processFile()
    {
        String content = filereader.read();
        String processed = "Processed " + content;
        filewriter.write(processed);
        return processed;
    }
}
