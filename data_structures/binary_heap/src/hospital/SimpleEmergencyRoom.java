package hospital;

import java.util.ArrayList;
import java.util.List;

public class SimpleEmergencyRoom {
    private List<Patient> patients;

    public SimpleEmergencyRoom() {
        patients = new ArrayList<>();
    }

    // TODO: dequeue
    public Patient dequeue() {
        if (size() == 0) {
            throw new UnsupportedOperationException();
        }
        int min = 0;
        for (int i = 0; i<size()-1; i++) {
            Patient patient1 = patients.get(min);
            Patient patient2 = patients.get(i+1);
            if (patient1.getPriority().compareTo(patient2.getPriority()) > 0) {
                min = i+1;
            }
        }
        Patient result = patients.remove(min);
        return result;
    }

    public <V, P> void addPatient(V value, P priority) {
        Patient patient = new Patient(value, (Integer) priority);
        patients.add(patient);
    }

    public <V> void addPatient(V value) {
        Patient patient = new Patient(value);
        patients.add(patient);
    }

    public List getPatients() {
        return patients;
    }

    public int size() {
        return patients.size();
    }

}