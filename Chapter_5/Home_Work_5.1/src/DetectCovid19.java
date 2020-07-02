import java.text.DecimalFormat;
import java.util.Random;

public class DetectCovid19 {

    private static final int NUMBER_OF_PATIENTS = 30;
    private static final float MIN_PATIENT_TEMPERATURE = 36.2f;
    private static final float MAX_PATIENT_TEMPERATURE = 36.9f;
    private static final int MIN_TEMPERATURE = 32;
    private static final int MAX_TEMPERATURE = 40;

    public static void main(String[] args) {

        float[] patients = new float[NUMBER_OF_PATIENTS];
        float averageTemperature = 0F;
        int healthyPatient = 0;

        for (int patient = 0; patient < patients.length; patient++){
            float temperature = Float.parseFloat((new DecimalFormat("##.#").format((new Random().nextFloat() * (MAX_TEMPERATURE - MIN_TEMPERATURE)) + MIN_TEMPERATURE)));
            patients[patient] = temperature;
            averageTemperature += temperature / NUMBER_OF_PATIENTS;
            if (temperature >= MIN_PATIENT_TEMPERATURE && temperature <= MAX_PATIENT_TEMPERATURE){
                healthyPatient++;
            }
        }


        System.out.print("Температуры пациентов: ");
        for (float temperature: patients){
            System.out.print(temperature + " ");
        }
        System.out.println();
        System.out.println("Средняя температура: " + Float.parseFloat((new DecimalFormat("##.#").format(averageTemperature))));
        System.out.println("Количество здоровых: " + healthyPatient);
    }
}
