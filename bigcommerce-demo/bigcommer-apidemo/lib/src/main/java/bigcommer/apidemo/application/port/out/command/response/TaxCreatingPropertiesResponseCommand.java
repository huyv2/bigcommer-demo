package bigcommer.apidemo.application.port.out.command.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import bigcommer.apidemo.application.port.out.command.response.data.TaxCreatingPropertiesResponseData;
import lombok.Data;

@Data
public class TaxCreatingPropertiesResponseCommand {
	@JsonProperty("tax_creating_properties_response_command_list")
	private List<TaxCreatingPropertiesResponseData> taxCreatingPropertiesResponseCommandList = new ArrayList<>();
}
