package bigcommer.apidemo.adapter.in.api.tax;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bigcommer.apidemo.adapter.in.api.dto.request.tax.TaxCreatingRequestDto;
import bigcommer.apidemo.adapter.in.api.dto.response.tax.TaxCreatingResponseDto;
import bigcommer.apidemo.adapter.in.api.dto.response.tax.data.TaxCreatingResponseData;
import bigcommer.apidemo.application.port.in.command.request.tax.TaxCreatingRequestCommand;
import bigcommer.apidemo.application.port.in.command.request.tax.data.TaxCreatingRequestData;
import bigcommer.apidemo.application.port.in.command.response.tax.TaxCreatingResponseCommand;
import bigcommer.apidemo.application.port.in.tax.TaxCreatingUseCase;
import lombok.RequiredArgsConstructor;

//@Tag(name = "TaxCreatingApi", description = "Api description for TaxCreatingApi")
@CrossOrigin
@RestController
//@RequestMapping("/tax")
@RequiredArgsConstructor
public class TaxCreatingApi {
	private final TaxCreatingUseCase taxCreatingUseCase;
	
	/*@Operation(method = "post", description = "Create tax for ecom")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "get roles success"),
		@ApiResponse(responseCode = "403", description = "do not have correct authorization")
	})*/
	@PostMapping(value = "/tax/creating") // = @RequestMapping + method
	public TaxCreatingResponseDto createTaxFromEcom(@RequestBody TaxCreatingRequestDto taxRequestDto) {
		TaxCreatingResponseDto taxCreatingResponseDto = new TaxCreatingResponseDto();
		
		TaxCreatingRequestCommand taxCreatingRequestCommand = new TaxCreatingRequestCommand();
		for(bigcommer.apidemo.adapter.in.api.dto.request.tax.data.TaxCreatingRequestData taxCreatingRequestDataDto
				: taxRequestDto.getTaxCreatingRequestDtos()) {
			TaxCreatingRequestData taxCreatingRequestData = new TaxCreatingRequestData();
			taxCreatingRequestData.setDisplayName(taxCreatingRequestDataDto.getDisplayName());
			taxCreatingRequestData.setDescription(taxCreatingRequestDataDto.getDescription());
			taxCreatingRequestData.setPrefixCode(taxCreatingRequestDataDto.getPrefixCode());
			
			taxCreatingRequestCommand.getTaxCreatingRequestCommandList().add(taxCreatingRequestData);
		}
		
		TaxCreatingResponseCommand taxCreatingResponseCommand = taxCreatingUseCase.createTaxProperty(taxCreatingRequestCommand);
		
		for(bigcommer.apidemo.application.port.in.command.response.tax.data.TaxCreatingResponseData taxCreatingResponseData
				: taxCreatingResponseCommand.getTaxCreatingResponseCommandList()) {
			TaxCreatingResponseData taxCreatingResponseDataDto = new TaxCreatingResponseData();
			taxCreatingResponseDataDto.setId(taxCreatingResponseData.getId());
			taxCreatingResponseDataDto.setCode(taxCreatingResponseData.getCode());
			taxCreatingResponseDataDto.setDisplayName(taxCreatingResponseData.getDisplayName());
			taxCreatingResponseDataDto.setDescription(taxCreatingResponseData.getDescription());
			taxCreatingResponseDataDto.setCreatedAt(taxCreatingResponseData.getCreatedAt());
			taxCreatingResponseDataDto.setUpdatedAt(taxCreatingResponseData.getUpdatedAt());
			
			taxCreatingResponseDto.getTaxCreatingResponseDtos().add(taxCreatingResponseDataDto);
		}
		
		return taxCreatingResponseDto;
	}
}
