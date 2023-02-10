package bigcommer.apidemo.adapter.in.api.dto.request.tax.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TaxCreatingRequestData {
	@JsonProperty("prefix_code")
	private String prefixCode;
	@JsonProperty("display_name")
	private String displayName;
	@JsonProperty("description")
	private String description;
}