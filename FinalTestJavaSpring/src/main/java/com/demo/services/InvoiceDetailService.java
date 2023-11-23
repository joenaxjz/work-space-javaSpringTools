package com.demo.services;

import com.demo.entities.Contact;
import com.demo.entities.Invoice;
import com.demo.entities.InvoiceDetails;

public interface InvoiceDetailService {

	public boolean save(InvoiceDetails invoiceDetails);
	
}
