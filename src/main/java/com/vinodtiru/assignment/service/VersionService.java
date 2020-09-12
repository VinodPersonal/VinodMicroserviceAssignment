package com.vinodtiru.assignment.service;

import com.vinodtiru.assignment.model.Version;
import com.vinodtiru.assignment.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionService {

    @Autowired
    private VersionRepository repository;

    public Version saveVersion(Version version) { return repository.save(version);}

    public List<Version> saveVersions(List<Version> version) {
        return repository.saveAll(version);
    }

    public List<Version> getVersions() {
        return repository.findAll();
    }

    public Page<Version> getVersionsByPage(int pageNo) {
        Pageable firstPageWithTwoElements = PageRequest.of(pageNo, 5);
        return repository.findAll(firstPageWithTwoElements);
    }

    public Version getVersionById(int id) {
        return repository.findById(id)
                .orElse(null);
    }

    public int compareVersion(int id, String newVersion) {
        return repository.findById(id).orElse(null).compareTo(new Version(0,newVersion));
    }

    public String deleteVersion(int id) {
        repository.deleteById(id);
        return "Version removed !! " + id;
    }

    public Version updateVersion(Integer id, Version version) {
        Version existingProduct = repository.findById(id).orElse(null);
        existingProduct.setVersionNumber(version.getVersionNumber());
        return repository.save(existingProduct);
    }

}
