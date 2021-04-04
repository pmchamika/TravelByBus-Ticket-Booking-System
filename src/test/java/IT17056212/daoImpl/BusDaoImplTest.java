package IT17056212.daoImpl;

import IT17056212.dao.BusDao;
import IT17056212.model.Bus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusDaoImplTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getBusById1() {
        BusDao busDao = new BusDaoImpl();
        for (Bus bus : busDao.getBusById(Integer.parseInt("1"))) {

            assertEquals("HH7894", bus.getBusNo());
            assertEquals("TATA", bus.getModel());
            assertEquals("45", bus.getNoSeats());
        }
    }
    @Test
    void getBusById2() {
        BusDao busDao = new BusDaoImpl();
        for (Bus bus : busDao.getBusById(Integer.parseInt("2"))) {

            assertEquals("HH4561", bus.getBusNo());
            assertEquals("TATA", bus.getModel());
            assertEquals("56", bus.getNoSeats());
        }
    }
    @Test
    void getBusById3() {
        BusDao busDao = new BusDaoImpl();
        for (Bus bus : busDao.getBusById(Integer.parseInt("4"))) {

            assertEquals("FF1456", bus.getBusNo());
            assertEquals("hjh", bus.getModel());
            assertEquals("78", bus.getNoSeats());
        }
    }

    @Test
    void add() {
        Bus bus = new Bus();
        /*set all the  details to setters */

        bus.setBusNo("IT1478");
        bus.setModel("TATA");
        bus.setNoSeats("88");
        BusDao bdao= new BusDaoImpl();

        assertEquals(true, bdao.add(bus));
    }

    @Test
    void delete() {

        Bus bus = new Bus();

        bus.setbId(5);

        BusDao bdao= new BusDaoImpl();
        bdao.delete(bus);
        assertEquals(true, bdao.delete(bus));
    }
}