package com.programozzteis.cardealer.cardealer.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public class AdminController {

    private IAdminRepository adminrepo;

    public AdminController(IAdminRepository adminrepo) {
        this.adminrepo = adminrepo;
    }


    @GetMapping ("/admin/{adminId}")
    public String showAd (
            @PathVariable(name = "adminId") int adminId,
            Map<String, Object> model)
    {

        /** Admin */
        Admin admin = this.adminrepo.findById(adminId);
        model.put("admins", admin);

        return "admins/adminDetails";
    }
}
