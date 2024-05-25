package de.ttsa.Tools;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipManager {

    private static String prePath;

    public static List<String> readFromZip(String zipFilePath, String entryPath) throws IOException {
        try (FileInputStream fis = new FileInputStream(zipFilePath);
                ZipInputStream zis = new ZipInputStream(fis, StandardCharsets.UTF_8)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().endsWith("/" + entryPath)) {
                    return readEntryData(zis);
                }
            }
        }

        throw new IOException("Entry " + entryPath + " not found in zip file " + zipFilePath);
    }

    private static List<String> readEntryData(InputStream is) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }

    public static boolean unzip(String source, String destination) {
        try {
            // Eingabestream für die Zip-Datei
            FileInputStream fis = new FileInputStream(source);
            ZipInputStream zis = new ZipInputStream(fis);

            // Methode zum Entpacken aufrufen
            extractFiles(zis, destination);

            // Stream schließen
            zis.close();
            fis.close();

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static File zip(String source, String destination, String zipName) {
        String folderMarker;
        prePath = source;
        if (ProcessData.isWindows())
            folderMarker = "\\";
        else
            folderMarker = "/";

        try {
            // Ausgabedatei erstellen
            FileOutputStream fos = new FileOutputStream(destination + folderMarker + zipName + ".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);

            // Methode zum Hinzufügen von Dateien zum Zip-Archiv aufrufen
            addFilesToZip(source, destination, zos);

            // Stream schließen
            zos.close();
            fos.close();

            return new File(destination + folderMarker + zipName + ".zip");
        } catch (IOException e) {
            return null;
        }
    }

    public static void zip(String source, String destination) {
        String sourceFileName = new File(source).getName();
        zip(source, destination, sourceFileName);
    }

    private static void addFilesToZip(String folder, String sourceFolder, ZipOutputStream zos) throws IOException {
        File sourceFile = new File(folder);
        File[] files = sourceFile.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                // Rekursiver Aufruf für Unterverzeichnisse
                addFilesToZip(file.getAbsolutePath(), sourceFolder, zos);
            } else {
                // Datei zum Zip-Archiv hinzufügen
                String relativePath = file.getAbsolutePath().substring(prePath.length());
                ZipEntry zipEntry = new ZipEntry(relativePath);
                zos.putNextEntry(zipEntry);

                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int length;

                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }

                zos.closeEntry();
                fis.close();
            }
        }
    }

    private static void extractFiles(ZipInputStream zis, String destinationFolder) throws IOException {
        byte[] buffer = new byte[1024];

        ZipEntry zipEntry = zis.getNextEntry();

        while (zipEntry != null) {
            String fileName = zipEntry.getName();
            File newFile = new File(destinationFolder + File.separator + fileName);

            // Erstellen der Verzeichnisse, wenn diese nicht existieren
            new File(newFile.getParent()).mkdirs();

            // Datei schreiben
            FileOutputStream fos = new FileOutputStream(newFile);
            int length;

            while ((length = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            fos.close();
            zis.closeEntry();
            zipEntry = zis.getNextEntry();
        }
    }

    public static List<InputStream> getMusicFiles(String zipFilePath, List<String> musicFileNames) {
        Map<String, byte[]> musicFilesMap = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                if (!entry.isDirectory() && fileName.contains("music/")) {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count;
                    while ((count = zis.read(buffer)) != -1) {
                        baos.write(buffer, 0, count);
                    }
                    musicFilesMap.put(fileName.substring(fileName.lastIndexOf("/") + 1), baos.toByteArray());
                }
            }

            List<InputStream> musicStreams = new ArrayList<>();
            for (String musicFileName : musicFileNames) {
                byte[] musicFile = musicFilesMap.get(musicFileName);
                if (musicFile != null) {
                    musicStreams.add(new ByteArrayInputStream(musicFile));
                }
            }
            return musicStreams;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static List<InputStream> getInputStreams(String zipFilePath, List<String> fileNameList) {
        Map<String, byte[]> musicFilesMap = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                if (!entry.isDirectory() && fileNameList.contains(fileName.substring(fileName.lastIndexOf("/") + 1))) {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count;
                    while ((count = zis.read(buffer)) != -1) {
                        baos.write(buffer, 0, count);
                    }
                    musicFilesMap.put(fileName.substring(fileName.lastIndexOf("/") + 1), baos.toByteArray());
                }
            }

            List<InputStream> musicStreams = new ArrayList<>();
            for (String musicFileName : fileNameList) {
                byte[] musicFile = musicFilesMap.get(musicFileName);
                if (musicFile != null) {
                    musicStreams.add(new ByteArrayInputStream(musicFile));
                }
            }
            return musicStreams;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static List<InputStream> getInputStreamsForHashKey(File zipFilePath) {
        List<String> fileNameList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                String fileName = entry.getName();
                if (!entry.isDirectory() && !fileName.endsWith(".key")) {
                    fileNameList.add(fileName.substring(fileName.lastIndexOf("/") + 1));
                }
            }
            return getInputStreams(zipFilePath.getAbsolutePath(), fileNameList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
