package elharchi.zakaria.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elharchi.zakaria.entities.Employe;
import elharchi.zakaria.entities.Service1;




@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
	public List<Employe> findByService(Service1 service);
}

