package de.ttsa.Tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import de.ttsa.Frontend.Terminal.CompilerApp;

public class HashKeyGenerator {

    private static SimpleLog logCompiler = CompilerApp.log;

    public static BigInteger generateHashKeyFromFolder(File folder) {
        long start = System.currentTimeMillis();
        BigInteger hash = new BigInteger("0");
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                hash = hash.add(generateHashKeyFromFolder(file));
            } else {
                hash = hash.add(generateHashKey(file));
            }
        }
        return hash;
    }

    private static BigInteger generateHashKey(File file) {
        try {
            return generateHashKey(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        } catch (IOException e) {
            e.printStackTrace();
            return new BigInteger("0");
        }
    }

    public static BigInteger generateHashKey(InputStream is) {
        try {
            return generateHashKey(is.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return new BigInteger("0");
        }
    }
    
    private static BigInteger generateHashKey(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);
            byte[] digest = md.digest();
            String hex = DatatypeConverter.printHexBinary(digest);
            return new BigInteger(hex, 16);
        } catch (NoSuchAlgorithmException e) {
            logCompiler.trace(e.getStackTrace().toString());
            return new BigInteger("0");
        }  
    }
    
    public static boolean testHashKey(File gameFile) {
        List<InputStream> files = ZipManager.getInputStreamsForHashKey(gameFile);
        BigInteger hash = new BigInteger("0");
        String firstHash;
        String secondHash = "";
        for(InputStream is : files) {
            hash = hash.add(generateHashKey(is));
        }
        firstHash = hash.toString(16);
        List<String> hashKeyFile = new ArrayList<>();
        hashKeyFile.add(".key");
        try {
            secondHash = ZipManager.readFromZip(gameFile.getAbsolutePath(), ".key").get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return firstHash.equals(secondHash);
    }

}
