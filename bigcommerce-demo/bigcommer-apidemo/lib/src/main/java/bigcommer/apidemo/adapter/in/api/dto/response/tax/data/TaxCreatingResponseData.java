package bigcommer.apidemo.adapter.in.api.dto.response.tax.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TaxCreatingResponseData {
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
