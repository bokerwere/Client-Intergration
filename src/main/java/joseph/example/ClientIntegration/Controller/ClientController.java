package joseph.example.ClientIntegration.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import joseph.example.ClientIntegration.Service.CardTopUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class ClientController {
    @Autowired
    private CardTopUp cardTopUp;
    @Value("${auth.username}")
    private String username;
    @Value("${auth.password}")
    private String password;


    //Get cards
    @GetMapping("getCards")
    public String getCard(HttpServletRequest request) throws IOException {
        String user = request.getHeader("username");
        String pass = request.getHeader("password");
        String response;
        System.out.println(request.getHeader("password"));
        if (user.matches(username) && pass.matches(password)) {
            response = cardTopUp.getCard();
            System.out.println("=====================");
        } else {
            response = "Auth failed";
        }
        return response;
    }

    //Card Top Up
    @GetMapping("topupCard")
    public String getCardTopUp(HttpServletRequest request) throws IOException, InterruptedException {
        String user = request.getHeader("username");
        String pass = request.getHeader("password");
        String response;
        if (user.matches(username) && pass.matches(password)) {
             response = cardTopUp.getCardTopUp();
            System.out.println("=====================");
        }else {
            response = "Auth failed";
        }
        return response;

    }
}
