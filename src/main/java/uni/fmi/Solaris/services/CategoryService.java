package uni.fmi.Solaris.services;

import org.springframework.stereotype.Service;
import uni.fmi.Solaris.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Override
    public List<CategoryDTO> getAll(){
        CategoryDTO categoryDTO1 = new CategoryDTO();
        categoryDTO1.setId(1);
        categoryDTO1.setName("category 1");
        categoryDTO1.setVatPercent(20);

        CategoryDTO categoryDTO2 = new CategoryDTO();
        categoryDTO2.setId(2);
        categoryDTO2.setName("category 2");
        categoryDTO2.setVatPercent(10);
        //categoryDTO2.setParent(categoryDTO1);

        categoryDTO1.setChildren(Arrays.asList(categoryDTO2));

        List<CategoryDTO> result = new ArrayList<>();
        result.add(categoryDTO1);
        return result;
    }

}
