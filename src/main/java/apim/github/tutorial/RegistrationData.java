package apim.github.tutorial;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationData {

	@Size(min = 10, max = 80, message = "{Size.registrationData.fullName}")
	private String fullName;

	@NotNull(message = "{NotNull.registrationData.age}")
	@Min(value = 18, message = "{Min.registrationData.age}")
	@Max(value = 30, message = "{Max.registrationData.age}")
	private Integer age;

	private String address;

	private String sex;

	private String[] classChoices;

	private String campus;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String[] getClassChoices() {
		return classChoices;
	}

	public void setClassChoices(String[] classChoices) {
		this.classChoices = classChoices;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

}
