package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query ("SELECT SUM(c.population) AS population "
    + "FROM City c "
    + "WHERE c.country.id = :id ")
    public int sommePop (int id) ;

    @Query ("Select c.country.name as nom , sum (c.population) as population "
            + "FROM City c "
    + "GROUP BY name ")
    public List<Projection> lesPays () ;

}

