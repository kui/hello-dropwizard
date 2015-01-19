package kui.hello.dw;

import org.hibernate.validator.constraints.NotEmpty;

import io.dropwizard.Configuration;

// 設定項目など
public class Config extends Configuration {
	@NotEmpty
	private String name = "Dropwizard";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
