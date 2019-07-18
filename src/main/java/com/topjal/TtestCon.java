package com.topjal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/")
@CrossOrigin(value = "*")
public class TtestCon {

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping(value = "list")
    public ResponseEntity<Iterable<Category>> getCatList(){
        List<Category> list = this.categoryRepo.findAll();;
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Category> getCatByid(@PathVariable Long id){

        return new ResponseEntity<>(this.categoryRepo.getOne(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delCategory(@PathVariable("id") Long id){
       this.categoryRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "save")
    public ResponseEntity<?> saveCategory(@RequestBody Category category){
        this.categoryRepo.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping(value = "update/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Long id){
        this.categoryRepo.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
