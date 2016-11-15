package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Category;
import com.example.model.Device;
import com.example.model.Role;
import com.example.model.TagName;
import com.example.model.TagNameType;
import com.example.model.TagType;
import com.example.model.User;
import com.example.repository.CategoryRepository;
import com.example.repository.DeviceRepository;
import com.example.repository.UserRepository;

@SpringBootApplication
public class OriginApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(OriginApplication.class, args);
	}

	@PostConstruct
	public void deneme(){
		
		saveusers();
		
		//İnsert Category
		saveCategory();
		
//		Device bilgisayar = new Device();
//		bilgisayar.setName("Bilgisayar");
		
		Device laptop = new Device();
		laptop.setName("Asus t1032323");
		Device pc = new Device();
		pc.setName("pc 2312332");
		
		Device hardDisk = new Device("Toshiba 1TB");
		hardDisk.setBaseDevice(laptop);
		Device ram = new Device("8gb ram");
		ram.setBaseDevice(laptop);
		Device ekranKarti = new Device("2 gb paylasimsiz");
		ekranKarti.setBaseDevice(laptop);
		
		
//		laptop.setBaseDevice(bilgisayar);
//		pc.setBaseDevice(bilgisayar);
		
		Set<Device> devices = new HashSet<Device>();
		devices.add(pc);
		devices.add(laptop);
		devices.add(ekranKarti);
		devices.add(ram);
		devices.add(hardDisk);
		
		TagName nameHp = new TagName();
		nameHp.setName("HP");
		TagName nameLg = new TagName();
		nameLg.setName("LG");
		TagType type = new TagType();
		type.setName("Marka");
		TagNameType typeBrand = new TagNameType();
		typeBrand.setTagName(nameHp);
		typeBrand.setTagType(type);
		TagNameType typeBrand2 = new TagNameType();
		typeBrand2.setTagType(type);
		typeBrand2.setTagName(nameLg);
//		List<TagNameType> tagNameTypes = new ArrayList<TagNameType>();
//		tagNameTypes.add(typeBrand);
//		tagNameTypes.add(typeBrand2);
		
		laptop.setTagNameType(typeBrand);
//		typeBrandRepository.save(typeBrands);		
		
		deviceRepository.save(devices);
		
	}

	private void saveCategory() {
		Category base = new Category("Elektronik");
		
		Category bilgisayar = new Category("Bilgisayar");
		bilgisayar.setBaseCategory(base);
		Category notebook = new Category("Notbook");
		notebook.setBaseCategory(bilgisayar);
		Category masaustu = new Category("Masaüstü");
		masaustu.setBaseCategory(bilgisayar);
		List<Category> categories = new ArrayList<Category>();
		categories.add(base);
		categories.add(bilgisayar);
		categories.add(notebook);
		categories.add(masaustu);
		categoryRepository.save(categories);
	}

	private void saveusers() {
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		
		Role roleTech = new Role();
		roleTech.setName("ROLE_TECH");
		
		
		User kullanici = new User();
		kullanici.setUsername("serdar");
		kullanici.setPassword("serdar");
		kullanici.getRoles().add(roleUser);
		
		User tech = new User();
		tech.setUsername("caglar");
		tech.setPassword("caglar");
		tech.getRoles().add(roleTech);
		
		User admin = new User();
		admin.setUsername("cuma");
		admin.setPassword("cuma");
		admin.getRoles().add(roleAdmin);
		
		List<User> users = new ArrayList<User>();
		users.add(tech);
		users.add(admin);
		users.add(kullanici);
		
		userRepository.save(users);
	}
}
