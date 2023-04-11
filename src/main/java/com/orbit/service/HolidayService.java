package com.orbit.service;

import com.orbit.service.dto.request.HolidayRequest;
import com.orbit.mapper.DtoMapper;
import com.orbit.mapper.EntityMapper;
import com.orbit.service.dto.models.Holiday;
import com.orbit.repository.HolidayRepository;
import com.orbit.service.dto.response.HolidayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class HolidayService {
    @Autowired
    private HolidayRepository holidayRepository;

    @Autowired
    private EntityMapper entityMapper;
    @Autowired
    private DtoMapper dtoMapper;

    public HolidayRequest save(HolidayRequest holidayRequest) {
        return entityMapper.toHolidayDto(holidayRepository.save(dtoMapper.toHolidayEntity(holidayRequest)));
    }

    public HolidayResponse findHolidayById(Long holidayId) {
        Optional<Holiday> holiday = holidayRepository.findById(holidayId);
        if(holiday.isEmpty())
        {
            return new HolidayResponse(HttpStatus.NOT_FOUND);
        }
        else
        {
            return new HolidayResponse(HttpStatus.OK, entityMapper.toHolidayDto(holiday.get()));
        }

    }

    public List<HolidayRequest> findAllHoliday() {
        return entityMapper.toHolidayDtoList(holidayRepository.findAll());
    }

    public HolidayResponse deleteHolidayById(Long holidayId) {
        Optional<Holiday> holiday = holidayRepository.findById(holidayId);
        Map<String, Boolean> response = new HashMap<>();
        if(holiday.isPresent())
        {
            holidayRepository.delete(holiday.get());
            return new HolidayResponse(HttpStatus.OK, entityMapper.toHolidayDto(holiday.get()));
        }
        else
        {
            return new HolidayResponse(HttpStatus.NOT_FOUND);
        }
    }

    public HolidayResponse updateHoliday(Long holidayId, HolidayRequest holidayRequest) {
        Optional<Holiday> holidayToUpdate = holidayRepository.findById(holidayId);
        if(holidayToUpdate.isPresent())
        {
            Holiday updatedHoliday = holidayToUpdate.get();
            updatedHoliday.setDate(holidayRequest.getDate());
            updatedHoliday.setDescription(holidayRequest.getDescription());
            updatedHoliday.setRegion(holidayRequest.getRegion());
            updatedHoliday.setCountry(holidayRequest.getCountry());

            return new HolidayResponse(HttpStatus.OK, entityMapper.toHolidayDto(holidayRepository.save(updatedHoliday)));
        }

        return new HolidayResponse(HttpStatus.NOT_FOUND);
    }

}
