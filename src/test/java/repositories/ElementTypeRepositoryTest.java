package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementTypeRepositoryTest {

@Autowired
    private ElementTypeRepository elementTypeRepository;


//    private final ElementTypeRepository elementTypeRepository;
//
//    public ElementTypeRepositoryTest(ElementTypeRepository elementTypeRepository) {
//        this.elementTypeRepository = elementTypeRepository;
//    }



    @Test
    public void testFindByElementTypeName() {
        ElementType elementTypeName = new ElementType("FindOneTest");
        elementTypeRepository.save(elementTypeName);

        ElementType foundByElementType = elementTypeRepository.findByElementTypeName("FindOneTest");

        assertEquals(elementTypeName.getId(), foundByElementType.getId());
}

@Test
    public void testFindAllByElementTypeName() {
        ElementType elType1 = new ElementType("FindAllTest");
        elementTypeRepository.save(elType1);
        ElementType elType2 = new ElementType("FindAllTest");
        elementTypeRepository.save(elType2);
        ElementType elType3 = new ElementType("FindAllTest");
        elementTypeRepository.save(elType3);

    List<ElementType> foundAllByElementType = elementTypeRepository.findAllByElementTypeName("FindAllTest");

    assertEquals(3, foundAllByElementType.size());
}


@Test
    public void testFindByElementTypeId() {
        ElementType elementTypeId = new ElementType("2");
        elementTypeRepository.save(elementTypeId);

        ElementType foundById = elementTypeRepository.findById(2);

        assertEquals(elementTypeId.getId(), foundById.getId());

    }

@Test
    public void testFindFirst3ByElementTypeName() {
        ElementType elFirstThree1 = new ElementType("FindFirstThree");
        elementTypeRepository.save(elFirstThree1);
        ElementType elFirstThree2 = new ElementType("FindFirstThree");
        elementTypeRepository.save(elFirstThree2);
        ElementType elFirstThree3 = new ElementType("FindFirstThree");
        elementTypeRepository.save(elFirstThree3);

        List<ElementType> foundFirstThreeByName = elementTypeRepository.findFirst3ByElementTypeName("FindFirstThree");

        assertEquals(-1, foundFirstThreeByName.indexOf("A"));


}

@Test
    public void testCountAllByElementTypeName() {
        ElementType elCount1 = new ElementType("CountAll");
        elementTypeRepository.save(elCount1);
        ElementType elCount2 = new ElementType("CountAll");
        elementTypeRepository.save(elCount2);
        ElementType elCount3 = new ElementType("CountAll");
        elementTypeRepository.save(elCount3);

        List<ElementType> foundCountOfAll = elementTypeRepository.countAllByElementTypeName("CountAll");

        assertEquals(1, foundCountOfAll.size());
}


}