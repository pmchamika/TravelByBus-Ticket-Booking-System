package IT17056212.dao;

import IT17056212.model.Bus;

import java.util.List;

public interface BusDao {
    boolean add(Bus bus);
    boolean update(Bus bus);
    boolean delete(Bus bus);
    List<Bus> getBusList();
    List<Bus> getBusById(int bId);
}
