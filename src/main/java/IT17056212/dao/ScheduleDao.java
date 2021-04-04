package IT17056212.dao;

import IT17056212.model.Schedule;

import java.util.List;

public interface ScheduleDao {
    boolean add(Schedule schedule);
    boolean update(Schedule schedule);
    boolean delete(Schedule schedule);
    List<Schedule> getScheduleList();
    List<Schedule> getScheduleByCurrentDateList(String currentDate);
    List<Schedule> getScheduleBySid(int sId);
}
