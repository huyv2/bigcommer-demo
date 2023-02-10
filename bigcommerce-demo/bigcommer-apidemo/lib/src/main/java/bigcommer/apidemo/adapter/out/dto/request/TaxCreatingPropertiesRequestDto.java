package bigcommer.apidemo.adapter.out.dto.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import bigcommer.apidemo.adapter.out.dto.request.data.TaxCreatingPropertiesRequestData;
import lombok.Data;

@Data
public class TaxCreatingPropertiesRequestDto {
	@JsonProperty("tax_creating_properties_request_dtos")
	private List<TaxCreatingPropertiesRequestData> taxCreatingPropertiesRequestDtos = new ArrayList<>();
}
