package bigcommer.apidemo.adapter.out.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import bigcommer.apidemo.adapter.out.dto.response.data.TaxCreatingPropertiesResponseData;
import lombok.Data;

@Data
public class TaxCreatingPropertiesResponseDto {
	@JsonProperty("data")
	private List<TaxCreatingPropertiesResponseData> taxCreatingPropertiesResponseDtos;
}
