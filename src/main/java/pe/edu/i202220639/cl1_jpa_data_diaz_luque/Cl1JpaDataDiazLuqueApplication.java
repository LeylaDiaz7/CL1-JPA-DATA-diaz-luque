package pe.edu.i202220639.cl1_jpa_data_diaz_luque;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202220639.cl1_jpa_data_diaz_luque.entity.Country;
import pe.edu.i202220639.cl1_jpa_data_diaz_luque.repository.CountryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataDiazLuqueApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataDiazLuqueApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		/**
		 * ifPresentOrElse()
		 * Imprimir en la terminal los nombres de los lenguajes que se hablan en el país “ARG” (Angentina).
		 * En caso de no obtener resultado, deberá imprimir los nombres de los lenguajes del país “PER” (Perú).
		 */

		Optional<Country> optional = countryRepository.findById("ARG");

		optional.ifPresentOrElse(
				(country) ->
				{
					//imprimir nombres de los lenguajjes que se hablan en ARG
					System.out.println("Lenguajes en ARG:");
					country.getLanguages().forEach(language ->
							System.out.println(language.getCountryLanguagePk().getLanguage())
					);
				},
				() -> {
					//Si no hay pais ARG, Buscar PER e imprimir sus nombres de lenguajes
					countryRepository.findById("PER").ifPresent(country -> {
						System.out.println("No se encontró ARG. Lenguajes en PER:");
						country.getLanguages().forEach(language ->
								System.out.println(language.getCountryLanguagePk().getLanguage())
						);
					});
				}
		);

		/**
		 * deleteAllById()
		 * Eliminar 2 países: “COL” y “ARG”. La eliminación deberá ser cascada y borrará sus cuidades y lenguajes correspondientes.
		 */

		// Eliminar los países "COL" y "ARG" (y sus ciudades y lenguajes en cascada)
		List<String> ids = List.of("COL", "ARG");

		ids.stream().filter(countryRepository::existsById).collect(Collectors.toList());

		if (!ids.isEmpty()) {
			countryRepository.deleteAllById(ids);
			System.out.println("Países eliminados: " + ids);
        } else{
			System.out.println("Ids no existen en BD");
		}


	}
}