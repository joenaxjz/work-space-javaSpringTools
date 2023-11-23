package com.demo.services;

import java.util.List;
import com.demo.entities.Quyen;

public interface QuyenService {
	public Iterable<Quyen> findAll();
	public  boolean save(Quyen role);
	
	public  boolean delete(int id);
	public  Quyen find(int  id);
}
