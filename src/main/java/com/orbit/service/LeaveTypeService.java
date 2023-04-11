package com.orbit.service;

import com.orbit.mapper.DtoMapper;
import com.orbit.mapper.EntityMapper;
import com.orbit.service.dto.models.LeaveType;
import com.orbit.repository.LeaveTypeRepository;
import com.orbit.service.dto.request.LeaveTypeRequest;
import com.orbit.service.dto.response.LeaveTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveTypeService {
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @Autowired
    private EntityMapper entityMapper;

    @Autowired
    private DtoMapper dtoMapper;

    public LeaveTypeRequest save(LeaveTypeRequest leaveTypeRequest) {
        return entityMapper.toLeaveTypeDto(leaveTypeRepository.save(dtoMapper.toLeaveTypeEntity(leaveTypeRequest)));
    }

    public LeaveTypeResponse findLeaveTypeById(Long leaveTypeId) {
        try
        {
            LeaveType leaveType = leaveTypeRepository.findById(leaveTypeId).get();
            return new LeaveTypeResponse(HttpStatus.OK, entityMapper.toLeaveTypeDto(leaveType));
        }
        catch (Exception ex)
        {
            return new LeaveTypeResponse(HttpStatus.NOT_FOUND);
        }
    }

    public List<LeaveTypeRequest> findAllLeaveType() {
        return entityMapper.toLeaveTypeDtoList(leaveTypeRepository.findAll());
    }

    public LeaveTypeResponse deleteLeaveType(Long leaveTypeId) {
        try
        {
            LeaveType leaveType = leaveTypeRepository.findById(leaveTypeId).get();
            leaveTypeRepository.delete(leaveType);
            return new LeaveTypeResponse(HttpStatus.OK, entityMapper.toLeaveTypeDto(leaveType));
        }
        catch (Exception ex)
        {
            return new LeaveTypeResponse(HttpStatus.NOT_FOUND);
        }
    }

    public LeaveTypeResponse update(Long leaveTypeId, LeaveTypeRequest leaveTypeRequest) {
        Optional<LeaveType> leaveToUpdate = leaveTypeRepository.findById(leaveTypeId);
        if(leaveToUpdate.isPresent())
        {
            LeaveType updatedLeaveType = leaveToUpdate.get();
            updatedLeaveType.setLeaveType(leaveTypeRequest.getLeaveType());
            updatedLeaveType.setNumOfLeaves(leaveTypeRequest.getNumOfLeaves());
            return new LeaveTypeResponse(HttpStatus.OK, entityMapper.toLeaveTypeDto(leaveTypeRepository.save(dtoMapper.toLeaveTypeEntity(leaveTypeRequest))));
        }

        return new LeaveTypeResponse(HttpStatus.NOT_FOUND);
    }


}
