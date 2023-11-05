package uni.fmi.Solaris.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.fmi.Solaris.dto.CategoryDTO;
import uni.fmi.Solaris.services.ICategoryService;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping(path = "/category")
public class CategoryRestController {

    private ICategoryService categoryService;

    @Autowired
    private CategoryRestController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<CategoryDTO> list() {
        //categoryService.get(12l);
        return categoryService.getAll();
    }

    @GetMapping(path = "/{categoryId}")
    public CategoryDTO getCategory(@PathVariable(name = "categoryId") long categoryId) {
        return categoryService.getBy(categoryId);
    }

    @PostMapping()
    public CategoryDTO create(@RequestBody CategoryDTO newCategory) {
        return categoryService.create(newCategory);
    }

    @PutMapping()
    public CategoryDTO update(@RequestBody CategoryDTO newCategory) {
        return categoryService.update(newCategory);
    }

    @DeleteMapping(path = "/{categoryId}")
    public ResponseEntity<String> remove(@PathVariable(name = "categoryId") long categoryId) {

        boolean isRemoved = categoryService.remove(categoryId);

        String deletedMessage = "Category with id: '" + categoryId + "' was deleted!";
        String notDeletedMessage = "Category with id: '" + categoryId + "' does not exists!";
        return isRemoved ?
                new ResponseEntity(deletedMessage, HttpStatusCode.valueOf(200)):
                new ResponseEntity(notDeletedMessage, HttpStatusCode.valueOf(404));
    }
}
