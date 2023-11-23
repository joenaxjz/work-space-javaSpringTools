package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Contact;
import com.demo.entities.Invoice;
import com.demo.repositories.InvoiceRepository;


@Service
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@Override
	public Iterable<Invoice> findAll() {
		// TODO Auto-generated method stub
		return invoiceRepo.findAll();
	}

	@Override
	public Invoice save(Invoice invoice) {
		try {
			return invoiceRepo.save(invoice);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
