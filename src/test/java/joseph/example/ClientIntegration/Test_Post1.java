package joseph.example.ClientIntegration;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Test_Post1 {
    @Test
    public void test_1_post() {
        String Base_Url="https://mawingu.cbaloop.com/cardapp/v1/card/topup";
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(map);
        JSONObject request = new JSONObject();
        request.put("cardtype", "MasterCard");
        request.put("cardNumber", "445566778811223344");
        request.put("amout","10");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post(Base_Url).
                then().log().all();
                //statusCode(201);

    }
@Test
    public  void test_2_post(){

        String Base_Url="https://mawingu.cbaloop.com/cardapp/v1/card/topup";
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("cardtype", "Mastercard");

        System.out.println(map);

        JSONObject request = new JSONObject();
       //Get cards
        request.put("cardNumber","4455667788112233441");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post(Base_Url).
                then().log().all();
        //statusCode(201

    }



}
