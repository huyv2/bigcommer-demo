package bigcommer.apidemo.application.port.in.command.response.tax;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import bigcommer.apidemo.application.port.in.command.response.tax.data.TaxCreatingResponseData;
import lombok.Data;

@Data
public class TaxCreatingResponseCommand {
	@JsonProperty("tax_creating_response_command_list")
	private List<TaxCreatingResponseData> taxCreatingResponseCommandList = new ArrayList<>();
}
