package com.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dtos.InvoiceDTO;
import com.demo.entities.Contact;
import com.demo.entities.Invoice;
import com.demo.repositories.InvoiceRepository;


@Service
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
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

	@Override
	public InvoiceDTO find2(int id) {
		// TODO Auto-generated method stub
		return modelMapper.map(invoiceRepo.findById(id).get(), InvoiceDTO.class);
	}

}
