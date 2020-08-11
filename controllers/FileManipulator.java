package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import models.attendant.Doctor;
import models.attendant.Nurse;
import models.attended.AdultPatient;
import models.attended.ChildPatient;
import models.events.Event;
import models.events.EventIn;
import utils.DateManipulator;

public abstract class FileManipulator {
    private static final String PATH = new File("").getAbsolutePath();
    
    public static void fillData(String filename, EventLoop loop) throws Exception {
        try (BufferedReader file = new BufferedReader(new FileReader(PATH + filename))) {
            int amount;
            
            /**
             * Read Attendants
             */
            amount = Integer.parseInt(file.readLine());
            for(int i = 0; i < amount; i++) {
                String[] data = file.readLine().split(";");
                if (data[0].equals("Doctor")) {
                    Doctor doctor = new Doctor(data[1], data[2], data[4], DateManipulator.stringToDate(data[3]), data[5]);
                    loop.addAttendant(doctor);
                } else if (data[0].equals("Nurse")) {
                    Nurse nurse = new Nurse(data[1], data[2], data[4], DateManipulator.stringToDate(data[3]));
                    loop.addAttendant(nurse);
                }
            }
            
            /**
             * Read Attendeds
             */
            amount = Integer.parseInt(file.readLine());
            for(int i = 0; i < amount; i++) {
                String[] data = file.readLine().split(";");
                if (data[0].equals("ChildPatient")) {
                    ChildPatient child = new ChildPatient(data[1], data[2], data[4], DateManipulator.stringToDate(data[3]), data[5], Float.parseFloat(data[6]), Float.parseFloat(data[7]), Integer.parseInt(data[8]));
                    loop.addEvent(new EventIn(Long.parseLong(data[9]), Integer.parseInt(data[10]), child));
                } else if (data[0].equals("AdultPatient")) {
                    AdultPatient adult = new AdultPatient(data[1], data[2], data[4], DateManipulator.stringToDate(data[3]), data[5], Float.parseFloat(data[6]), Float.parseFloat(data[7]), Boolean.parseBoolean(data[8]));
                    loop.addEvent(new EventIn(Long.parseLong(data[9]), Integer.parseInt(data[10]), adult));
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void writeStats(String filename, EventLoop loop) throws Exception {
        try (FileWriter arquivo = new FileWriter(PATH + filename)) {
            for(Event event: loop.getFinishedEvents()) {
                arquivo.write(event.toString());
                arquivo.write("\n");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
