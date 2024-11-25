package pe.edu.i202220639.cl1_jpa_data_diaz_luque.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202220639.cl1_jpa_data_diaz_luque.entity.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
}
