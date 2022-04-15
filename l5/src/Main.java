import callcenter.CallCenter;
import callcenter.Client;
import callcenter.Operator;
import parking.Car;
import parking.Parking;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;


public class Main {
    private static final Logger LOG = Logger.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
        LOG.info("Starting program");
        LOG.info("Task 1");

        final  int NUMBER_OF_OPERATORS = 3;
        final  int NUMBER_OF_CLIENTS = 5;
        ArrayList<Operator> operators = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_OPERATORS; i++) {
            operators.add(new Operator(i));
        }

        CallCenter callCenter = new CallCenter(operators);
        for (int i = 1; i <= NUMBER_OF_CLIENTS; i++) {
            Thread thread = new Thread(new Client(callCenter, i));
            thread.start();
        }

        LOG.info("Task 2");

        final int NUMBER_OF_CARS = 10;
        final int FIRST_PARKING =3 ;
        final int SECOND_PARKING = 4;

        Parking first_parking = new Parking(1, FIRST_PARKING);
        Parking second_parking = new Parking(2, SECOND_PARKING);
        Semaphore first = new Semaphore(first_parking.getSize(), true);
        Semaphore second = new Semaphore(second_parking.getSize(), true);
        ExecutorService service = Executors.newCachedThreadPool();

        for (int number = 1; number <= NUMBER_OF_CARS; ) {
            service.execute(new Car(first_parking, first, number++));
            service.execute(new Car(second_parking, second, number++));
        }
        service.shutdown();

        LOG.info("End of program");
    }
}