package com.demo.services;

import com.demo.dtos.InvoiceDTO;
import com.demo.entities.Contact;
import com.demo.entities.Invoice;

public interface InvoiceService {

	public Iterable<Invoice> findAll();
	
	public Invoice save(Invoice invoice);
	
	public InvoiceDTO find2(int id);
	
}
