package lesson5.l5_expert.variantWithClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private String REPORT_HEADER_CUT;
    private Path resource;

    public Utils(String REPORT_HEADER_CUT, Path resource) {
        this.REPORT_HEADER_CUT = REPORT_HEADER_CUT;
        this.resource = resource;
    }

    public List<Path> getFilesPath() throws IOException {
        return Files.walk(resource)
                .filter(Files::isRegularFile)
                .filter(files -> (files.getFileName().toString().contains("report_0") || files.getFileName().toString().contains("report_1")))
                .collect(Collectors.toList());
    }

    public List<String> getDataFromFiles(List<Path> filesPaths) {
        List<String> dataFromFiles = new ArrayList();
        for (Path filePath : filesPaths) {
            try {
                FileReader fileReader = new FileReader(filePath.toString());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                dataFromFiles.addAll(bufferedReader.lines()
                        .filter(f -> !f.contains(REPORT_HEADER_CUT))
                        .collect(Collectors.toList()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dataFromFiles;
    }

}
