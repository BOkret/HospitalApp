package logic;
import data.Patient;

public class Hospital {
    public static final int EXIT = 0;
    public static final int ADD_PATIENT = 1;
    public static final int PRINT_LIST = 2;

    private int maxNumberOfPatients = 10;
    private Patient[] tab = new Patient[maxNumberOfPatients];
    private int numberOfPatients = 0;

    public Patient addPatient(String firstName, String lastName, long pesel){
        numberOfPatients += 1;
        return tab[numberOfPatients - 1] = new Patient(firstName, lastName, pesel);
    }

//    void checkNumberOfPatients(int numberOfPatients) {
//        if (numberOfPatients < 10) {
//
//        } else
//            System.out.println("Limit pacjentów został wyczerpany");
//    }

    public void printInfo(int numberOfPatients){
        if ( numberOfPatients == 0) {
            System.out.println("Brak zapisanych pacjentów");
//          }  else if ( numberOfPatients == maxNumberOfPatients){
//            System.out.println("Limit pacjentów został wyczerpany");
        } else {
            printPatientsList();
        }
    }

    public void printPatientsList(){
        for (int i = 0; i < numberOfPatients; i++) {
            System.out.println("Pacjent " + (i + 1) + ": " + tab[i].getFirstName()
                    + " " + tab[i].getLastName() + " " + tab[i].getPesel());
        }
    }

    public void programInfo(){
        System.out.println(EXIT + " - wyjście z programu");
        System.out.println(ADD_PATIENT + " - dopisanie pacjenta");
        System.out.println(PRINT_LIST + " - wyświetlenie listy zapisanych pacjentów");
    }

    public int getNumberOfPatients(){
        return numberOfPatients;
    }
    public int getMaxNumberOfPatients(){
        return maxNumberOfPatients;
    }
}


