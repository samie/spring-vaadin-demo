package demo.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "gpsupdates", path = "gps")
public interface GPSRepository extends JpaRepository<GPSUpdate,Long> {

}
