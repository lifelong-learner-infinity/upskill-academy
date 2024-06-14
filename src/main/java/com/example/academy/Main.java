package com.example.academy;

import com.example.academy.commands.CommandInvoker;
import com.example.academy.config.ApplicationConfig;
import com.example.academy.constants.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> commandLineArguments = new LinkedList<>(Arrays.asList(args));
        run(commandLineArguments);
    }
    public static void run(List<String> commandLineArgs) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
        BufferedReader bufferedReader;
        String inputFileName = commandLineArgs.get(Constants.ZERO);
        try {
            bufferedReader = new BufferedReader(new FileReader(inputFileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                List<String> listOfTokens = Arrays.asList(line.split(" "));
                commandInvoker.executeCommand(listOfTokens.get(Constants.ZERO), listOfTokens);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
