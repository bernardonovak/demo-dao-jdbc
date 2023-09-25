package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
		
			DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
			
			System.out.println("=== TESTE 1: department findById");
			Department department = departmentDao.findById(1);
			System.out.println(department);
			
			System.out.println();
			System.out.println("=== TESTE 2: department findAll");
			List<Department> list = departmentDao.findAll();
			list.forEach(System.out::println);
			
			System.out.println();
			System.out.println("=== TESTE 3: department insert");
			Department dep = new Department(null, "Teste");
			departmentDao.insert(dep);
			System.out.println("Department inserted! New id is " + dep.getId());
			
			System.out.println();
			System.out.println("=== TESTE 4: department update");
			System.out.println("Enter Id Department for update: ");
			Department depUpdate = departmentDao.findById(sc.nextInt());
			if(depUpdate instanceof Department) {
				System.out.println("Enter name Updated: ");
				depUpdate.setName(sc.next());
				departmentDao.update(depUpdate);
				System.out.println("Update completed!");
			}
			
			System.out.println();
			System.out.println("=== TESTE 5: department delete");
			System.out.println("Enter Id Department for delete: ");
			departmentDao.deleteById(sc.nextInt());
			System.out.println("Delete sucess!");
			
		} finally {
			sc.close();
			DB.closeConnection();
		}
		
		
	}

}
