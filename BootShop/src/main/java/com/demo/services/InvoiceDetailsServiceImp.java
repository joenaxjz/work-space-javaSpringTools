package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Contact;
import com.demo.entities.Invoice;
import com.demo.entities.InvoiceDetails;
import com.demo.repositories.InvoiceDetailRepository;
import com.demo.repositories.InvoiceRepository;


@Service
public class InvoiceDetailsServiceImp implements InvoiceDetailService{

	@Autowired
	private InvoiceDetailRepository invoiceDetailRepo;

	@Override
	public boolean save(InvoiceDetails invoiceDetails) {
		try {
			invoiceDetailRepo.save(invoiceDetails);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	

}
