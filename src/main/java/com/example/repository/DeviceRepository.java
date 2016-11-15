package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}
