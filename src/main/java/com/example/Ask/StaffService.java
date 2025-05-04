package com.example.Ask;


import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StaffService {

    private Map<Long, Staff> staffRepo = new HashMap<>();
    private Long currentId = 1L;

    public List<Staff> getAllStaff() {
        return new ArrayList<>(staffRepo.values());
    }

    public Staff getStaffById(Long id) {
        return staffRepo.get(id);
    }

    public Staff createStaff(Staff staff) {
        staff.setId(currentId++);
        staffRepo.put(staff.getId(), staff);
        return staff;
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        Staff existing = staffRepo.get(id);
        if (existing != null) {
            existing.setName(updatedStaff.getName());
            existing.setPosition(updatedStaff.getPosition());
            return existing;
        }
        return null;
    }

    public boolean deleteStaff(Long id) {
        return staffRepo.remove(id) != null;
    }
}
