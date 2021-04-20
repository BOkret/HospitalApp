package app;

import logic.Hospital;

import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner inputInformation = new Scanner(System.in);
        int info;

        hospital.programInfo();
        while (( info = inputInformation.nextInt()) != Hospital.EXIT)
        switch (info){
            case Hospital.ADD_PATIENT:
                checkNumberOfPatients(hospital, inputInformation);
                break;
            case Hospital.PRINT_LIST:
                hospital.printInfo(hospital.getNumberOfPatients());
                hospital.programInfo();
                break;
            default:
                wrongInputInfo(hospital);
        }
        inputInformation.close();
    }



    private static void wrongInputInfo(Hospital hospital) {
        System.out.println("BŁĄD: Podaj właściwą liczbę");
        hospital.programInfo();
    }

    private static void checkNumberOfPatients(Hospital hospital, Scanner inputInformation) {
        if (hospital.getNumberOfPatients() == hospital.getMaxNumberOfPatients()){
            tooManyPatientsInfo(hospital);
        } else {
            addPatientToList(hospital, inputInformation);
        }
    }

    private static void tooManyPatientsInfo(Hospital hospital) {
        System.out.println("Wyczerpano liczbę pacjentów");
        hospital.programInfo();
    }

    private static void addPatientToList(Hospital hospital, Scanner inputInformation) {
        System.out.println("Dopisz pacjenta ");
        System.out.println("Podaj jego imię, nazwisko oraz numer PESEL");
        inputInformation.nextLine();
        hospital.addPatient(inputInformation.nextLine(), inputInformation.nextLine(), inputInformation.nextLong());
        hospital.programInfo();
    }
}
