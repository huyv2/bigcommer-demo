package bigcommer.apidemo.adapter.in.api.dto.request.tax;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import bigcommer.apidemo.adapter.in.api.dto.request.tax.data.TaxCreatingRequestData;
import lombok.Data;

@Data
public class TaxCreatingRequestDto {
	@JsonProperty("tax_creating_request_dtos")
	private List<TaxCreatingRequestData> taxCreatingRequestDtos;
}
