package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: seler findById");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("=== TESTE 2: seler findByDepartment");
		Department department = new Department(2, null);
		List<Seller> listSeller = sellerDao.findByDepartment(department);
		
		listSeller.forEach(System.out::println);
		
	}

}
