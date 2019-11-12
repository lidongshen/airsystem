package dao.prototype;


import entity.*;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;
import java.util.Map;

/**
 * @author dqyy
 */

public interface Boss {

    //    List<Booking> searchCount();
//    List<Booking> searchCount();
//    List searchDate();
//    List<BusinessPoint> searchBusinesspoint();
//    List<BusinessPoint> searchBusinesspointfor(int i);
//    List<Clerker> searchClerker(int cid);
    List<Piao> searchBusinesspointSum();

    List<BusinesspointAndNum> searchBuAndNum(String year);
}
