package com.orbit.controller;

import com.orbit.constants.APIPaths;
import com.orbit.service.dto.request.HolidayRequest;
import com.orbit.service.dto.response.HolidayResponse;
import com.orbit.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(APIPaths.HOLIDAY_MAPPING)
public class HolidayController {
    @Autowired
    HolidayService holidayService;

    @PostMapping()
    public HolidayRequest createHoliday(@Validated @RequestBody HolidayRequest holidayRequest)
    {
        return holidayService.save(holidayRequest);
    }
    @GetMapping(APIPaths.GET_HOLIDAY)
    public HolidayResponse getHolidayById(@PathVariable(value = "id") Long holidayId)
    {
       return holidayService.findHolidayById(holidayId);
    }

    @GetMapping(APIPaths.ALL_HOLIDAY)
    public List<HolidayRequest> getAllHoliday()
    {
        return holidayService.findAllHoliday();
    }
    @DeleteMapping(APIPaths.DELETE_HOLIDAY)
    public HolidayResponse deleteHoliday(@PathVariable(value = "id") Long holidayId)
    {
     return holidayService.deleteHolidayById(holidayId);
    }
    @PutMapping(APIPaths.UPDATE_HOLIDAY)
    public HolidayResponse updateHoliday(@PathVariable(value = "id") Long holidayId, @Validated @RequestBody HolidayRequest holidayRequest)
    {
      return holidayService.updateHoliday(holidayId, holidayRequest);
    }
}
