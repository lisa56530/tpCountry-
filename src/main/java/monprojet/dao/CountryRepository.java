package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;
import org.springframework.data.rest.core.config.Projection;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query ("SELECT SUM (population) AS population "
    + "FROM city "
    + "WHERE country.id =: id ")
    public int sommePop (int id) ;

    @Query ("Select nom.pays as Nom , sum (population) as population "
            + "FROM country "
            + "WHERE id.country = id.city " )
            public List<Projection> lesPays () ;

}

