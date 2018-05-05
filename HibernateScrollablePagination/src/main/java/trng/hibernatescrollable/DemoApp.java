package trng.hibernatescrollable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DemoApp {

	public static void main(String[] args) throws ParseException {
	     
        Address sidAddress = new Address("g-147", "sec-44", "east road", "new delhi", "india", 75063); 
        Address kumarAddress = new Address("g-147", "delhi", "agra", "new delhi", "india", 560072); 
        Customer sid = new Customer("Nagesh",new Date(), "Nagesh", "Chauhan", "beingjavaguy@gmail.com", 8789876, 123); 
        Customer kumar = new Customer("Nag",new Date(), "Nag", "Cha", "guy@gmail.com", 87898, 122);
        Orders o1 = new Orders(new Date(), new Date(), "shipped");
        Orders o2 = new Orders(new Date(), new Date(), "received");
     
  
        sid.setAddress(sidAddress);  
        kumar.setAddress(kumarAddress);
        
        
        CustomerDAOimpl  dao = new CustomerDAOimpl();
        OrderDAO orderDao = new OrderDAO();
        
        Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-05-04 00:00:00");
	    Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-05-04 00:00:00");
        try {
			sid = dao.addCustomer(sid);
			kumar = dao.addCustomer(kumar);
			
			o1.setCustomer(sid);
			o2.setCustomer(kumar);
			
			orderDao.addOrder(o1);
			orderDao.addOrder(o2);
			
			
			
			System.out.println(dao.loadCustomer(sid.getId()));
			System.out.println(dao.loadCustomer(kumar.getId()));
			
			//dao.deleteCustomer(sid.getId());
			
			kumar.setFname("Nagi");
			dao.updateCustomer(kumar);
			System.out.println(dao.loadCustomer(kumar.getId()));
			
			System.out.println(orderDao.monthlyCount(5));
			
		} catch (CustomerException e) {
			
			e.printStackTrace();
		} 

	}

}
