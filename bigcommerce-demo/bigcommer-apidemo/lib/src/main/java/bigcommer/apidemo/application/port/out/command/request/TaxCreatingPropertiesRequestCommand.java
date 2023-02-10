package bigcommer.apidemo.application.port.out.command.request;

import java.util.ArrayList;
import java.util.List;

import bigcommer.apidemo.application.port.out.command.request.data.TaxCreatingPropertiesRequestData;

public class TaxCreatingPropertiesRequestCommand {
	private List<TaxCreatingPropertiesRequestData> taxCreatingPropertiesCommandList = new ArrayList<>();

	public List<TaxCreatingPropertiesRequestData> getTaxCreatingPropertiesCommandList() {
		return taxCreatingPropertiesCommandList;
	}
	public void setTaxCreatingPropertiesCommandList(
			List<TaxCreatingPropertiesRequestData> taxCreatingPropertiesCommandList) {
		this.taxCreatingPropertiesCommandList = taxCreatingPropertiesCommandList;
	}
}
