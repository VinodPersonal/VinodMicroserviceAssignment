package com.vinodtiru.assignment.contoller;

import com.vinodtiru.assignment.model.Version;
import com.vinodtiru.assignment.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/versions")
public class VersionController {

    @Autowired
    private VersionService service;

    @PostMapping
    @PreAuthorize("hasAuthority('version:write')")
    public Version addVersion(@Valid @RequestBody Version version) {
        return service.saveVersion(version);
    }

    @GetMapping
    public List<Version> findAllVersions() {
        return service.getVersions();
    }

    @GetMapping(path = "page/{pageno}")
    public Page<Version> findAllVersionsByPage(@PathVariable("pageno") Integer pageno) {
        return service.getVersionsByPage(pageno);
    }

    @GetMapping(path = "{id}")
    public Version findVersionById(@PathVariable("id") Integer id) {
        return service.getVersionById(id);
    }

    @GetMapping(path = "{id}/compare/{newVersion}")
    public String compareVersion(@PathVariable("id") Integer id, @PathVariable("newVersion") String newVersion) {
        int diff = service.compareVersion(id, newVersion);
        String retVal = "";
        if(diff == 0){
            retVal = "This is new version " + newVersion + " is same as " +  service.getVersionById(id).getVersionNumber() ;
        } else if(diff > 0){
            retVal = "This is new version " + newVersion + " is greater than " +  service.getVersionById(id).getVersionNumber() ;
        } else if(diff < 0){
            retVal = "This is new version " + newVersion + " is lower than " +  service.getVersionById(id).getVersionNumber() ;
        }
        return retVal;
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasAuthority('version:write')")
    public Version updateVersion(@Valid @PathVariable("id") Integer id, @RequestBody Version version) {
        return service.updateVersion(id, version);
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasAuthority('version:delete')")
    public String deleteVersion(@PathVariable("id") Integer id) {
        return service.deleteVersion(id);
    }



}

