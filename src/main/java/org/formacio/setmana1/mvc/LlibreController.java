package org.formacio.setmana1.mvc;

import org.formacio.setmana1.data.LlibreOpsBasic;
import org.formacio.setmana1.domini.Recomanacio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LlibreController {

	@Autowired
	private LlibreOpsBasic llibreBean;

	@RequestMapping(path="/recomanacio")
	@ResponseBody
 	public Recomanacio obteLlibre (String isbn) {
		return llibreBean.recomenacioPer(isbn); 
	}
}
