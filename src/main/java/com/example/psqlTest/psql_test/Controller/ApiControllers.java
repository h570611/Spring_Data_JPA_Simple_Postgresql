package com.example.psqlTest.psql_test.Controller;


import com.example.psqlTest.psql_test.Models.Category;
import com.example.psqlTest.psql_test.Models.Metadata;
import com.example.psqlTest.psql_test.Repo.CategoryRepo;
import com.example.psqlTest.psql_test.Repo.MetadataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private MetadataRepo metadataRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    // METADATA -------------------------------------------------------

    @GetMapping(value = "/")
    public String getPage(){ return "Welcome to metadata repository!";}

    @GetMapping(value = "/metadata")
    public List<Metadata> getMetadata(){
        return metadataRepo.findAll();
    }

    @PostMapping(value = "/metadata/create")
    public String createMetadata(@RequestBody Metadata metadata){
        if(metadata.getAlias() != null && metadata.getDescription() != null && metadata.getName() != null &&  metadata.getCategory() != null){
            metadataRepo.save(metadata);
            return "Saved..";
        }else {
            String errorMsg = "ERROR - ";
            if(metadata.getCategory() == null){
                errorMsg += "Category is null";
            }
            return errorMsg;
        }
    }

    @DeleteMapping(value = "/metadata/delete/{id}")
    public String deleteMetadata(@PathVariable long id){
        Metadata deleteMetadata = metadataRepo.findById(id).get();
        metadataRepo.delete(deleteMetadata);
        return "Deleted metadata with id " + id;
    }

    @DeleteMapping(value = "/metadata/deleteAll")
    public String deleteAllMetadata(){
        long count = metadataRepo.count();
        metadataRepo.deleteAll();

        return "Deleted all metdata rows. Count : " + count;
    }


    // CATEGORY -------------------------------------------------------

    @GetMapping(value = "/category")
    public List<Category> getCategories(){
        return categoryRepo.findAll();
    }

    @PostMapping(value = "/category/create")
    public String createCategory(@RequestBody Category category){
        if(category.getName() != null){
            categoryRepo.save(category);
            return "Saved..";
        }else {
            return "Could not save category.. Invalid input.";
        }
    }

    @DeleteMapping(value = "/category/delete/{id}")
    public String deleteCategory(@PathVariable long id){
        Category deleteCategory = categoryRepo.findById(id).get();
        categoryRepo.delete(deleteCategory);
        return "Deleted category with id " + id;
    }

    @DeleteMapping(value = "/category/deleteAll")
    public String deleteAllCategory(){
        long count = categoryRepo.count();
        categoryRepo.deleteAll();

        return "Deleted all category rows. Count : " + count;
    }


}
