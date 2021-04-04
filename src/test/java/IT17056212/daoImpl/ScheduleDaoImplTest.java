package IT17056212.daoImpl;

import IT17056212.dao.ScheduleDao;
import IT17056212.model.Schedule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleDaoImplTest {

    @Test
    void add() {
        Schedule schedule = new Schedule();

        schedule.setBusNo("ER1478");
        schedule.setRouteNo("115");
        schedule.setsTime("9.00AM,10.00AM");
        schedule.setsDate("2019-09-29");
        schedule.setConId(1);
        schedule.setAdd_uid(1);
        ScheduleDao sdao= new ScheduleDaoImpl();

        assertEquals(true, sdao.add(schedule));
    }

    @Test
    void delete() {
        Schedule schedule = new Schedule();

        schedule.setsId(10);

        ScheduleDao sdao= new ScheduleDaoImpl();

        assertEquals(false, sdao.delete(schedule));
    }

    @Test
    void getScheduleBySid() {
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        for (Schedule schedule : scheduleDao.getScheduleBySid(1)) {

            assertEquals("HH4561", schedule.getBusNo());
            assertEquals("145", schedule.getRouteNo());
            assertEquals(1, schedule.getConId());
        }
    }
}