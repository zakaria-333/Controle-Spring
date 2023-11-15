package elharchi.zakaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import elharchi.zakaria.entities.Service1;
import elharchi.zakaria.repositories.ServiceRepository;
import ma.projet.dao.IDao;


@Service
public class ServiceService implements IDao<Service1>{
	@Autowired
	private ServiceRepository serviceRepository;

	

	@Override
	public Service1 create(Service1 o) {
		return serviceRepository.save(o);
	}

	@Override
	public boolean delete(Service1 o) {
		try {
			serviceRepository.delete(o);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
    public Service1 update(Long id, Service1 o) {
        Service1 existingService = serviceRepository.findById(id).orElse(null);

        if (existingService != null) {
            try {
            	existingService.setNom(o.getNom());
                return serviceRepository.save(existingService);
            } catch (DataAccessException e) {
                e.printStackTrace(); 
            }
        }
        return null;
    }

	@Override
	public List<Service1> findAll() {
		
		return serviceRepository.findAll();
	}

	@Override
	public Service1 findById(Long id) {
		return serviceRepository.findById(id).orElse(null);
	}	
}