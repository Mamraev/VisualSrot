package main;

import javax.sound.midi.*;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;

public class AudioController extends Thread {
    ArrayController arr;
    public AudioController(ArrayController arr){
        this.arr=arr;
    }
    @Override
    public void run() {
        Synthesizer synth = null;
        try {
            synth = MidiSystem.getSynthesizer();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        try {
            synth.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
        synth.loadAllInstruments(synth.getDefaultSoundbank());
        MidiChannel chan = synth.getChannels()[0];
        for(Instrument i : synth.getLoadedInstruments())
            if(i.getName().toLowerCase().trim().contains("sine")){
                chan.programChange(i.getPatch().getProgram());
                break;
            }

        if(chan.getProgram() == 0)
            JOptionPane.showMessageDialog(null, "Could not find a valid instrument. Sound is disabled");
        double maxNum = arr.length();

        while (true){
            chan.allNotesOff();
            chan.allSoundOff();
            for(int i = 0 ; i < arr.length() ; i++){

                if(arr.getMark(i)==1||arr.getMark(i)==2){
                    double pitch = (arr.getNum(i)/maxNum)*127;
                    if(i == arr.length()-1 && arr.getMark(i)==2){
                        chan.noteOn((int)pitch, 20);
                        for(int f = 0 ; f < 128 ; f++){
                            chan.noteOff(f);
                        }
                        try {
                            sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Thread.currentThread().interrupt();
                        return;
                    }

                    chan.noteOn((int)pitch, 10);

                }
            }
        }
    }
}
