package com.sodimatel.main.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sodimatel.main.domain.Appareil;
import com.sodimatel.main.domain.Marque;
import com.sodimatel.main.domain.Type;
import com.sodimatel.main.services.ServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SodimatelSpgDataApplicationTests {

	@Autowired
	private ServiceImpl serviceImp;

	@Test
	public void contextLoads() {

		//assertThat(serviceImp).isNotNull();
		//Type t = serviceImp.getTypeBy(5L);
		//assertThat(t).isNotNull();

//		System.out.println(t);
		
		//List<Marque> marques = serviceImp.getAllMarques();
		
		//assertThat(marques).isNotNull();
		
		//Marque marque = serviceImp.getMarqueBy(5L);
		//assertThat(marque).isNotNull();
		
		
		//List<Appareil> appareils = serviceImp.getAllAppareils();
		
	//	System.out.println(appareils);
	}

}
