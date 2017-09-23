package com.geeklib.tango.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

@Controller
public class HelloworldController
{

	@ResponseBody
	@RequestMapping(value = "/hello", produces = "text/json")
	public String sayHello()
	{
		System.out.println("hello world");

		Address address = new Address();
		address.setCity("连云港");
		address.setCountry("中国");
		address.setProvince("江苏");
		address.setAddress(null);

		Address address2 = new Address();
		address2.setCity("南京");
		address2.setCountry("中国");
		address2.setProvince("江苏");
		address2.setAddress(address);

		Person person = new Person();
		person.setName("hunima");
		person.setAge(19);
		person.setAddress(address2);

		Gson gson = new Gson();
		String user = gson.toJson(person);

		return user;
	}

	@RequestMapping("/helloworld")
	public String model()
	{
		return "hello";
	}

	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public String fileupload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.isEmpty());

		if (1024 * 100 < file.getSize())
		{
			throw new IOException("文件体积不能大于1MB");
		}

		String absolutePath = request.getRealPath("tmp/upload");

		File savefile = new File(absolutePath + "\\" + file.getOriginalFilename());

		try (OutputStream outputStream = new FileOutputStream(savefile))
		{
			outputStream.write(file.getBytes());
		}
		catch (IOException e)
		{
		}

		return "redirect:/index.jsp";

	}
	
	@RequestMapping(value="/test")
	public void test(HttpSession session){
		
		String username = UUID.randomUUID().toString();
		String userid = UUID.randomUUID().toString();
		
		Person person = new Person();
		person.setName(username);
		person.setAge((int)(Math.random() * 100));
		Address address = new Address();
		address.setCity(UUID.randomUUID().toString());
		address.setCountry(UUID.randomUUID().toString());
		address.setProvince(UUID.randomUUID().toString());
		person.setAddress(address);
		session.setAttribute("currentUser", person);
		System.out.println("========");
		System.out.println("空闲内存：" + (Runtime.getRuntime().freeMemory() / 1024 / 1024));
		System.out.println("总内存：" + (Runtime.getRuntime().totalMemory() / 1024 / 1024));
		System.out.println("最大内存：" + (Runtime.getRuntime().maxMemory() / 1024 / 1024));
		
	}
}

class Person
{
	private String name;
	private int age;
	private Address address;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

}

class Address
{
	private String country;
	private String province;
	private String city;
	private Address address;

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

}