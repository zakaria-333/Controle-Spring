package elharchi.zakaria.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import elharchi.zakaria.entities.Service1;


@Repository
public interface ServiceRepository extends JpaRepository<Service1, Long> {

}
