import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Servlet {
    public String response;
    public String contentbase;

    public Servlet(String contentbase){
        this.response = "";
        this.contentbase = contentbase;
    }

    public String service(Request r){

        if (!(r.getMETHOD().equals("GET") || r.getMETHOD().equals("HEAD"))) {

            this.response =  "method not implemented";

        } else if (r.getMETHOD().equals("GET")){

            String filename = !(r.getRequestURI().equals("/")) ? ""+r.getRequestURI() : "index.html";
            File file = new File(this.contentbase + filename);

            if (file.exists()) {

                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fr);
                    String line;

                    while ((line = reader.readLine()) != null) {
                        this.response += line;
                    }

                    reader.close();
                    fr.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else this.response = "404 ERROR FILE NOT FOUND";
        }
        return response;
    }
}
