package joseph.example.ClientIntegration.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class IntergrationService {
    String Url_Card_Top="https://mawingu.cbaloop.com/cardapp/v1/card/topup";
        WebClient webClient;
    public IntergrationService(){
    }
    public  void getCard(){
        WebClient.builder()
                .baseUrl("http://localhost:3000")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        //webClient.post().uri(Url_Card_Top).contentType();

    }


    public  void getClient() throws IOException {



    }
}
