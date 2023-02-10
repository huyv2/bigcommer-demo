package bigcommer.apidemo.adapter.in.api.dto.response.tax;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import bigcommer.apidemo.adapter.in.api.dto.response.tax.data.TaxCreatingResponseData;
import lombok.Data;

@Data
public class TaxCreatingResponseDto {
	@JsonProperty("tax_creating_response_dtos")
	private List<TaxCreatingResponseData> taxCreatingResponseDtos = new ArrayList<>();
}
