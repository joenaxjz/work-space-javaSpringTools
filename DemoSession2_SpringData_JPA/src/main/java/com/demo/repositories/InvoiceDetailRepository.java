package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Contact;
import com.demo.entities.Invoice;
import com.demo.entities.InvoiceDetails;
import com.demo.entities.InvoiceDetailsId;

@Repository
public interface InvoiceDetailRepository extends CrudRepository<InvoiceDetails, InvoiceDetailsId> {

}
