package kr.ac.hansung.csemall;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/ac/hansung/conf/beans.xml");

		OfferDao offerDao = (OfferDao) context.getBean("offerDao");

		System.out.println("The record count is " + offerDao.getRowCount());

		List<Offer> offerList = offerDao.getOffers();

		for (Offer offer : offerList) {
			System.out.println(offer);
		}

		Offer offer = new Offer();
		offer.setName("jisungJung");
		offer.setEmail("qwer1628@hansung.ac.kr");
		offer.setText("instructor of spring framework");

		if (offerDao.insert(offer)) {
			System.out.println("object is inserted sucessfully");
		} else
			System.out.println("object insert failed");

		offer = offerDao.getOffer("jisungJung");
		offer.setName("Jisung");

		if (offerDao.update(offer)) {
			System.out.println("object is updated sucessfully");
		} else
			System.out.println("object update failed");

		offer = offerDao.getOffer("Jisung");
		System.out.println(offer);
		
		if (offerDao.delete(offer.getId())) {
			System.out.println("object is deleted successfully");
		} else
			System.out.println("object delete failed");
		
		context.close();
	}

}
