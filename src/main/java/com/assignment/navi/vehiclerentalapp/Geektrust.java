package com.assignment.navi.vehiclerentalapp;

import com.assignment.navi.service.RentalService;
import com.assignment.navi.utils.CommandUtils;
import com.assignment.navi.utils.InputOutputUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Geektrust {
	public static RentalService rentalService = new RentalService();
	public static void main(String[] args) throws Exception {

		SpringApplication.run(Geektrust.class, args);

		List<String> inputFilePaths = Arrays.asList(args[0].split(","));
		List<Object> outputResult = new ArrayList<>();
		for (String inputFilePath : inputFilePaths) {
			List<String> inputs = InputOutputUtils.readLines(inputFilePath);
			for (String input : inputs) {
				outputResult.add(CommandUtils.parseInput(input));
			}
		}

		System.out.println("result: " + outputResult);

	}

}
