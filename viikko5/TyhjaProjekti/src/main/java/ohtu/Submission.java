package ohtu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Submission {
	
	private Long id;
	private String student_number;
	private String last_name;
	private String first_name;
	private int week;
	private Integer points;
	private String identifier;
	private Integer hours;
	private String comments;
	private String email;
	private Boolean a1;
	private Boolean a2;
	private Boolean a3;
	private Boolean a4;
	private Boolean a5;
	private Boolean a6;
	private Boolean a7;
	private Boolean a8;
	private Boolean a9;
	private Boolean a10;
	private Boolean a11;
	private Boolean a12;
	private Boolean a13;
	private Boolean a14;
	private Boolean a15;
	private Boolean a16;
	private Boolean a17;
	private Boolean a18;
	private Boolean a19;
	private Boolean a20;
	private Boolean a21;
	private Date created_at;
	private Date updated_at;
	private Long course_id;
	private String github;
	private Long student_id;
	
	@Override
	public String toString() {
		Integer[] dones = getTasksDone();
		return 
				"viikko " + getWeek() + 
				": tehtyjä tehtäviä yhteensä: " + dones.length + 
				", aikaa kului " + getHours() + " tuntia, tehdyt tehtävät: " + 
				Arrays.toString(dones);
	}
	
	public Integer[] getTasksDone() {
		List<Integer> dones = new ArrayList<Integer>();
		for (int i = 1; i <= 21; i++) {
			try {
				Method method = this.getClass().getMethod("getA" + i);
				if (method == null) {
					continue;
				}
				Object out = method.invoke(this);
				if (out != null && (Boolean) out) {
					dones.add(i);
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return dones.toArray(new Integer[0]);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudent_number() {
		return student_number;
	}
	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getA1() {
		return a1;
	}
	public void setA1(Boolean a1) {
		this.a1 = a1;
	}
	public Boolean getA2() {
		return a2;
	}
	public void setA2(Boolean a2) {
		this.a2 = a2;
	}
	public Boolean getA3() {
		return a3;
	}
	public void setA3(Boolean a3) {
		this.a3 = a3;
	}
	public Boolean getA4() {
		return a4;
	}
	public void setA4(Boolean a4) {
		this.a4 = a4;
	}
	public Boolean getA5() {
		return a5;
	}
	public void setA5(Boolean a5) {
		this.a5 = a5;
	}
	public Boolean getA6() {
		return a6;
	}
	public void setA6(Boolean a6) {
		this.a6 = a6;
	}
	public Boolean getA7() {
		return a7;
	}
	public void setA7(Boolean a7) {
		this.a7 = a7;
	}
	public Boolean getA8() {
		return a8;
	}
	public void setA8(Boolean a8) {
		this.a8 = a8;
	}
	public Boolean getA9() {
		return a9;
	}
	public void setA9(Boolean a9) {
		this.a9 = a9;
	}
	public Boolean getA10() {
		return a10;
	}
	public void setA10(Boolean a10) {
		this.a10 = a10;
	}
	public Boolean getA11() {
		return a11;
	}
	public void setA11(Boolean a11) {
		this.a11 = a11;
	}
	public Boolean getA12() {
		return a12;
	}
	public void setA12(Boolean a12) {
		this.a12 = a12;
	}
	public Boolean getA13() {
		return a13;
	}
	public void setA13(Boolean a13) {
		this.a13 = a13;
	}
	public Boolean getA14() {
		return a14;
	}
	public void setA14(Boolean a14) {
		this.a14 = a14;
	}
	public Boolean getA15() {
		return a15;
	}
	public void setA15(Boolean a15) {
		this.a15 = a15;
	}
	public Boolean getA16() {
		return a16;
	}
	public void setA16(Boolean a16) {
		this.a16 = a16;
	}
	public Boolean getA17() {
		return a17;
	}
	public void setA17(Boolean a17) {
		this.a17 = a17;
	}
	public Boolean getA18() {
		return a18;
	}
	public void setA18(Boolean a18) {
		this.a18 = a18;
	}
	public Boolean getA19() {
		return a19;
	}
	public void setA19(Boolean a19) {
		this.a19 = a19;
	}
	public Boolean getA20() {
		return a20;
	}
	public void setA20(Boolean a20) {
		this.a20 = a20;
	}
	public Boolean getA21() {
		return a21;
	}
	public void setA21(Boolean a21) {
		this.a21 = a21;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
    
}