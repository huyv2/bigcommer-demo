package bigcommer.apidemo.adapter.out.dto.request.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TaxCreatingPropertiesRequestData {
	@JsonProperty("code")
	private String code;
	@JsonProperty("display_name")
	private String displayName;
	@JsonProperty("description")
	private String description;
}
