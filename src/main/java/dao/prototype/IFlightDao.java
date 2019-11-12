package dao.prototype;

import java.util.List;

import entity.Flight;
import org.springframework.stereotype.Repository;

@Repository("IFlightDao")

public interface IFlightDao {
    List<Flight> findFlightAll();

    List<Flight> findFlightPager(int offset, int pageSize);

    Flight findFlight(int id);

    int deleteFlight(int id);

    int insertFlight(Flight flight);

    int upDateFlight(Flight flight);

    int totalNum();
}
