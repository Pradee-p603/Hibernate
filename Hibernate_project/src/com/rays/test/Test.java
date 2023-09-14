package com.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.dto.UserDTO;
import com.rays.model.UserModel;

public class Test {
	public static void main(String[] args) throws Exception {

		// testadd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		// testauthenticate();
		testSearch();

	}

	private static void testSearch() throws ParseException {

		UserModel model = new UserModel();

		UserDTO dto = new UserDTO();
		SimpleDateFormat  sdf = new SimpleDateFormat("dd-MM-yyyy");
	    dto.setDob(sdf.parse("2023-09-11"));
		
	//	dto.setDob(new Date());
		List list = model.search(dto ,0,5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getId());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println(dto.getAddress());

		}
	}

	private static void testauthenticate() {

		UserModel model = new UserModel();
		UserDTO dto = model.authenticate("Shivanshi@gmail.com", "Pass@123");
		if (dto != null) {
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getId());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());

		} else {
			System.out.println("user not found....!!!!!!");
		}

	}

	private static void testFindByPk() {

		UserModel model = new UserModel();

		UserDTO dto = model.FindByPk(1);

		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());
		System.out.println(dto.getDob());

	}

	private static void testDelete() {
		UserDTO DTO = new UserDTO();
		DTO.setId(7);
		UserModel model = new UserModel();
		model.Delete(DTO);

	}

	private static void testUpdate() {

		UserDTO DTO = new UserDTO();

		DTO.setId(2);
		DTO.setFirstName("Rajkumar");
		DTO.setLastName("Meena");
		DTO.setLoginId("rajkumar@gmail.com");
		DTO.setPassword("Pass@123");
		DTO.setAddress("Sehore");
		DTO.setDob(new Date());

		UserModel model = new UserModel();
		model.Update(DTO);

	}

	private static void testadd() throws Exception {
		UserDTO DTO = new UserDTO();
		SimpleDateFormat  sdf = new SimpleDateFormat("dd-MM-yyyy");
	    DTO.setDob(sdf.parse("12-12-1947"));
		// DTO.setId(1);
		DTO.setFirstName("Rajkumar");
		DTO.setLastName("Meena");
		DTO.setLoginId("rajkumar@gmail.com");
		DTO.setPassword("Pass@123");
		DTO.setAddress("Sehore");
		//DTO.setDob(new Date());

		UserModel model = new UserModel();
		model.add(DTO);

	}

}
