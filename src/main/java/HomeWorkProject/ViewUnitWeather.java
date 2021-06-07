package HomeWorkProject;

import javafx.util.Pair;

import java.io.IOException;
import java.util.Scanner;

import static HomeWorkProject.ModelUnitWeather.getLocationKey;

public class ViewUnitWeather {
    private ControllerUnit controller=new ControllerUnit();
    public void runInterface () throws TypeErrorExeptions {

        Scanner scanner=new Scanner(System.in);

        Pair<String, String> responseCityResult;
        String locationKey;
        String locationName;
        String command;

        while (true){

            System.out.println("Введите название города/населенного пункта");
            while (true){
                 String city = scanner.nextLine();
                 try {
                     responseCityResult = getLocationKey(city);
                 }
                 catch (IOException e) {throw new TypeErrorExeptions();}

                 locationKey = responseCityResult.getKey();
                 locationName = responseCityResult.getValue();
                 if(locationKey!=null) break;
            }
            while (true) {
                System.out.println("Введите опцию: \n0 -узнать текущую погоду в горде/населенном пункте" +
                        "\n5 -узнать прогноз погоды в горде/населенном пункте на ближайшие 5 дней");
                 command = scanner.nextLine();
            if ((command.equals("0"))||(command.equals("5"))) break;
            else System.out.println("введено значение не из предложенного списка");
            }
            try {
                controller.getWeather(command,locationKey,locationName);
            }
            catch (IOException e) {throw new TypeErrorExeptions();}
        }
    }
}

