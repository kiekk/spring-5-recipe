package com.example.recipe1311.replicator;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;

public class FileCopierJMXImpl implements FileCopier {

    public void copyFile(String srcDir, String destDir, String filename) throws IOException {
        File srcFile = new File(srcDir, filename);
        File destFile = new File(destDir, filename);
        FileCopyUtils.copy(srcFile, destFile);
    }
}
