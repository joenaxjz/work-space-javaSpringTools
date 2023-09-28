package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Cert;
import com.demo.entities.Language;

@Service
public class CertificateServiceImpl implements CertificateService {

	@Override
	public List<Cert> findAll() {
		List<Cert> certs = new ArrayList<Cert>();
		certs.add(new Cert(1, "Cert 1"));
		certs.add(new Cert(2, "Cert 2"));
		certs.add(new Cert(3, "Cert 3"));
		certs.add(new Cert(4, "Cert 4"));
		return certs;
	}

}
