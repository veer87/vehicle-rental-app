package com.assignment.navi.utils;

import com.assignment.navi.service.RentalService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputOutputUtils {
    private static Logger logger = Logger.getLogger(InputOutputUtils.class.getName());
    public static List<String> readLines(String filePath)  {
        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line = null;

            while ((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
            bufferedReader.close();
            return lines;
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        } finally {

        }
        return null;
    }
}
