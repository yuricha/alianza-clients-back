package com.alianzaclientsback.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alianzaclientsback.commons.HttpStatusUtil;
import com.alianzaclientsback.commons.ResponseDto;
import com.alianzaclientsback.commons.Values;
import com.alianzaclientsback.model.Client;
import com.alianzaclientsback.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientController {

	
    @Autowired
    ClientService clientService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/client")
    public ResponseEntity<String> getClient(){

        return new HttpStatusUtil().getHttpStatusByResponse(new ResponseDto(Values.APP_CODE_OK, clientService.getListClients()));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/client")
    public ResponseEntity<String> saveProduct(@RequestBody Client client){
        return new HttpStatusUtil().getHttpStatusByResponse(clientService.saveClient(client));
    }
}
