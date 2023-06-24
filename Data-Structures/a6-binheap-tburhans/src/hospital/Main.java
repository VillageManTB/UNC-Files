package hospital;

public class Main {

    public static void main(String[] args) {
        /*
        Part 1
         */
        SimpleEmergencyRoom roomER = new SimpleEmergencyRoom();
        fillER(roomER);

        long start = System.nanoTime();
        for (int i=0; i<10; i++){
            roomER.dequeue();
        }
        long end = System.nanoTime();
        System.out.println((end-start) / 10L);

        SimpleEmergencyRoom room = new SimpleEmergencyRoom();
        room.addPatient("this", 1);
        System.out.println(room.dequeue());





       /*
        Part 2
         */
        MinBinHeapER minRoom = new MinBinHeapER();
        minRoom.enqueue("tom", 2);
        minRoom.enqueue("mary", 1);
        minRoom.enqueue("nancy", 3);
        minRoom.enqueue("fred", 6);
        minRoom.enqueue("sophie", 4);
        System.out.println(minRoom.dequeue());
        System.out.println(minRoom.dequeue());
        System.out.println(minRoom.dequeue());
        System.out.println(minRoom.dequeue());
        System.out.println(minRoom.dequeue());

        MinBinHeapER minRoom2 = new MinBinHeapER();
        fillER(minRoom2);

        long start2 = System.nanoTime();
        for (int i=0; i<10; i++){
            roomER.dequeue();
        }
        long end2 = System.nanoTime();
        System.out.println((end2-start2) / 10L);




        /*
        Part 3
         */
        MinBinHeapER transfer = new MinBinHeapER(makePatients());
        Prioritized[] arr = transfer.getAsArray();
        for(int i = 0; i < transfer.size(); i++) {
            System.out.println("Value: " + arr[i].getValue()
                    + ", Priority: " + arr[i].getPriority());
        }

    }

    public static void fillER(MinBinHeapER complexER) {
        for(int i = 0; i < 100000; i++) {
            complexER.enqueue(i);
        }
    }
    public static void fillER(SimpleEmergencyRoom simpleER) {
        for(int i = 0; i < 100000; i++) {
            simpleER.addPatient(i);
        }
    }

    public static Patient[] makePatients() {
        Patient[] patients = new Patient[10];
        for(int i = 0; i < 10; i++) {
            patients[i] = new Patient(i);
        }
        return patients;
    }



}



