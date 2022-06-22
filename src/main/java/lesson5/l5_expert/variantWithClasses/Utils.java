package lesson5.l5_expert.variantWithClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    static String REPORT_HEADER_CUT;
    static Path resource;

    public Utils(String REPORT_HEADER_CUT, Path resource) {
        this.REPORT_HEADER_CUT = REPORT_HEADER_CUT;
        this.resource = resource;
    }

    public List getFilesPath() throws IOException {
        List<Path> collectFilesPath = Files.walk(resource)
                .filter(Files::isRegularFile)
                .filter(files -> (files.getFileName().toString().contains("report_0") || files.getFileName().toString().contains("report_1")))
                .collect(Collectors.toList());
        return collectFilesPath;
    }

    public List getDataFromFiles(List filesPaths) {
        List dataFromFiles = new ArrayList();
        for (Object filePath : filesPaths) {
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
