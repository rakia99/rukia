package com.example.Ask;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Service
public class StaffService {
    private final Map<Long, Staff> staffMap = new HashMap<>();
    private Long idCounter = 1L;

    public ArrayList<Staff> getAllStaffs() {
        return new ArrayList<>(staffMap.values());
    }

    public Staff getStaffById(Long id) {
        return staffMap.get(id);
    }

    public Staff createStaff(Staff staff) {
        staff.setId(idCounter++);
        staffMap.put(staff.getId(), staff);
        return staff;
    }

    public Staff updateStaff(Long id, Staff updatedStaff) {
        updatedStaff.setId(id);
        staffMap.put(id, updatedStaff);
        return updatedStaff;
    }

    public void deleteStaff(Long id) {
        staffMap.remove(id);
    }
}