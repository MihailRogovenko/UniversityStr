package com.tpp.UniversityStr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpp.UniversityStr.models.Groups;
import com.tpp.UniversityStr.repository.GroupsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupsRepository groupsRepository;


    public List<Groups> getAllGroups() {
        return groupsRepository.findAll();
    }

    public Optional<Groups> findGroupById(Integer id) {
        return groupsRepository.findById(id);
    }

    public void saveGroup(Groups group) {
        groupsRepository.save(group);
    }

    public void updateGroup(Groups updatedGroup) {
        Optional<Groups> existingGroupOpt = groupsRepository.findById(updatedGroup.getGroupId());
        if (existingGroupOpt.isPresent()) {
            Groups existingGroup = existingGroupOpt.get();
            existingGroup.setName(updatedGroup.getName());
            existingGroup.setDepartment(updatedGroup.getDepartment());
            existingGroup.setCurator(updatedGroup.getCurator());
            groupsRepository.save(existingGroup);
        }
    }

    public void deleteGroupById(Integer id) {
        groupsRepository.deleteById(id);
    }
}
