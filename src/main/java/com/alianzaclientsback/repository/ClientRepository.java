package com.alianzaclientsback.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.alianzaclientsback.model.Client;

@Component
public class ClientRepository {
	

    private List<Client> listMemory;

    public List<Client> getListMemory() {
        return listMemory;
    }
    
    private final static int NUMBER_OF_CLIENT=50;
    
    public void initializeListClient(){
    	listMemory = new ArrayList<>();
        int minCode = 100;
        int maxCode = 1000;
        int minUnit = 100;
        int maxUnit = 1000;
        double minPrice = 10;
        double maxPrice = 100;

        for (int i = 0; i < NUMBER_OF_CLIENT; i++) {
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
        listMemory.add(client);
    }
    /**
    public void discountUnitProduct(String codeProduct) {
    	List<Product>productFound=getProduct(codeProduct);
    	if(productFound.size()>0) {
    		int unitNumber=Integer.parseInt(productFound.get(0).getUnit());    		
    		productFound.get(0).setUnit((unitNumber--)+"");
    	}
    }/**/
}
