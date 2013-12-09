package com.james.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestCollection {
	public static void main(String[] args) {
//		testTreeSet();
//		testTreeMap();
		testMap();
	}

	private static void testTreeMap() {
		TreeMap<Integer, Student> treeMap = new TreeMap<Integer, Student>();
		treeMap.put(1, new Student(1, "james"));
		treeMap.put(3, new Student(1, "james"));
		treeMap.put(2, new Student(1, "james"));
		treeMap.put(1, new Student(1, "james"));
		treeMap.put(1, new Student(1, "james"));
		//--------遍历TreeMap的方式一
		Iterator<Integer> it = treeMap.keySet().iterator();
		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			Student student = (Student)treeMap.get(key);
			System.out.println(key + ":"+ student);
		}
		//--------遍历TreeMap的方式二
		/*Set<Entry<Integer, Student>> set = treeMap.entrySet();
		Iterator<Entry<Integer, Student>> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry<java.lang.Integer, com.james.utils.Student> entry = (Map.Entry<java.lang.Integer, com.james.utils.Student>) it.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}*/
	}
	
	private static void testMap() {
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		map.put(2, new Student(1, "james"));
		map.put(1, new Student(1, "james"));
		map.put(3, null);
		map.put(1, new Student(1, "james"));
		map.put(1, new Student(1, "james"));
		//--------遍历TreeMap的方式一
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			Integer key = (Integer) it.next();
			Student student = (Student)map.get(key);
			System.out.println(key + ":"+ student);
		}
		System.out.println("===============================");
		//--------遍历TreeMap的方式二
		Set<Entry<Integer, Student>> set = map.entrySet();
		Iterator<Entry<Integer, Student>> it1 = set.iterator();
		while (it1.hasNext()) {
			Map.Entry<Integer, Student> entry = (Map.Entry<Integer, Student>) it1.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

	private static void testTreeSet() {
		TreeSet<Student> treeSet = new TreeSet<Student>();
		treeSet.add(new Student(1, "aaa"));
		treeSet.add(new Student(3, "ccc"));
		treeSet.add(new Student(2, "aaa"));
		treeSet.add(new Student(5, "aaa"));
		treeSet.add(new Student(4, "bbb"));
		Iterator<Student> it = treeSet.iterator();
		while (it.hasNext()) {
			Student student = (Student) it.next();
			System.out.println(student);
		}
	}
}

class Student implements Comparable<Student>{

	private Integer id;
	private String name;

	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student o) {
		Student s = (Student)o;
		int ret = this.id > s.id ? 1:(this.id == s.id ? 0:-1);
		if (ret == 0) {
			name.compareTo(s.name);
		}
		return ret;
	}
}
