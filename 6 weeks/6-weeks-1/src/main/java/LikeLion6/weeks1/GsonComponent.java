package LikeLion6.weeks1;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class GsonComponent {
    private final Gson gson;

    public GsonComponent() {
        this.gson = new Gson();
    }

    public Gson getGson() {
        return this.gson;
    }

}
