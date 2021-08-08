package com.alianzaclientsback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alianzaclientsback.commons.ResponseDto;
import com.alianzaclientsback.commons.Values;
import com.alianzaclientsback.model.Client;
import com.alianzaclientsback.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService{

	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public List<Client> getListClients() {
        
		return clientRepository.getListMemory();
	}

	@Override
	public ResponseDto saveClient(Client client) {
		clientRepository.addClient(client);
        return  new ResponseDto(Values.APP_CODE_OK,client);
	}

}
