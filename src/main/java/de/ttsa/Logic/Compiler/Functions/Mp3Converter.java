package de.ttsa.Logic.Compiler.Functions;

import java.io.File;
import java.io.PrintStream;

import org.apache.commons.io.output.NullOutputStream;

import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.InputFormatException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;

public class Mp3Converter {
    
    public static void convertToMp3(File source, File destination) {
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(128000);
        audio.setChannels(2);
        audio.setSamplingRate(44100);
        
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setOutputFormat("mp3");
        attrs.setAudioAttributes(audio);
        
        PrintStream originalOut = System.err;
        System.setErr(new PrintStream(NullOutputStream.NULL_OUTPUT_STREAM));
        Encoder encoder = new Encoder();
        System.setErr(originalOut);
        try {
            encoder.encode(new MultimediaObject(source), destination, attrs);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InputFormatException e) {
            e.printStackTrace();
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }

}
