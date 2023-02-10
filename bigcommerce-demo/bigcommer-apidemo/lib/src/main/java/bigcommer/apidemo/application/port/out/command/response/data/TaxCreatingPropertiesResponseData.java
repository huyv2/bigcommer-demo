package bigcommer.apidemo.application.port.out.command.response.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TaxCreatingPropertiesResponseData {
	@JsonProperty("id")
	private int id;
	@JsonProperty("code")
	private String code;
	@JsonProperty("display_name")
	private String displayName;
	@JsonProperty("description")
	private String description;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
}
