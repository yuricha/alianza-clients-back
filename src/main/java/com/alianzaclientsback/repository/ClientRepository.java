package com.alianzaclientsback.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.alianzaclientsback.model.Client;

@Component
public class ClientRepository {
	

	private static final int minCode=100;
	private static final int maxCode=1000;
	
	private static final int minUnit=100;
	private static final int maxUnit=1000;	
	
    private List<Client> listMemory;

    public List<Client> getListMemory() {
        return listMemory;
    }
    
    private int NUMBER_OF_CLIENT=50;
    
    

    
    public int getNUMBER_OF_CLIENT() {
		return NUMBER_OF_CLIENT;
	}

	public void setNUMBER_OF_CLIENT(int nUMBER_OF_CLIENT) {
		NUMBER_OF_CLIENT = nUMBER_OF_CLIENT;
	}

	public void initializeListClient(){
    	listMemory = new ArrayList<>();
        for (int i = 0; i < this.getNUMBER_OF_CLIENT(); i++) {
            Client product= new Client();
            product.setCodeClient(getRandomCode(minCode,maxCode)+"");
            product.setEmail(getRandomDescription()+"@gmail.com");
            product.setName(getRandomDescription());
            product.setPhone(getRandomCode(minUnit,maxUnit)+"0000");
            listMemory.add(product);
        }
    }

    public String getRandomDescription() {
        Random r = new java.util.Random ();
        return Long.toString (r.nextLong () & Long.MAX_VALUE, 36);
    }
    public double getRandomPrice(double min, double max) {
        return  ((Math.random() * (max - min)) + min);
    }
    public int getRandomCode(int minCode, int maxCode) {
        return ((int) (minCode + (Math.random() * (maxCode - minCode))));
    }

    public List<Client> getClient(String codeProduct) {
        return listMemory.stream().filter(p->p.getCodeClient().equals(codeProduct)).collect(Collectors.toList());
    }

    public void addClient(Client client) {
    	client.setCodeClient(getRandomCode(minCode,maxCode)+"");
        listMemory.add(client);
    }

}
