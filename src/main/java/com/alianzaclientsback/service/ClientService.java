package com.alianzaclientsback.service;

import java.util.List;

import com.alianzaclientsback.commons.ResponseDto;
import com.alianzaclientsback.model.Client;

public interface ClientService {

	List<Client> getListClients();

	ResponseDto saveClient(Client client);
	

}
