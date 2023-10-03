package com.whizdm.payment_service.utils.APICaller;

import com.whizdm.payment_service.entity.ComRequestBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

//Singleton Class
public class APICaller implements APICallerService{
    public RestTemplate restTemplate = new RestTemplate();
  private static APICaller call = null;


  private ComRequestBody comRequestBody;
  private APICaller(){}

    public static APICaller getInstance(){
      if (call == null) return new APICaller();
      return call;
    }
  public String getAPICall(String url) throws IOException,InterruptedException{
      var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
      var client = HttpClient.newBuilder().build();
      var response = client.send(request, HttpResponse.BodyHandlers.ofString());
      return response.body();
  }
    public HashMap postAPICallLos(String url, String id, String message) throws IOException,InterruptedException{

        RestTemplate restTemplate = new RestTemplate();
        var values = new HashMap<String,Long>(){{
            put("loanId",Long.parseLong(id));
        }};

        return restTemplate.postForObject(url,values,HashMap.class);

    }
    public String postAPICallComm(String url,String req_type,String user_id, String loan_id,String bank_acc,String amount ,String body) throws IOException,InterruptedException{

      HashMap<String,String> details = new HashMap<String,String>(){{
            put("loanId",loan_id);
            put("reason",body);
            put("userId",user_id);
            put("bankAccount",bank_acc);
            put("amount",amount);
        }};

        ComRequestBody comRequestBody = new ComRequestBody();
        comRequestBody.setRequestType(req_type);
        comRequestBody.setDetails(details);

        return restTemplate.postForObject(url,comRequestBody,String.class);

    }
    public HashMap postAPICallAuth(String url, String id, String message) throws IOException,InterruptedException{

        var values = new HashMap<String,String>(){{
            put("auth_token",message);
            put("device_id",id);
        }};

        return restTemplate.postForObject(url,values,HashMap.class);

    }
}
