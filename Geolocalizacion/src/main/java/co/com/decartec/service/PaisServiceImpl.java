package co.com.decartec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.decartec.dao.PaisDAO;
import co.com.decartec.entity.Pais;

@Service
public class PaisServiceImpl implements PaisServices {
	
	@Autowired
	private PaisDAO paisDao;

	@Override
	public Pais save(Pais pais) {
		return paisDao.save(pais);
		
	}

}
