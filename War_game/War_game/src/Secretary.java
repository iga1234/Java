import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Secretary {

    List<String> events = new ArrayList<>();
    private Gson gson;


    public void Secretary() {
        this.gson = new Gson();
    }

    public void save(String path) throws IOException {
        this.gson = new Gson();
        FileWriter writer = new FileWriter(path);
        this.gson.toJson(this.events, writer);
        writer.flush();
        writer.close();
    }

    public void load(String path) throws FileNotFoundException {
        this.gson = new Gson();
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();
        JsonReader reader = new JsonReader(new FileReader(path));
        this.events = gson.fromJson(reader, listType);
    }

    public void log(String message) {
        this.events.add(message);
    }
}
