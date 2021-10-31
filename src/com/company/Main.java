//Ausawin Saehaan
package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Process class objects
        Process process = new Process();

        //PCB class objects
        PCB pcbCalculator = new PCB();
        PCB pcbGame = new PCB();
        PCB pcbMicrosoftWord = new PCB();
        PCB pcbStorage = new PCB();

        //Critical Section class objects
        CriticalSection criticalSection = new CriticalSection();

        //Scheduler class objects
        Scheduler scheduler = new Scheduler();

        //Other variables and objects
        Scanner scanner = new Scanner(System.in);
        String currLine;
        int menuSelection;
        List<Integer> calculatorPidList = new ArrayList<Integer>();
        List<Integer> gamePidList = new ArrayList<Integer>();
        List<Integer> microsoftwordPidList = new ArrayList<Integer>();
        List<Integer> storagePidList = new ArrayList<Integer>();
        List<Integer> totalList = new ArrayList<Integer>();

        List<String> processStateList = new ArrayList<String>();


        //Template files
        BufferedReader brCalculator = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Calculator.txt"));
        BufferedReader brGame = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Game.txt"));
        BufferedReader brMicrosoftWord = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\MicrosoftWord.txt"));
        BufferedReader brStorage = new BufferedReader(new FileReader("C:\\Users\\ccc\\Downloads\\School\\6 Fall 2021\\CMSC 312\\cmsc312\\Storage.txt"));

        System.out.println("****************************************");
        System.out.println("Welcome to Ausawin's OS simulator!");
        System.out.println("****************************************");
        System.out.println("Choose any of the options below by pressing the corresponding number");
        System.out.println("Once you've entered an option, type 'return' to go back to main menu");
        System.out.println("1: Applications");
        System.out.println("2: Check process states");
        System.out.println("3: Check queue(s)");
        System.out.println("4: Check something else");
        System.out.println("0: Quit");
        while(scanner.hasNextInt()){
            menuSelection = scanner.nextInt();
            switch (menuSelection) {
                case 0 -> {
                    System.out.println("Goodbye!");
                    return; //breaks while loop
                }
                case 1 -> {
                    System.out.println("You chose option 1");
                    System.out.println("Select different programs you would like to load from the list below by typing the program name");
                    System.out.println("To run a program type 'run *program* (ignore ' and * characters)");
                    System.out.println("To minimize a program type 'min *program* (ignore ' and * characters)");
                    System.out.println("To close a program type 'close *program* (ignore ' and * characters)");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Programs: ");
                    System.out.println("Calculator," + " Game," + " Microsoft Word," + " Storage");
                    while (scanner.hasNextLine()) {
                        String processName = scanner.nextLine();
                        //application process states set to new
                        //different operations with cycles given based on program user selects
                        if (processName.equalsIgnoreCase("Calculator")) {
                            System.out.println("How many processes would you like to create?");
                            int numProcesses = scanner.nextInt();
                            System.out.println(numProcesses + " processes created");
                            for(int i=1;i<=numProcesses;i++){
                                System.out.println("Process " + i + " given pid..");
                                pcbCalculator.setPid(getRandomNumber(1,100));
                                pcbCalculator.setState("NEW");
                                System.out.println(pcbCalculator.getPid());
                                calculatorPidList.add(pcbCalculator.getPid());
                                processStateList.add(pcbCalculator.getState());
                            }
                            System.out.println("------------------------------");
                            System.out.println("Operations for given processes are: ");
                            while ((currLine = brCalculator.readLine()) != null) {
                                if (currLine.equals("CALCULATE")) {
                                    process.setCycle(getRandomNumber(5, 100));
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                                if (currLine.equals("I/O")) {
                                    process.setCycle(getRandomNumber(11, 82));
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                            }
                        System.out.println("Current pid list is: " + calculatorPidList);
                        System.out.println("Return to menu by typing 'return' or load another application by typing its name");
                        }
                        if (processName.equalsIgnoreCase("Game")) {
                            System.out.println("How many processes would you like to create?");
                            int numProcesses = scanner.nextInt();
                            System.out.println(numProcesses + " processes created");
                            for(int i=1;i<=numProcesses;i++){
                                System.out.println("Process " + i + " given pid..");
                                pcbGame.setPid(getRandomNumber(1,100));
                                pcbGame.setState("NEW");
                                System.out.println(pcbGame.getPid());
                                gamePidList.add(pcbGame.getPid());
                                processStateList.add(pcbGame.getState());
                            }
                            System.out.println("------------------------------");
                            pcbGame.setState("NEW");
                            while ((currLine = brGame.readLine()) != null) {
                                if (currLine.equals("CALCULATE")) {
                                    process.setCycle(getRandomNumber(5, 100));
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                                if (currLine.equals("I/O")) {
                                    process.setCycle(getRandomNumber(11, 82));
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                            }
                            System.out.println("Current process list is: " + gamePidList);
                            System.out.println("Return to menu by typing 'return' or load another application by typing its name");
                        }
                        if (processName.equalsIgnoreCase("Microsoft Word")) {
                            System.out.println("How many processes would you like to create?");
                            int numProcesses = scanner.nextInt();
                            System.out.println(numProcesses + " processes created");
                            for(int i=1;i<=numProcesses;i++){
                                System.out.println("Process " + i + " given pid..");
                                pcbMicrosoftWord.setPid(getRandomNumber(1,100));
                                pcbMicrosoftWord.setState("NEW");
                                System.out.println(pcbMicrosoftWord.getPid());
                                microsoftwordPidList.add(pcbMicrosoftWord.getPid());
                                processStateList.add(pcbMicrosoftWord.getState());
                            }
                            System.out.println("------------------------------");
                            pcbMicrosoftWord.setState("NEW");
                            while ((currLine = brMicrosoftWord.readLine()) != null) {
                                if (currLine.equals("CALCULATE")) {
                                    process.setCycle(getRandomNumber(5, 100));
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                                if (currLine.equals("I/O")) {
                                    process.setCycle(getRandomNumber(11, 82));
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                            }
                            System.out.println("Current process list is: " + microsoftwordPidList);
                            System.out.println("Return to menu by typing 'return' or load another application by typing its name");
                        }
                        if (processName.equalsIgnoreCase("Storage")) {
                            System.out.println("How many processes would you like to create?");
                            int numProcesses = scanner.nextInt();
                            System.out.println(numProcesses + " processes created");
                            for(int i=1;i<=numProcesses;i++){
                                System.out.println("Process " + i + " given pid..");
                                pcbStorage.setPid(getRandomNumber(1,100));
                                pcbStorage.setState("NEW");
                                System.out.println(pcbStorage.getPid());
                                storagePidList.add(pcbStorage.getPid());
                                processStateList.add(pcbStorage.getState());
                            }
                            System.out.println("------------------------------");
                            pcbStorage.setState("NEW");
                            while ((currLine = brStorage.readLine()) != null) {
                                if (currLine.equals("CALCULATE")) {
                                    process.setCycle(getRandomNumber(5, 100));
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                                if (currLine.equals("I/O")) {
                                    process.setCycle(getRandomNumber(11, 82));
                                    System.out.println(currLine + " given " + process.getCycle() + " cycles");
                                }
                            }
                            System.out.println("Current process list is: " + storagePidList);
                            System.out.println("Return to menu by typing 'return' or load another application by typing its name");
                        }

                        // run program
                        // executes calculate and i/o instructions of an application's process
                        if (processName.equalsIgnoreCase("run calculator")) {
                            pcbCalculator.setState("RUNNING");
                            System.out.println("Running calculator...");
                        }
                        if (processName.equalsIgnoreCase("run game")) {
                            pcbGame.setState("RUNNING");
                            System.out.println("Running game...");
                        }
                        if (processName.equalsIgnoreCase("run microsoft word")) {
                            pcbMicrosoftWord.setState("RUNNING");
                            System.out.println("Running microsoft word...");
                        }
                        if (processName.equalsIgnoreCase("run storage")) {
                            pcbStorage.setState("RUNNING");
                            System.out.println("Running storage...");
                        }

                        // minimize program
                        // puts application's process in waiting state
                        if (processName.equalsIgnoreCase("min calculator")) {
                            pcbCalculator.setState("WAITING");
                            System.out.println("Calculator minimized");
                        }
                        if (processName.equalsIgnoreCase("min game")) {
                            pcbGame.setState("WAITING");
                            System.out.println("Game minimized");
                        }
                        if (processName.equalsIgnoreCase("min microsoft word")) {
                            pcbMicrosoftWord.setState("WAITING");
                            System.out.println("Microsoft word minimized");
                        }
                        if (processName.equalsIgnoreCase("min storage")) {
                            pcbStorage.setState("WAITING");
                            System.out.println("Storage minimized");
                        }

                        // close program
                        // terminates and/or exits application's process
                        if (processName.equalsIgnoreCase("close calculator")) {
                            pcbCalculator.setState(null);
                            System.out.println("Calculator closed");
                        }
                        if (processName.equalsIgnoreCase("close game")) {
                            pcbGame.setState(null);
                            System.out.println("Game closed");
                        }
                        if (processName.equalsIgnoreCase("close microsoft word")) {
                            pcbMicrosoftWord.setState(null);
                            System.out.println("Microsoft word closed");
                        }
                        if (processName.equalsIgnoreCase("close storage")) {
                            pcbStorage.setState(null);
                            System.out.println("Storage closed");
                        }

                        if (processName.equalsIgnoreCase("return")) {
                            System.out.println("Returning to main menu...\n");
                            System.out.println("Choose any of the options below by pressing the corresponding number");
                            System.out.println("1: Open applications");
                            System.out.println("2: Check process states");
                            System.out.println("3: Check PCB components");
                            System.out.println("4: Check something else");
                            System.out.println("0: Quit");
                            break;
                        }
                    }
                }

                case 2 -> {
                    System.out.println("You chose option 2");
                    System.out.println("Which application's process state would you like to check?");
                    while (scanner.hasNextLine()) {
                        String processName = scanner.nextLine();
                        if(processName.equalsIgnoreCase("Calculator")) {
                            if(!(calculatorPidList.isEmpty())) {
                                for(int i=0;i<calculatorPidList.size();i++){
                                    System.out.println("Process state of pid " + calculatorPidList.get(i).toString() + " is " + pcbCalculator.getState());
                                }
                            System.out.println("Enter another application or return to menu: ");
                            }else{
                                System.out.println("Application's processes not found");
                                System.out.println("Enter loaded application or go back to option 1 in main menu");
                            }
                        }
                        if (processName.equalsIgnoreCase("Game")) {
                            if(!(gamePidList.isEmpty())){
                                for(int i=0;i<gamePidList.size();i++) {
                                    System.out.println("Process state of pid " + gamePidList.get(i).toString() + " is " + pcbGame.getState());
                                }
                            System.out.println("Enter another application or return to menu: ");
                            }else{
                                System.out.println("Application's processes not found");
                                System.out.println("Enter loaded application or go back to option 1 in main menu");
                            }
                        }
                        if (processName.equalsIgnoreCase("Microsoft Word")) {
                            if(!(microsoftwordPidList.isEmpty())){
                                for(int i=0;i<microsoftwordPidList.size();i++){
                                    System.out.println("Process state of pid " + microsoftwordPidList.get(i).toString() + " is " + pcbMicrosoftWord.getState());
                                }
                            System.out.println("Enter another application or return to menu: ");
                            }else{
                                System.out.println("Application's processes not found");
                                System.out.println("Enter loaded application or go back to option 1 in main menu");
                            }
                        }
                        if (processName.equalsIgnoreCase("Storage")) {
                            if(!(storagePidList.isEmpty())){
                                for(int i=0;i<storagePidList.size();i++){
                                    System.out.println("Process state of pid " + storagePidList.get(i).toString() + " is " + pcbStorage.getState());
                                }
                            System.out.println("Enter another application or return to menu: ");
                            }else{
                                System.out.println("Application's processes not found");
                                System.out.println("Enter loaded application or go back to option 1 in main menu");
                            }
                        }
                        if (processName.equalsIgnoreCase("return")) {
                            System.out.println("Returning to main menu...\n");
                            System.out.println("Choose any of the options below by pressing the corresponding number");
                            System.out.println("1: Applications");
                            System.out.println("2: Check process states");
                            System.out.println("3: Check PCB components");
                            System.out.println("4: Check something else");
                            System.out.println("0: Quit");
                            break;
                        }
                    }
                }
                case 3 -> {
                    System.out.println("You chose option 3");
                    System.out.println("Which queue would you like to check?");
                }
            }
        }



    }
    /**Generates random number within a certain range; to be used as a representation of cycles for processes
     * min: lower bound of random number range
     * max: upper bound of random number range**/
    public static int getRandomNumber(int min, int max){
        return (int) (Math.random() * (max-min) + min);
    }
}

