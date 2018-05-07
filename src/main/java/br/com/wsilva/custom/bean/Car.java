package br.com.wsilva.custom.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("car")
@RequestScoped
public class Car 
{
	private String name;
	private Integer year;
	private Float price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
}
