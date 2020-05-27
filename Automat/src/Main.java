import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        while(true){


            ProcessBuilder processBuilder = new ProcessBuilder();


            processBuilder.command("cmd.exe", "/c", "java -jar SeleniumTest.jar");

            // Run a bat file
            //processBuilder.command("C:\\Users\\mkyong\\hello.bat");

            try {

                Process process = processBuilder.start();

                StringBuilder output = new StringBuilder();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }

             /*   int exitVal = process.waitFor();
                if (exitVal == 0) {
                    System.out.println("Success!");
                    System.out.println(output);
                    System.exit(0);
                } else {
                    //abnormal...
                }
*/
            } catch (IOException e) {
                e.printStackTrace();
            } /*catch (InterruptedException e) {
                e.printStackTrace();
            }*/


            processBuilder.command("cmd.exe", "/c", "java -jar SeleniumTestMess.jar");

            // Run a bat file
            //processBuilder.command("C:\\Users\\mkyong\\hello.bat");

            try {

                Process process = processBuilder.start();

                StringBuilder output = new StringBuilder();

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line + "\n");
                }

                int exitVal = process.waitFor();
                if (exitVal == 0) {
                    System.out.println("Success!");
                    System.out.println(output);
                    //System.exit(0);
                } else {
                    //abnormal...
                }

            } catch (IOException e) {
                e.printStackTrace();
            } /*catch (InterruptedException e) {
                e.printStackTrace();
            }*/




           TimeUnit.SECONDS.sleep(60);


        }


    }


}
