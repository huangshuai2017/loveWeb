package com.pactera.spring.model;

import java.io.Serializable;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Emp implements Cloneable,Serializable{
	private int id;
	private String name;
	private String gender;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  Emp clone() throws CloneNotSupportedException{
		return (Emp) super.clone();
	}

	@Override
	public String toString() {
		return "Emp{" +
				"id=" + id +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				'}';
	}

	public static void main(String[] args) {

		Map<String,Integer> map = Stream.of(
				new Info(1,"aaa"),
				new Info(2,"bbb"),
				new Info(3,"ccc"),
				new Info(4,"ddd"),
				new Info(5,"aaa")
				).collect(Collectors.toMap(Info::getName,Info::getId,(before,after)-> {return after;}));
		System.out.println(map);
	}
	 static class Info{
		private Integer id;
		private String name;

		 public Info(int id, String name) {
			 this.id = id;
			 this.name = name;
		 }

		 public int getId() {
			 return id;
		 }

		 public void setId(int id) {
			 this.id = id;
		 }

		 public String getName() {
			 return name;
		 }

		 public void setName(String name) {
			 this.name = name;
		 }
	 }
}
