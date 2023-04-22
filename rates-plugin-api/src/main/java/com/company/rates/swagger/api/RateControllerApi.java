/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.company.rates.swagger.api;

import com.company.rates.swagger.model.CurrencyRate;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@Validated
@Api(value = "RateController", description = "the RateController API")
public interface RateControllerApi {

    @ApiOperation(value = "", nickname = "getCharCodes", notes = "", response = String.class, responseContainer = "List", tags={ "rate-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class, responseContainer = "List") })
    @RequestMapping(value = "/rates/charCodes",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<List<String>> getCharCodes();


    @ApiOperation(value = "", nickname = "getRateByCharCode", notes = "", response = CurrencyRate.class, tags={ "rate-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = CurrencyRate.class) })
    @RequestMapping(value = "/rates/{charCode}",
        produces = "*/*", 
        method = RequestMethod.GET)
    ResponseEntity<CurrencyRate> getRateByCharCode(@ApiParam(value = "", required=true) @PathVariable("charCode") String charCode);

}

