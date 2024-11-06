package com.roomly.roomly.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.roomly.roomly.service.FileService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/roomly/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload/accommodationMain")
    public String accommodationMainFileUpload(
        @RequestParam("file") MultipartFile file
    ){
        String url = fileService.accommodationMainFileUpload(file);
        return url;
    }

    @PostMapping("/upload/accommodationSub")
    public String accommodationSubFileUpload(
        @RequestParam("file") MultipartFile file
    ){
        String url = fileService.accommodationSubFileUpload(file);
        return url;
    }

    @PostMapping("/upload/roomSub")
    public String roomSubFileUpload(
        @RequestParam("file") MultipartFile file
    ){
        String url = fileService.roomSubFileUpload(file);
        return url;
    }

    @PostMapping("/upload/business")
    public String businessFileUpload(
        @RequestParam("file") MultipartFile file
    ){
        String url = fileService.businessFileUpload(file);
        return url;
    }

    @GetMapping(value="/accommodationMain/{fileName}", produces={MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public Resource getAccommodationMainImage(
        @PathVariable("fileName") String fileName
    ){
        Resource resource = fileService.getAccommodationMainFile(fileName);
        return resource;
    }

    @GetMapping(value="/accommodationSub/{fileName}", produces={MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public Resource getAccommodationSubImage(
        @PathVariable("fileName") String fileName
    ){
        Resource resource = fileService.getAccommodationSubFile(fileName);
        return resource;
    }

    @GetMapping(value="/roomSub/{fileName}", produces={MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public Resource getRoomSubImage(
        @PathVariable("fileName") String fileName
    ){
        Resource resource = fileService.getRoomSubFile(fileName);
        return resource;
    }

    
    @GetMapping(value="/business/{fileName}", produces={MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public Resource getBusinessImage(
        @PathVariable("fileName") String fileName
    ){
        Resource resource = fileService.getBusinessFile(fileName);
        return resource;
    }

    
}