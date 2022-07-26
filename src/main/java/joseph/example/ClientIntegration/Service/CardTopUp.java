package joseph.example.ClientIntegration.Service;

import okhttp3.*;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Service
public class CardTopUp {
    String Base_Url="https://mawingu.cbaloop.com/cardapp/v1/card/topup";
    public  String getCardTopUp() throws IOException {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("cardtype", "Mastercard");
        System.out.println(map);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cardtype", "MasterCard");
        jsonObject.put("cardNumber", "445566778811223344");
        jsonObject.put("amount","10");

        System.out.println(jsonObject);

        MediaType mediaType= MediaType.parse("application/json");
        RequestBody requestBody=RequestBody.create(mediaType, String.valueOf(jsonObject));
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(Base_Url)
                .method("POST", requestBody)
                //.addHeader("Authorization", "Basic " + encodedString)
                .build();

        Response response = client.newCall(request).execute();

        String result = response.body().string();

        System.out.println(result);

        return result;
    }
    public  String getCard() throws IOException {

        JSONObject jsonObject = new JSONObject();
        //Get cards
        jsonObject.put("cardNumber","4455667788112233441");

        System.out.println(jsonObject);

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType= MediaType.parse("application/json");
        RequestBody requestBody=RequestBody.create(mediaType, String.valueOf(jsonObject));
        Request request = new Request.Builder()
                .url(Base_Url)
                .method("POST", requestBody)
                //.addHeader("Authorization", "Basic " + encodedString)
                .build();

        Response response = client.newCall(request).execute();

        String result = response.body().string();

        System.out.println(result);

        return result;
    }
}
